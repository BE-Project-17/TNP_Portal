import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { LoginAction } from './store/actions/login.action';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isLoggedIn: boolean;
  constructor(private router: Router, private store: Store<any>){
    this.store.select("login")
    .subscribe((data)=>{
      this.isLoggedIn = data;
      if(!data){
        this.router.navigate(['/admin',false]);
      }else{
        this.router.navigate(['/']);
      }
    })
  }

  logout(): void{
    this.store.dispatch(new LoginAction(false));
  }
}
