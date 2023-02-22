import { Action } from "@ngrx/store";

export enum LoginActionType{
    LOGIN_ACTION = "[GET] Login Action"
}

export class LoginAction implements Action{
    type: string = LoginActionType.LOGIN_ACTION;
    constructor(public payload: boolean){

    }
}

export type LoginType = LoginAction;