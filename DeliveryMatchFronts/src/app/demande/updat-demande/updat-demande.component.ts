import {Component, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatOption, MatSelect} from "@angular/material/select";
import {NgForOf} from "@angular/common";
import {ActivatedRoute, Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
import {DemandeService} from '../../services/demande.service';

@Component({
  selector: 'app-updat-demande',
  standalone: true,
    imports: [
        FormsModule,
        MatCard,
        MatCardContent,
        MatCardHeader,
        MatCardTitle,
        MatDivider,
        MatFormField,
        MatInput,
        MatLabel,
        MatOption,
        MatSelect,
        NgForOf
    ],
  templateUrl: './updat-demande.component.html',
  styleUrl: './updat-demande.component.css'
})
export class UpdatDemandeComponent implements OnInit{

  sataut= ["REFUSEE","ACCEPTEE","EN_ATTENTE"]
  demande= {
    id: '',
    status: '',
    dateDemande: '',
    dimension: '',
    poids: '',
    type: ''
  }
  public id:any


  constructor(private DemandeService:DemandeService,private route:Router,private snackBar: MatSnackBar,
              private router: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id = this.router.snapshot.paramMap.get("id")
    this.GetDemmandeByid()
  }

  GetDemmandeByid(){
    this.DemandeService.AfficherDemmandeByid(this.id).subscribe(affId=>{
      this.demande  = affId
    })
  }

  UpdatDemmande() {
  this.DemandeService.updateDemande(this.demande,this.id).subscribe({
   next:(add)=>{
     if (add){
       this.snackBar.open('Demmande Modifier avec succès ', 'Fermer',{
         duration:3000
       });
       this.route.navigateByUrl("/index/listDemande")
     }
   },
    error:()=>{
      this.snackBar.open(' Vous n’êtes pas autorisé à Modifier une Demande. Rôle requis : EXPÉDITEUR.', 'Fermer', {
        duration: 3000
      });
    }
  })
  }
}
