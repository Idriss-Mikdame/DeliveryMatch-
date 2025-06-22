import {Component, OnInit} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from '@angular/material/card';
import {MatDivider} from '@angular/material/divider';
import {MatFormField, MatLabel} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {MatOption} from '@angular/material/core';
import {MatSelect} from '@angular/material/select';
import {NgForOf} from '@angular/common';
import {DemandeService} from '../../services/demande.service';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-add-demande',
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
    ReactiveFormsModule,
    MatOption,
    MatSelect,
    NgForOf
  ],
  templateUrl: './add-demande.component.html',
  styleUrl: './add-demande.component.css'
})
export class AddDemandeComponent implements OnInit{
  DemmandeList: any[] = []

  sataut= ["REFUSEE","ACCEPTEE","EN_ATTENTE"]
  demande= {
    id: '',
    status: '',
    dateDemande: '',
    dimension: '',
    poids: '',
    type: ''
  }
  constructor(private DemandeService:DemandeService,private route:Router,private snackBar: MatSnackBar) {
  }
  ngOnInit(): void {
    this.AfficherDemande()
  }

  AfficherDemande(){
    this.DemandeService.lisDemande().subscribe(list=>{
      console.log(list)
    })
  }

  AddDemande(){
    this.DemandeService.AddDemande(this.demande).subscribe({
      next:(Add)=>{
        this.DemmandeList = Add
        if (Add){
          this.snackBar.open('Demande envoyée avec succès ', 'Fermer',{
            duration:3000
          });
          this.route.navigateByUrl("/index/listDemande")
        }
      },
      error:()=>{
        this.snackBar.open(' Vous n’êtes pas autorisé à envoyer une demande. Rôle requis : EXPÉDITEUR.', 'Fermer', {
          duration: 3000
        });
      }
    })
  }
}
