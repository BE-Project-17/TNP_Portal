import { Action } from "@ngrx/store";
import { Student } from "src/app/model/student.model";

export enum StudentActionType{
    STUDENT_ACTION = "[GET] Get all students data"
}

export class StudentAction implements Action{
    type: string = StudentActionType.STUDENT_ACTION;
    constructor(public payload: Student[]){

    }
}

export type StudentType = StudentAction;