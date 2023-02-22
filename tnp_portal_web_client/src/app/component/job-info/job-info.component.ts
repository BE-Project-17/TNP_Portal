import { Component, EventEmitter, Input, Output, ViewChild, ElementRef } from '@angular/core';
import {jsPDF} from 'jspdf';
import { Job } from 'src/app/model/job.model';
import { Student } from 'src/app/model/student.model';
import { HttpServiceService } from 'src/app/service/http-service.service';
import { environment } from 'src/environments/environment';
import * as XLSX from 'xlsx';

@Component({
  selector: '[app-job-info]',
  templateUrl: './job-info.component.html',
  styleUrls: ['./job-info.component.css']
})
export class JobInfoComponent {

  @Input() job: Job;
  @Input() index: number;
  @Output() deleteJobReqSend: EventEmitter<string> = new EventEmitter<string>();

  @ViewChild('appliedStudentContent') content: ElementRef;

  students: Student[];

  constructor(private service: HttpServiceService){
    this.students = [];
    
  }

  viewAppliedStudents(): void{
    this.service.getRequest(environment.apiBaseUrl+"/student/applied-students/"+this.job.id)
    .subscribe((response)=>{
      if(response.status == 200){
        this.students = response.body;
      }
    });
  }

  deleteJob(): void{
    this.deleteJobReqSend.emit(this.job.id);
  }

  savePDF(): void{
    let content = this.content.nativeElement;
    let doc = new jsPDF('l','pt','a2',true);
    
    doc.html(content.innerHTML).then(()=>{
      for(var i=0;i<8;i++){
        doc.deletePage(doc.getNumberOfPages());
      }
      doc.save('applied_students.pdf');
      doc.output("dataurlnewwindow");
    });
  }

  saveExcel(): void{
    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(this.content.nativeElement);
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb,ws,'Sheet1');
    XLSX.writeFile(wb,'applied_students.xlsx');
  }


}
