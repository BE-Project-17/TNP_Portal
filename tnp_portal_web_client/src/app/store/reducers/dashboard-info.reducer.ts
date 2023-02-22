import { Action } from "@ngrx/store";
import { DashboardInfo } from "src/app/model/dashboard-info.model";
import { DashboardInfoActionType, DashboardInfoType } from "../actions/dashboard-info.action";

const initialState: DashboardInfo = {
    noOfCompanies: -1,
    noOfPlacedStudents: -1,
    noOfUnplacedStudents: -1
}

export function dashboardInfoReducer(state: DashboardInfo = initialState, action: Action){
    if(action.type == DashboardInfoActionType.DASHBOARD_INFO_ACTION){
        return (action as DashboardInfoType).payload;
    }
    return state;
}