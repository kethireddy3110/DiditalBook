import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/book';
import { LoginserviceService } from 'src/app/services/loginservice.service';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent implements OnInit {
  public loggedIn = false;
  user: any;

  book = new Book();
  constructor(private route: Router, private actRoute: ActivatedRoute, private loginService: LoginserviceService,   
    private router: Router,
    private httpClient: HttpClient) { }


  public selectedFile: any;
  imgURL: any;
  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
    this.user = localStorage.getItem("user");

    this.book.authorId = this.actRoute.snapshot.params['id'];
    console.log(this.book.authorId)
    if(this.book.authorId){
  this.loginService.getBookById(this.book.authorId).subscribe(data => {
  
    this.book = data;
    // this.book.logoByte=this.book.logo;
    // this.book.logo = 'data:image/jpeg;base64,' + this.book.logo;
    
  }, error => console.log(error));
}

  }

  saveBook() {
   // if(this.selectedFile!=null){
    //this.book= new Book();
    this.book.createdBy =this.user;


    const uploadData = new FormData();
    uploadData.append('logo', this.selectedFile, this.selectedFile.name);
    this.selectedFile.imageName = this.selectedFile.name;
console.log("Checking book content"+this.book);
    this.httpClient.post('http://ctsuserservice6.ap-northeast-1.elasticbeanstalk.com/user/upload/logo', uploadData, { observe: 'response' })
      .subscribe((response) => {
        if (response.status === 200) {
          this.loginService.createBook(this.book).subscribe(
            (book) => {
              this.router.navigate(['home']);
            }
          );
          alert("Data added successfully");
          console.log('Image uploaded successfully');
        } else {
          console.log('Image not uploaded successfully');
          alert("Book addition failed");
        }
      }
      );

    //}
    // else{
    //   this.addBookSubmit();

    // }
  }
  addBookSubmit() {
    console.log("logobyte"+this.book.logoByte);

    //this.book.logo=this.book.logoByte;
    this.loginService.createBook(this.book).subscribe
      (
        data => {
          console.log("Data added successfully");
          alert("Data added successfully");
          this.route.navigate(['home']);
        },
        error =>{ console.log("Error while adding book");
        alert("Data addition failed");
      }
      )
  }
  gotoHome() {
    this.route.navigate(['home']);
  }
  public onFileChanged(event:any) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    // Below part is used to display the selected image
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };

  }
}
