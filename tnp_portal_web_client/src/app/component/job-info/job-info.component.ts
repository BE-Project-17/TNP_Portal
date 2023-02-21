import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Job } from 'src/app/model/job.model';

@Component({
  selector: '[app-job-info]',
  templateUrl: './job-info.component.html',
  styleUrls: ['./job-info.component.css']
})
export class JobInfoComponent {

  @Input() job: Job;
  @Input() index: number;
  @Output() deleteJobReqSend: EventEmitter<string> = new EventEmitter<string>();

  deleteJob(): void{
    this.deleteJobReqSend.emit(this.job.id);
  }


}
