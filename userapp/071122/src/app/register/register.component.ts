import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginserviceService } from '../services/loginservice.service';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  user = new User();

  constructor(private actRoute: ActivatedRoute, private loginService: LoginserviceService) { }

  ngOnInit(): void {
  }
  addNewUser() {

    this.loginService.createUser(this.user).subscribe
      (
        data => {
          console.log("Registered successfully");
          alert("Registered successfully");
          window.location.href = "/home";
        },
        error => {

          console.log("Error while creating user");
          alert("Could not register, please try again");
        }

      )

  }
}
