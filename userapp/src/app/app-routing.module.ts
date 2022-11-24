import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

import { AuthGuard } from './auth.guard';
import { RegisterComponent } from './register/register.component';
import { AddbookComponent } from './components/addbook/addbook.component';
import { ViewAllBooksComponent } from './view-all-books/view-all-books.component';
import { SearchbookComponent } from './searchbook/searchbook.component';
import { ViewBookComponent } from './view-book/view-book.component';


const routes: Routes = [
{
path:'',
component: HomeComponent,
pathMatch:'full'

},
{
  path:'home',
  component: HomeComponent,
  pathMatch:'full',
  
  
  },

{
  path:'login',
  component: LoginComponent,
  pathMatch:'full'
  
  },
  {
    path:'register',
    component: RegisterComponent,
    pathMatch:'full'
    
    },

    {
      path:'searchBook',
      component: SearchbookComponent,
      pathMatch:'full'

      },

      {
        path:'viewBook/:id',
        component: ViewBookComponent,
        pathMatch:'full',
        canActivate: [AuthGuard]
        },

        {
          path:'addBook/:id',
          component: AddbookComponent
          
          },
        
  // {
  //   path:'dashboard',
  //   component: DashboardComponent,
  //   pathMatch:'full',
  //   canActivate: [AuthGuard]
    
  //   },
    {
      path:'viewAllBooks',
      component: ViewAllBooksComponent,
      pathMatch:'full',
      },

    
    {
      path:'addbook',
      component: AddbookComponent,
      pathMatch:'full',
      canActivate: [AuthGuard]
      
      }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
