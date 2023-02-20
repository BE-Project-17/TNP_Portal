import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { HttpServiceService } from 'src/app/service/http-service.service';
import { ActivatedRoute , Router} from '@angular/router';
import { Student } from 'src/app/model/student.model';
import { environment } from 'src/environments/environment';
import { StudentAction } from 'src/app/store/actions/students.actions';
import { PlacedStudentAction } from 'src/app/store/actions/placed-students.actions';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent {

  students: Student[];
  endpoint: string = "/student";

  placed: boolean;

  constructor(private service: HttpServiceService, private store: Store<any>, private route: ActivatedRoute, private router: Router){

    this.students = [];

    this.route.paramMap.subscribe((data)=>{
      this.placed = ( data.get("placed") == "true" ? true : false);
      this.fetchStudents();
    });
    
    this.store.select("student").subscribe((data)=>{
      this.students = data;
    });
    this.store.select("placedStudent").subscribe((data)=>{
      this.students = data;
    });

  }

  onViewInfoClick(student: Student): void{
    this.router.navigate(['/student-info',JSON.stringify(student)]);
  }

  fetchStudents(): void{
    if(this.placed){
      this.service.getRequest(environment.apiBaseUrl+this.endpoint+"/placed").subscribe((response)=>{
        if(response.status == 200){
          this.store.dispatch(new PlacedStudentAction(response.body));
        };
      })
    }else{
      this.service.getRequest(environment.apiBaseUrl+this.endpoint).subscribe((response)=>{
        if(response.status == 200){
          this.store.dispatch(new StudentAction(response.body));
        };
      })
    }
  }

  isStudentsEmpty():boolean{
    return this.students == undefined ? true : this.students.length == 0;
  }

}
