import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/book';
import { LoginserviceService } from 'src/app/services/loginservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public loggedIn = false;
  user: any;
  book = new Book();
  constructor(private route: Router, private actRoute: ActivatedRoute, private loginservice: LoginserviceService) { }
  ngOnInit(): void {

    this.loggedIn = this.loginservice.isLoggedIn();
    this.user = localStorage.getItem("user");
    console.log("this is home user " + this.user);
   
  }
  searchBook(book: Book) {
  // let  bookTitle= book.bookTitle;
  // let  author= book.author;
  // let  publisher= book.publisher;
    // this.route.navigate(['viewAllBooks', bookTitle, author, publisher]);
console.log("this is book from arg" + book.bookTitle);
console.log("this is book from this.book" + this.book.bookTitle);

    this.route.navigateByUrl('/viewAllBooks', { state: this.book });
  }

  resetForm() {
   
    
  }
}
