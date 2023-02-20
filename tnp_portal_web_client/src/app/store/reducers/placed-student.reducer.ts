import { Action } from "@ngrx/store";
import { Student } from "src/app/model/student.model";
import { PlacedStudentActionType, PlacedStudentType } from "../actions/placed-students.actions";

const initialState: Student[] = [];

export function placedStudentReducer(state: Student[]=initialState, action: Action){
    if(action.type == PlacedStudentActionType.PLACED_STUDENT_ACTION){
        return (action as PlacedStudentType).payload;
    }
    return state;
}
