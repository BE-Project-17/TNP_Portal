import { Action } from "@ngrx/store";
import { DashboardInfo } from "src/app/model/dashboard-info.model";

export enum DashboardInfoActionType{
    DASHBOARD_INFO_ACTION="[GET] Dashboard info"
}

export class DashboardInfoAction implements Action{
    type: string = DashboardInfoActionType.DASHBOARD_INFO_ACTION;
    constructor(public payload: DashboardInfo){

    }
}

export type DashboardInfoType = DashboardInfoAction;