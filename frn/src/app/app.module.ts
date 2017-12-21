/**
 * @license
 * Copyright Akveo. All Rights Reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
import { APP_BASE_HREF } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { CoreModule } from './@core/core.module';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ThemeModule } from './@theme/theme.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RegisterService} from "./pages/register/register.service";
import {LoginService} from "./pages/login/login.service";
import {CanActivateAuthGuard} from "./pages/login/can-activate.authguard";

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpModule,
    AppRoutingModule,
    ThemeModule.forRoot(),
    CoreModule.forRoot(),
    FormsModule,
    ReactiveFormsModule
  ],
  bootstrap: [AppComponent],
  providers: [
    { provide: APP_BASE_HREF, useValue: '/' },
    RegisterService,
    LoginService,
    CanActivateAuthGuard

  ],
})
export class AppModule {
}
