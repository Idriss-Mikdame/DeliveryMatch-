import { Routes } from '@angular/router';
import {HomeComponent} from './Homme-Nav-Footer/home/home.component';
import {RegisterComponent} from './Login-Register/register/register.component';
import {NavComponent} from './Homme-Nav-Footer/nav/nav.component';
import {AddAnnonceComponent} from './Annonce/add-annonce/add-annonce.component';
import {ListAnnonceComponent} from './Annonce/list-annonce/list-annonce.component';
import {UpdatAnnonceComponent} from './Annonce/updat-annonce/updat-annonce.component';
import {AddDemandeComponent} from './demande/add-demande/add-demande.component';
import {LitsDemandeComponent} from './demande/lits-demande/lits-demande.component';
import {UpdatDemandeComponent} from './demande/updat-demande/updat-demande.component';

export const routes: Routes = [
  {path:"",component:RegisterComponent},
  {path:"login",component:RegisterComponent},
  {path:"index",component:NavComponent , children: [
      {path:"home",component:HomeComponent},
      { path: "addAnnonce", component: AddAnnonceComponent },
      {path:"listAnnonce",component:ListAnnonceComponent},
      {path:"udatAnnonce/:id",component:UpdatAnnonceComponent},
      { path: "addDemande", component: AddDemandeComponent },
      { path: "listDemande", component: LitsDemandeComponent },
      { path: "udateDemande/:id", component: UpdatDemandeComponent },

    ]}



];
