import { Action } from "@ngrx/store";
import { Company } from "src/app/model/company.model";

export enum CompanyActionType{
    COMPANY_ACTION = "[GET] Get all companies data"
}

export class CompanyAction implements Action{
    type: string = CompanyActionType.COMPANY_ACTION;
    constructor(public payload: Company[]){

    }
}

export type CompanyType = CompanyAction;