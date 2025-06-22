import {Component, OnInit} from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import {MatFormField, MatLabel} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {MatDivider} from '@angular/material/divider';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AnnonceService} from '../../services/annonce.service';
import {MatIconModule} from '@angular/material/icon';
import {Route, Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
@Component({
  selector: 'app-add-annonce',
  standalone: true,
  imports: [
    MatIconModule,
    MatCardModule,
    MatTabsModule,
    MatFormField,
    MatInput,
    MatLabel,
    MatDivider,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './add-annonce.component.html',
  styleUrl: './add-annonce.component.css'
})
export class AddAnnonceComponent implements OnInit {
  AnnonceLits: any[] = []

  annonce = {
    id:'',
    lieuDepart: '',
    etapes: '',
    destination: '',
    dimensionMax: '',
    typeDeMarchandise: '',
    capaciteDisponible: '',
    date: '',
  }
        constructor(private AnnonceServices:AnnonceService,private route:Router,private snackbar:MatSnackBar) {
      }
  ngOnInit(): void {
    this.AfficherAnnonce()
  }

  AfficherAnnonce(){
    this.AnnonceServices.ListAnnonce().subscribe(Aff=>{
      this.AnnonceLits= Aff
      console.log(Aff)
    })
  }

  AddAnnonce() {
    this.AnnonceServices.AddAnnonce(this.annonce).subscribe({
      next:(Add)=>{
        this.AnnonceLits = Add
        if (Add){
          this.snackbar.open('Annonce envoyée avec succès ', 'Fermer',{
            duration:3000
          });
          this.route.navigateByUrl("/index/listAnnonce")
        }
      },
      error:()=>{
        this.snackbar.open(' Vous n’êtes pas autorisé à envoyer une Annonce. Rôle requis : CONDUCTEUR.', 'Fermer', {
          duration: 3000
        });
      }
    })
  }
  }

