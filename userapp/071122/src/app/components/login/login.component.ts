import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from 'src/app/services/loginservice.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();


  credentials = {
    username: '',
    password: ''

  }
  constructor(private loginservice: LoginserviceService) { }

  ngOnInit(): void {
  }
  onSubmit() {

    console.log(this.user);
    if (this.user.password != null && this.user.password != '' && this.user.userName != null && this.user.userName != '') {
      console.log("Ready to send credentials");
      this.loginservice.performLogin(this.user).subscribe(
        result => {
          console.log("suceed");
          this.user = result;
          window.location.href = "/home";
          this.loginservice.loginUser(this.user);
        },
        error => {
          console.log("error occured")


        }

      )
    } else {

      console.log("credentials are not okay");

    }

  }
}
