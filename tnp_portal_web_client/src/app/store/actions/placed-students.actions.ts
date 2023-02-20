import { Action } from "@ngrx/store";
import { Student } from "src/app/model/student.model";

export enum PlacedStudentActionType{
    PLACED_STUDENT_ACTION = "[GET] Get all students data"
}

export class PlacedStudentAction implements Action{
    type: string = PlacedStudentActionType.PLACED_STUDENT_ACTION;
    constructor(public payload: Student[]){

    }
}

export type PlacedStudentType = PlacedStudentAction;