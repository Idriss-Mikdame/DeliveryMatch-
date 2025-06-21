import {Component, OnInit} from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import {MatFormField, MatLabel} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {MatDivider} from '@angular/material/divider';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AnnonceService} from '../../services/annonce.service';

@Component({
  selector: 'app-add-annonce',
  standalone: true,
  imports: [
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
        constructor(private AnnonceServices:AnnonceService) {
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
    this.AnnonceServices.AddAnnonce(this.annonce).subscribe(AddAnnonce=>{
      this.AnnonceLits  = AddAnnonce
      console.log(AddAnnonce)
    })
  }
}
