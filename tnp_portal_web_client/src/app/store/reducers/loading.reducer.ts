import { Action } from "@ngrx/store";
import { LoadingActionType, LoadType } from "../actions/loading.action";

const initialState: boolean = false;

export function loadingReducer(state: boolean = initialState, action: Action){
    if(action.type == LoadingActionType.LOADING_ACTION){
        return (action as LoadType).payload;
    }
    return state;
}