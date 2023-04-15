import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { Company } from 'src/app/model/company.model';
import { Job } from 'src/app/model/job.model';
import { HttpServiceService } from 'src/app/service/http-service.service';
import { BranchCheckbox } from 'src/app/shared/branch-checkbox';
import { GenderCheckbox } from 'src/app/shared/gender-checkbox';
import { JobAction } from 'src/app/store/actions/job.action';
import { LoadingAction } from 'src/app/store/actions/loading.action';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-company-info',
  templateUrl: './company-info.component.html',
  styleUrls: ['./company-info.component.css']
})
export class CompanyInfoComponent {

  company: Company;

  isLoading: boolean;

  addJobEndPoint: string = "/company/add-job";

  jobList: Job[];

  constructor(private route: ActivatedRoute, private service: HttpServiceService, private store: Store<any>){
    this.jobList = [];
    this.isLoading = false;
    this.company = JSON.parse(this.route.snapshot.paramMap.get('company') || "");
    
    this.store.select("loader")
    .subscribe((data)=>{
      this.isLoading = data;
    });

    this.store.select("job")
    .subscribe((data)=>{
      this.jobList = data;
    });

    this.fetchJobsList(this.company.id);

  }

  addJob(job: Job): void{

    this.store.dispatch(new LoadingAction(true));

    this.service.putRequest(environment.apiBaseUrl+this.addJobEndPoint+"/"+this.company.id,job)
    .subscribe((response)=>{
      if(response.status == 200){
        this.store.dispatch(new LoadingAction(false));
        this.fetchJobsList(this.company.id);
      }
    });    
    
  }
  fetchJobsList(company_id: string): void{
    this.service.getRequest(environment.apiBaseUrl+"/job/"+company_id).subscribe((response)=>{
      if(response.status == 200){
        this.store.dispatch(new JobAction(response.body));
      }
    })
  }

  onDeleteJobReq(id: string): void{
    this.store.dispatch(new LoadingAction(true));
    this.service.deleteRequest(environment.apiBaseUrl+"/job/"+id).subscribe((response)=>{
      if(response.status == 200){
        this.store.dispatch(new LoadingAction(false));
        this.fetchJobsList(this.company.id);
      }
    })
  }

}
