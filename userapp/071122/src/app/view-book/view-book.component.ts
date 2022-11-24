import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book';
import { LoginserviceService } from '../services/loginservice.service';

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit {
  // @Input()
  // book!: Book;
  book: Book = new Book(); 
  authorId: any;
  constructor(private router: Router, private actroute: ActivatedRoute, private loginService: LoginserviceService) { }

  ngOnInit(): void {
    this.book = new Book();
    
    this.authorId = this.actroute.snapshot.params['id'];
    console.log("checking id "+ this.authorId);
    this.loginService.getBookById(this.authorId)
      .subscribe(data => {
        console.log("this is chapter data check"+data.author)
        this.book = data;
//for showing image
this.book.logo = 'data:image/jpeg;base64,' + this.book.logo;
this.book.logoByte=this.book.logo;




      }, error => console.log(error));

  }

  gotoList(){

    this.router.navigate(['viewAllBooks']);
  }

}
