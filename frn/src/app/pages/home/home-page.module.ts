import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { NbSidebarModule, NbLayoutModule, NbSidebarService } from '@nebular/theme';
import {LoginModule} from "../login/login.module";

@NgModule({
  imports: [
    CommonModule,
    NbLayoutModule,
    NbSidebarModule,
    LoginModule
  ],
  declarations: [HomeComponent],
  providers: [NbSidebarService]
})
export class HomePageModule { }
