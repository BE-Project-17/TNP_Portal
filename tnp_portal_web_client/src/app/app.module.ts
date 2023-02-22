import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { StoreModule } from '@ngrx/store';
import { loadingReducer } from './store/reducers/loading.reducer';
import { AddStudentComponent } from './component/add-student/add-student.component';

import { HttpClientModule } from '@angular/common/http';
import { StudentsComponent } from './component/students/students.component'
import { studentReducer } from './store/reducers/student.reducer';
import { placedStudentReducer } from './store/reducers/placed-student.reducer';
import { StudentInfoComponent } from './component/student-info/student-info.component';
import { AddCompanyComponent } from './component/add-company/add-company.component';
import { CompaniesComponent } from './component/companies/companies.component';
import { companyReducer } from './store/reducers/company.reducer';
import { CompanyInfoComponent } from './component/company-info/company-info.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { jobReducer } from './store/reducers/job.reducer';
import { JobInfoComponent } from './component/job-info/job-info.component';
import { AddJobComponent } from './component/add-job/add-job.component';
import { dashboardInfoReducer } from './store/reducers/dashboard-info.reducer';
import { AdminComponent } from './component/admin/admin.component';
import { loginReducer } from './store/reducers/login.reducer';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    AddStudentComponent,
    StudentsComponent,
    StudentInfoComponent,
    AddCompanyComponent,
    CompaniesComponent,
    CompanyInfoComponent,
    JobInfoComponent,
    AddJobComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: "", component: DashboardComponent},
      {path: "add-student", component: AddStudentComponent},
      {path: "students/:placed", component: StudentsComponent},
      {path: "student-info/:student",component: StudentInfoComponent},
      {path: "add-company", component: AddCompanyComponent},
      {path: "companies", component: CompaniesComponent},
      {path: "company-info/:company", component: CompanyInfoComponent},
      {path: "admin/:add_admin", component: AdminComponent},
      {path: "**", redirectTo: ""}
    ]),
    StoreModule.forRoot({
      "loader": loadingReducer,
      "student": studentReducer,
      "placedStudent": placedStudentReducer,
      "company": companyReducer,
      "job": jobReducer,
      "dashboardInfo": dashboardInfoReducer,
      "login": loginReducer
    }),
    NoopAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
