import { Component } from '@angular/core';
import { Student } from 'src/app/model/student.model';
import { HttpServiceService } from 'src/app/service/http-service.service';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { LoadingAction } from 'src/app/store/actions/loading.action';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent {
  
  endpoint: string = "/student";

  student:Student;
  isLoading:boolean = false;

  constructor(private service: HttpServiceService, private router: Router, private store: Store<any>){
    this.student = new Student();
    this.student.placed = false;

    this.store.select("loader").subscribe((data)=>{
      this.isLoading = data;
    });
    
  }

  addStudent(): void{
    if(this.validate()){
      this.store.dispatch(new LoadingAction(true));
      this.service.postRequest(environment.apiBaseUrl+this.endpoint+"/add",this.student).subscribe(
        (response)=>{
          if(response.status == 201){
            this.store.dispatch(new LoadingAction(false));
            this.router.navigate(['/students',false]);
          }
        }
      );
    }
  }

  validate():boolean{

    if(this.student.email == "" || this.student.password == "" ||
      this.student.name == "" || this.student.rollNo == null ||
      this.student.ssc == null || this.student.hsc == null || this.student.cgpa == null || this.student.branch == null || 
      this.student.quantitative_score == null ||  this.student.logical_reasoning_score == null ||
      this.student.english_prof_score == null ||  this.student.automata_pro_score == null || 
      this.student.computer_science_score == null ||  this.student.backlogs == null || 
      this.student.internships == null ||  this.student.projects == null
    ){
      alert("Enter non-empty data");
      return false;
    }

    if(this.student.backlogs < 0 || this.student.internships < 0 || this.student.projects<0 ||
      this.student.ssc < 0  || this.student.hsc < 0 || this.student.cgpa < 0 || 
      this.student.quantitative_score < 0 ||  this.student.logical_reasoning_score < 0 ||
      this.student.english_prof_score < 0 ||  this.student.automata_pro_score < 0  || 
      this.student.computer_science_score < 0 
      ){
        alert("Enter non-negative data");
      return false;
    }

    if(this.student.ssc > 100  || this.student.hsc > 100 || this.student.cgpa > 10){
      alert("Enter valid data for Educational Details Field");
      return false;
    }

    if(this.student.quantitative_score > 100 ||  this.student.logical_reasoning_score > 100 ||
      this.student.english_prof_score > 100 ||  this.student.automata_pro_score > 100  || 
      this.student.computer_science_score > 100){
        alert("Enter valid data for AmCAT Details Field");
      return false;
      }

    return true;
  }

}
