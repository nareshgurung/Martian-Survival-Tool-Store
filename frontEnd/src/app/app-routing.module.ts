import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoriesComponent } from './components/categories/categories.component';
import { LoginComponent } from './components/login/login.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { ProductsbycategoryComponent } from './components/productsbycategory/productsbycategory.component';

const routes: Routes = [
  {path: 'categories',component: CategoriesComponent},
  {path: '',redirectTo: '/login', pathMatch: 'full'},
  {path: 'login',component: LoginComponent},
  {path: 'dashboard', component: UserDashboardComponent},
  {path: 'products/all/:id', component: ProductsbycategoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
