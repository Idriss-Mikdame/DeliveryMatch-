import {Component, OnInit} from '@angular/core';
import {DatePipe, NgForOf} from "@angular/common";
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatIcon} from "@angular/material/icon";
import {Router, RouterLink} from '@angular/router';
import {DemandeService} from '../../services/demande.service';

@Component({
  selector: 'app-lits-demande',
  standalone: true,
  imports: [
    MatCard,
    MatCardActions,
    MatCardContent,
    MatCardHeader,
    MatCardTitle,
    MatIcon,
    NgForOf,
    RouterLink
  ],
  templateUrl: './lits-demande.component.html',
  styleUrl: './lits-demande.component.css'
})
export class LitsDemandeComponent implements OnInit{
  DemmandeList: any[] = []



  constructor(private DemandeService:DemandeService,private route:Router) {
  }

  ngOnInit(): void {
    this.AfficherDemande()
  }

  AfficherDemande(){
    this.DemandeService.lisDemande().subscribe(list=>{
      this.DemmandeList = list
      console.log(list)
    })
  }

  SuuprimerAnnonce(id:number) {
    let conf = confirm("Voulez-vous le supprimer Demande?")
    if (conf){
      this.DemandeService.deleteDemande(id).subscribe(supprime=> {
        if (supprime) {
          this.AfficherDemande();
        }
        window.location.reload();
      });

    }
  }
}
