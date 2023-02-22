import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { HttpServiceService } from 'src/app/service/http-service.service';
import { LoginAction } from 'src/app/store/actions/login.action';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {

  add_admin: boolean;

  username: string;
  password: string;
  confirmPassword: string;

  constructor(private route: ActivatedRoute, private service: HttpServiceService, private store: Store<any>, private router: Router){
    this.initialize();
    this.route.paramMap.subscribe((data)=>{
      this.add_admin = ( data.get("add_admin") == "true" ? true : false);
    });

    this.store.select("login")
    .subscribe((data)=>{
      if(data){
        this.router.navigate(['/']);
      }
    })
  }

  initialize(): void{
    this.username = "";
    this.password = "";
    this.confirmPassword = "";
  }

  login(): void{
    this.service.postRequest(environment.apiBaseUrl+"/admin/login",{"username":this.username,"password":this.password})
    .subscribe((response)=>{
      console.log(response.status);
      
      if(response.status == 200){
        this.store.dispatch(new LoginAction(true));
      }else if(response.status == 404){
        alert(`Admin with username: ${this.username} does not exist`);
      }else if(response.status == 401){
        alert('Incorrect password');
      }
    });
    this.initialize();
  }

  addAdmin(): void{
    this.service.postRequest(environment.apiBaseUrl+"/admin/add",{"username":this.username,"password":this.password})
    .subscribe((response)=>{
      if(response.status == 201){
        this.store.dispatch(new LoginAction(true));
      }else{
        alert('Admin Creation Failed')
      }
    });
    this.initialize();
  }

  onClickBtn(): void{
    if(this.add_admin){
      if(this.username == "" || this.password == "" || this.confirmPassword == ""){
        alert('Enter non-empty fields');
        return ;
      }
      if(this.password != this.confirmPassword){
        alert("Password and Confirm Password doesn't match");
        return ;
      }
      this.addAdmin();
    }else{
      if(this.username == "" || this.password == ""){
        alert('Enter non-empty fields');
        return ;
      }
      this.login();
    }
  }
}
