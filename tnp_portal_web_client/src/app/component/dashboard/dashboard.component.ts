import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { DashboardInfo } from 'src/app/model/dashboard-info.model';
import { HttpServiceService } from 'src/app/service/http-service.service';
import { DashboardInfoAction } from 'src/app/store/actions/dashboard-info.action';
import { LoadingAction } from 'src/app/store/actions/loading.action';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  isLoading: boolean = false;
  dashboardInfo: DashboardInfo;

  constructor(private store: Store<any>, private service: HttpServiceService){
    this.store.select("loader").subscribe((data)=>{
      this.isLoading = data;
    });
    
    this.dashboardInfo = new DashboardInfo();
  
    this.store.select("dashboardInfo").subscribe((data)=>{
      this.dashboardInfo = data;
      console.log(this.dashboardInfo);
      
    });

    this.fetchBasicInfo();

  }

  fetchBasicInfo(): void{
    this.store.dispatch(new LoadingAction(true));
    this.service.getRequest(environment.apiBaseUrl+"/dashboard/info").subscribe((response)=>{
      if(response.status == 200){
        this.store.dispatch(new LoadingAction(false));
        this.store.dispatch(new DashboardInfoAction(response.body));
      }
    });
  }

}
