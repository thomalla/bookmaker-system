import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';

import { PagesRoutingModule } from './pages-routing.module';
import { ThemeModule } from '../@theme/theme.module';
import {HomePageModule} from './home/home-page.module';
import {RestService} from '../utils/rest.service';
import {RegisterModule} from "./register/register.module";
import {LoginModule} from "./login/login.module";


const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    HomePageModule,
    RegisterModule,
    LoginModule
  ],
  declarations: [
    ...PAGES_COMPONENTS,
  ],
  providers: [
    RestService
  ]
})
export class PagesModule {
}
