import { throwError } from "rxjs";

export function handleError(err: any){
    let errorMessage = "";
    if(err.error instanceof ErrorEvent){
        // Client side or network error
        errorMessage =  `An error occurred: ${err.message}`;
    }else{
        // Backend returned unsuccessfull response code
        errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`
    }
    console.log(errorMessage);
    return throwError(()=>errorMessage);
    
}