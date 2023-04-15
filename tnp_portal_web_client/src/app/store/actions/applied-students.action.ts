import { Action } from "@ngrx/store";
import { Student } from "src/app/model/student.model";

export enum AppliedStudentsActionType{
    APPLIED_STUDENTS_ACTION = "[GET] Get all applied students"
}

export class AppliedStudentAction implements Action{
    type: string = AppliedStudentsActionType.APPLIED_STUDENTS_ACTION;
    constructor(public payload: Student[]){

    }
}

export type AppliedStudentType = AppliedStudentAction;