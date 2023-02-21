import { Action } from "@ngrx/store";
import { Job } from "src/app/model/job.model";
import { JobActionType, JobType } from "../actions/job.action";

const initialState: Job[] = [];

export function jobReducer(state: Job[] = initialState, action: Action){
    if(action.type == JobActionType.JOB_ACTION){
        return (action as JobType).payload;
    }
    return state;
}