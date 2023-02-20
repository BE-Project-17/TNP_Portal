import { Component } from '@angular/core';
import { Company } from 'src/app/model/company.model';
import { HttpServiceService } from 'src/app/service/http-service.service';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { LoadingAction } from 'src/app/store/actions/loading.action';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent {

  endpoint: string = "/company";

  company: Company;
  isLoading: boolean = false;

  constructor(private service: HttpServiceService, private router: Router, private store: Store<any>){

    this.company = new Company();
    
    this.store.select("loader").subscribe((data)=>{
      this.isLoading = data;
    });
    this.isLoading = false;
  }

  addCompany():void{
    
    if(this.validate()){
      this.store.dispatch(new LoadingAction(true));
      this.service.postRequest(environment.apiBaseUrl+this.endpoint+"/add",this.company).subscribe(
        (response)=>{
          if(response.status == 201){
            this.store.dispatch(new LoadingAction(false));
            this.router.navigate(['/companies']);
          }
        }
      )
    }

  }

  validate():boolean{

    if(this.company.email == undefined || this.company.email == "" || 
      this.company.name == undefined || this.company.name == "" ||
      this.company.url == undefined || this.company.url == "" || 
      this.company.address == undefined || this.company.address == ""
    ){
      alert("Enter non-empty data");
      return false;
    }

    return true;
  }

}
