import { Action } from "@ngrx/store";
import { Student } from "src/app/model/student.model";
import { AppliedStudentsActionType, AppliedStudentType } from "../actions/applied-students.action";

const initialState: Student[] = [];

export function appliedStudentReducer(state: Student[]=initialState, action: Action){
    if(action.type == AppliedStudentsActionType.APPLIED_STUDENTS_ACTION){
        return (action as AppliedStudentType).payload;
    }
    return state;
}