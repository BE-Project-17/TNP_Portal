import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Student } from 'src/app/model/student.model';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent {

  student: Student;

  constructor(private route: ActivatedRoute){
    this.student = JSON.parse(this.route.snapshot.paramMap.get("student") ?? "");
    console.log(this.student);
    
  }

}
