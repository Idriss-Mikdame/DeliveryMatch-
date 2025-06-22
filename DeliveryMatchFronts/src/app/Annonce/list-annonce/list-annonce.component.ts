import {Component, OnInit} from '@angular/core';
import {AnnonceService} from '../../services/annonce.service';
import {MatCardModule} from '@angular/material/card';
import {DatePipe, NgForOf} from '@angular/common';
import {MatIconModule} from '@angular/material/icon';
import {RouterLink} from '@angular/router';
@Component({
  selector: 'app-list-annonce',
  standalone: true,
  imports: [
    MatIconModule,
    MatCardModule,
    NgForOf,
    DatePipe,
    RouterLink
  ],
  templateUrl: './list-annonce.component.html',
  styleUrl: './list-annonce.component.css'
})
export class ListAnnonceComponent implements OnInit{
  AnnonceLits: any[] = []

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
  SuuprimerAnnonce(id:number){
  let conf = confirm("Voulez-vous le supprimer Annonce?")
    if (conf){
      this.AnnonceServices.SupprimerAnnonce(id).subscribe(supprime=> {
        if (supprime) {
          this.AfficherAnnonce();
        }
        window.location.reload();
      });

    }
  }
}
