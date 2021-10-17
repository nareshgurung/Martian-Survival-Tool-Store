import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoriesComponent } from './components/categories/categories.component';
import { LoginComponent } from './components/login/login.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { ProductsbycategoryComponent } from './components/productsbycategory/productsbycategory.component';
import { CommentsComponent } from './components/comments/comments.component';
import { GroupsComponent } from './components/groups/groups.component';
import { GroupContentsComponent } from './components/group-contents/group-contents.component';
import { SignupComponent } from './components/signup/signup.component';
import { ErrorMessageComponent } from './components/error-message/error-message.component';
import { ProductPageComponent } from './components/product-page/product-page.component';
import { CartComponent } from './components/cart/cart.component';
import { ShippingComponent } from './components/shipping/shipping.component';
import { UserSettingsComponent } from './components/user-settings/user-settings.component';
import { EditGroupsComponent } from './components/edit-groups/edit-groups.component';
import { PreviousOrdersComponent } from './components/previous-orders/previous-orders.component';

const routes: Routes = [
  {path: 'categories',component: CategoriesComponent},
  {path: '',redirectTo: '/login', pathMatch: 'full'},
  {path: 'login',component: LoginComponent},
  {path: 'dashboard', component: UserDashboardComponent},
  { path: 'cart', component: CartComponent },
  { path: 'shipping', component: ShippingComponent },
  {path: 'products/all/:id', component: ProductsbycategoryComponent},
  {path: 'comments', component: CommentsComponent},
  {path: 'groups/:userID', component: GroupsComponent},
  {path: 'group_contents/:userID/:groupID', component: GroupContentsComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'error', component: ErrorMessageComponent},
  {path: 'products/id/:id', component: ProductPageComponent},
  {path: 'settings', component: UserSettingsComponent},
  {path: 'editgroups', component: EditGroupsComponent},
  {path: 'previousOrders', component: PreviousOrdersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
