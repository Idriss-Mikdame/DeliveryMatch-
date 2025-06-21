import { Routes } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {RegisterComponent} from './register/register.component';
import {NavComponent} from './nav/nav.component';
import {AddAnnonceComponent} from './Annonce/add-annonce/add-annonce.component';
import {ListAnnonceComponent} from './Annonce/list-annonce/list-annonce.component';
import {UpdatAnnonceComponent} from './Annonce/updat-annonce/updat-annonce.component';

export const routes: Routes = [
  {path:"",component:RegisterComponent},
  {path:"login",component:RegisterComponent},
  {path:"index",component:NavComponent , children: [
      {path:"home",component:HomeComponent},
      { path: "addAnnonce", component: AddAnnonceComponent },
      {path:"listAnnonce",component:ListAnnonceComponent},
      {path:"udatAnnonce",component:UpdatAnnonceComponent},

    ]}



];
