import { Action } from "@ngrx/store";
import { LoginActionType, LoginType } from "../actions/login.action";

const initialState: boolean = false;

export function loginReducer(state: boolean = initialState, action: Action){
    if(action.type == LoginActionType.LOGIN_ACTION){
        return (action as LoginType).payload;
    }
    return state;
}