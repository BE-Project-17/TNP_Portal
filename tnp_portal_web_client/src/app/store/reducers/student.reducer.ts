import { Action } from "@ngrx/store";
import { Student } from "src/app/model/student.model";
import { StudentActionType, StudentType } from "../actions/students.actions";

const initialState: Student[] = [];

export function studentReducer(state: Student[]=initialState, action: Action){
    if(action.type == StudentActionType.STUDENT_ACTION){
        return (action as StudentType).payload;
    }
    return state;
}
