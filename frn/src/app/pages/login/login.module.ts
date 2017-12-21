import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login.component';
import {FormsModule} from "@angular/forms";
import {ThemeModule} from "../../@theme/theme.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ThemeModule
  ],
  declarations: [LoginComponent],
  exports: [
    LoginComponent
  ]
})
export class LoginModule { }
