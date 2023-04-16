import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { Chart } from 'chart.js/auto';
import { DashboardInfo } from 'src/app/model/dashboard-info.model';
import { FeatureImportance, PredictedData } from 'src/app/model/feature-importance.model';
import { HttpServiceService } from 'src/app/service/http-service.service';
import { DashboardInfoAction } from 'src/app/store/actions/dashboard-info.action';
import { LoadingAction } from 'src/app/store/actions/loading.action';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  isLoading: boolean = false;
  dashboardInfo: DashboardInfo;
  labels: string[] = [
    "CS", "EnTC", "IT", "Automata Score", "Backlogs", "CGPA", "Computer Science Score", "English Proficiency", "Gender", "HSC", "Internships", "Logical Reasoning", "Projects", "Quantitative Ability", "SSC"
  ];

  barColor: string[] = [
    'rgba(255, 99, 132, 0.8)',
    'rgba(54, 162, 235, 0.8)',
    'rgba(255, 206, 86, 0.8)',
    'rgba(75, 192, 192, 0.8)',
  ]

  featureImportanceData: FeatureImportance;

  constructor(private store: Store<any>, private service: HttpServiceService){
    this.store.select("loader").subscribe((data)=>{
      this.isLoading = data;
    });
    this.dashboardInfo = new DashboardInfo();
  
    this.store.select("dashboardInfo").subscribe((data)=>{
      this.dashboardInfo = data;      
    });

    this.fetchBasicInfo();
    this.fetchFeatureImportance();
  }

  fetchFeatureImportance(): void{
    this.service.getRequest("http://localhost:5000/api/impfeaturesRF").subscribe((response)=>{
      this.featureImportanceData = response.body;
      this.buildCharts();
      console.log(this.featureImportanceData);
    })
  }

  fetchBasicInfo(): void{
    this.store.dispatch(new LoadingAction(true));
    this.service.getRequest(environment.apiBaseUrl+"/dashboard/info").subscribe((response)=>{
      if(response.status == 200){
        this.store.dispatch(new LoadingAction(false));
        this.store.dispatch(new DashboardInfoAction(response.body));
      }
    });
  }

  buildCharts(): void{
    this.createGraph("Product Chart",this.featureImportanceData.Product,0);
    this.createGraph("FinTech Chart",this.featureImportanceData.FinTech,1);
    this.createGraph("Service Chart",this.featureImportanceData.Service,2);
    this.createGraph("Startup Chart",this.featureImportanceData.Startup,3);
  }

  createGraph(chartName:string, featureData: PredictedData, index: number): void{

    var chart = new Chart(chartName,{
      type: 'bar',
      data: {
        labels: this.labels,
        datasets: [{
          label: 'Percentage',
          data: [
            featureData.CS*100,
            featureData.EnTC*100,
            featureData.IT*100,
            featureData.automata_score*100,
            featureData.backlogs*100,
            featureData.cgpa*100,
            featureData.computer_science_score*100,
            featureData.english_proficiency*100,
            featureData.gender*100,
            featureData.hsc*100,
            featureData.internships*100,
            featureData.logical_reasoning*100,
            featureData.projects*100,
            featureData.quantitative_ability*100,
            featureData.ssc*100,
          ],
          backgroundColor: this.barColor[index],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        },
        plugins: {
          legend: {
            title: {
              display: true,
              text: chartName
            }
          }
        }
      }
    })
  }

}
