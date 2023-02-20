import { Component } from '@angular/core';
import { Store } from '@ngrx/store';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  isLoading: boolean = false;

  constructor(private store: Store<any>){
    this.store.select("loader").subscribe((data)=>{
      this.isLoading = data;
    })
  }

}
