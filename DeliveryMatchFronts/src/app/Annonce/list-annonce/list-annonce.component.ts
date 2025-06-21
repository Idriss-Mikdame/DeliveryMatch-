import {Component, OnInit} from '@angular/core';
import {AnnonceService} from '../../services/annonce.service';
import {MatCardModule} from '@angular/material/card';
import {DatePipe, NgForOf} from '@angular/common';
@Component({
  selector: 'app-list-annonce',
  standalone: true,
  imports: [
    MatCardModule,
    NgForOf,
    DatePipe
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
}
