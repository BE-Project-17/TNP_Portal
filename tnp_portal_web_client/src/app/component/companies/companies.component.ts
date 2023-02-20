import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { HttpServiceService } from 'src/app/service/http-service.service';
import { Router } from '@angular/router';
import { Company } from 'src/app/model/company.model';
import { environment } from 'src/environments/environment';
import { CompanyAction } from 'src/app/store/actions/company.action';
import { Job } from 'src/app/model/job.model';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent {

  companies: Company[];
  job: Job;
  endpoint: string = "/company";

  constructor(private service: HttpServiceService, private store: Store<any>, private router: Router){
    this.companies = [];
    this.job = new Job();
    this.store.select("company").subscribe((data)=>{
      this.companies = data;
    });
    this.fetchCompanies();
  }

  fetchCompanies(): void{
    this.service.getRequest(environment.apiBaseUrl+this.endpoint).subscribe((response)=>{
      if(response.status == 200){
        this.store.dispatch(new CompanyAction(response.body));
      }
    })
  }

  isCompaniesEmpty(): boolean{
    return this.companies == undefined ? true : this.companies.length == 0;
  }

  deleteCompany(): void{
    // TODO: delete company api call
  }

  viewCompany(company: Company): void{
    this.router.navigate(['/company-info',JSON.stringify(company)]);
  }
}
