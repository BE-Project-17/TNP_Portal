import { Action } from "@ngrx/store";

export enum LoadingActionType{
    LOADING_ACTION = "[LOAD] Loading Action"
}

export class LoadingAction implements Action{
    type: string = LoadingActionType.LOADING_ACTION;
    constructor(public payload: boolean){

    }
}

export type LoadType = LoadingAction;