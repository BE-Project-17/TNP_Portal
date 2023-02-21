import { Action } from "@ngrx/store";
import { Job } from "src/app/model/job.model";

export enum JobActionType{
    JOB_ACTION = "[GET] Get all jobs for company"
}

export class JobAction implements Action{
    type: string = JobActionType.JOB_ACTION;
    constructor(public payload: Job[]){

    }
}

export type JobType = JobAction;