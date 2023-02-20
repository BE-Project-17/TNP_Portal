import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Company } from 'src/app/model/company.model';
import { Job } from 'src/app/model/job.model';

@Component({
  selector: 'app-company-info',
  templateUrl: './company-info.component.html',
  styleUrls: ['./company-info.component.css']
})
export class CompanyInfoComponent {

  job: Job;
  company: Company;

  constructor(private route: ActivatedRoute){
    this.job = new Job();
    this.company = JSON.parse(this.route.snapshot.paramMap.get('company') || "");

  }

  addJob(): void{

  }

}
