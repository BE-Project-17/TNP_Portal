import { Action } from "@ngrx/store";
import { Company } from "src/app/model/company.model";
import { CompanyActionType, CompanyType } from "../actions/company.action";

const initialState: Company[] = [];

export function companyReducer(state: Company[]=initialState, action: Action){
    if(action.type == CompanyActionType.COMPANY_ACTION){
        return (action as CompanyType).payload;
    }
    return state;
}