import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Company } from 'src/app/model/company.model';
import { Job } from 'src/app/model/job.model';
import { BranchCheckbox } from 'src/app/shared/branch-checkbox';
import { GenderCheckbox } from 'src/app/shared/gender-checkbox';

@Component({
  selector: 'app-company-info',
  templateUrl: './company-info.component.html',
  styleUrls: ['./company-info.component.css']
})
export class CompanyInfoComponent {

  job: Job;
  company: Company;

  value: string;

  ugbranch: BranchCheckbox;
  pgbranch: BranchCheckbox;
  gender: GenderCheckbox;

  constructor(private route: ActivatedRoute){
    this.value = "";
    this.job = new Job();
    this.job.skills = [];
    this.ugbranch = new BranchCheckbox();
    this.pgbranch = new BranchCheckbox();
    this.gender = new GenderCheckbox();
    this.company = JSON.parse(this.route.snapshot.paramMap.get('company') || "");

  }

  addJob(): void{
    if(this.job.role == "" || this.job.ctc == null || this.job.registration_end_date_time == "" ){
      alert("Enter non-empty data");
      return;
    }
    console.log("Call Add Job API");
    
  }

  removeKeyword(index: number): void{
    this.job.skills.splice(index,1);
  }

  addKeyword(): void{
    if(this.value!= "" && !this.job.skills.includes(this.value)){
      this.job.skills.push(this.value);
    }
    this.value = "";
  }

}
