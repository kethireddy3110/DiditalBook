import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginserviceService } from "./loginservice.service";
@Injectable()
export class AuthModifier implements HttpInterceptor {

  constructor(private loginservice: LoginserviceService) {

  }
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let newRequest = req;
    let user = localStorage.getItem("user");

    newRequest = newRequest.clone({ setHeaders: { Authorization: `Basic ${user}` } })
    return next.handle(newRequest);
  }

}
