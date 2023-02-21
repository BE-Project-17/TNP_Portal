import { Component, EventEmitter, Output } from '@angular/core';
import { Job } from 'src/app/model/job.model';
import { BranchCheckbox } from 'src/app/shared/branch-checkbox';
import { GenderCheckbox } from 'src/app/shared/gender-checkbox';

@Component({
  selector: 'app-add-job',
  templateUrl: './add-job.component.html',
  styleUrls: ['./add-job.component.css']
})
export class AddJobComponent {

  @Output() sendJob: EventEmitter<Job> = new EventEmitter<Job>()

  job: Job;

  value: string;

  ugbranch: BranchCheckbox;
  pgbranch: BranchCheckbox;
  gender: GenderCheckbox;

  constructor(){
    this.value = "";
    this.job = new Job();
    this.job.skills = [];
    this.ugbranch = new BranchCheckbox();
    this.pgbranch = new BranchCheckbox();
    this.gender = new GenderCheckbox();
    

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

  addJob(): void{
    console.log(this.job.role);
    
    if(this.job.role == undefined || this.job.role == "" || this.job.ctc == null || this.job.registration_end_date_time == "" ||
    this.job.registration_end_date_time == null ){
      alert("Enter non-empty data");
      return;
    }

    this.setGender();
    this.setUGBranch();
    this.setPGBranch();

    this.sendJob.emit(this.job);
    this.job = new Job();
  }

  setGender(): void{
    if(this.gender.both || (this.gender.male && this.gender.female)){
      this.job.gender = "BOTH";
    }else if(this.gender.male){
      this.job.gender = "MALE";
    }else{
      this.job.gender = "FEMALE";
    }
  }

  setUGBranch(): void{
    this.job.ugBranch = [];
    if(this.ugbranch.cse){
      this.job.ugBranch.push("COMPUTER_ENGINEERING");
    }
    if(this.ugbranch.it){
      this.job.ugBranch.push("INFORMATION_TECHNOLOGY");
    }
    if(this.ugbranch.entc){
      this.job.ugBranch.push("EnTC");
    }
  }

  setPGBranch(): void{
    this.job.pgBranch = [];
    if(this.pgbranch.cse){
      this.job.pgBranch.push("COMPUTER_ENGINEERING");
    }
    if(this.pgbranch.it){
      this.job.pgBranch.push("INFORMATION_TECHNOLOGY");
    }
    if(this.pgbranch.entc){
      this.job.pgBranch.push("EnTC");
    }
  }

}
