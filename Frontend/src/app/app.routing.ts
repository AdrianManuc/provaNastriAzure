import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Import Containers
import { DefaultLayoutComponent } from './containers';
import { DettaglioNastroComponent } from './views/dettaglio-nastro/dettaglio-nastro.component';

import { P404Component } from './views/error/404.component';
import { P500Component } from './views/error/500.component';
import { MonitoraggioComponent } from './views/monitoraggio/monitoraggio.component';
import { NastriComponent } from './views/nastri/nastri.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full',
  },
  {
    path: '404',
    component: P404Component,
    data: {
      title: 'Page 404'
    }
  },
  {
    path: '500',
    component: P500Component,
    data: {
      title: 'Page 500'
    },
  },
  {
    path: '',
    component: DefaultLayoutComponent,
    data: {
      title: 'Home'
    },
    children: [
      {
        path: 'dashboard',
        loadChildren: () => import('./views/dashboard/dashboard.module').then(m => m.DashboardModule)
      },
      {
        path: 'nastri',
        component: NastriComponent,
      },
      {
        path: 'monitoraggio',
        component: MonitoraggioComponent,
      },
      {
        path: 'dettaglio-nastro/:id',
        component: DettaglioNastroComponent
      }
    ]
  },
  { path: '**', component: P404Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
