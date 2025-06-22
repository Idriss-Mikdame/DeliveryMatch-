import {Component, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {AnnonceService} from '../../services/annonce.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-updat-annonce',
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
        MatLabel
    ],
  templateUrl: './updat-annonce.component.html',
  styleUrl: './updat-annonce.component.css'
})
export class UpdatAnnonceComponent implements OnInit{
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
  public id:any
  constructor(private AnnonceServices:AnnonceService,private route:Router,
              private router: ActivatedRoute,private snackBar:MatSnackBar) {
  }


  ngOnInit(): void {
    this.id = this.router.snapshot.paramMap.get('id');
    this.GetAnnonceByid()
  }

   GetAnnonceByid() {
    this.AnnonceServices.AfficherAnnonceByid(this.id).subscribe((data)=>{
      this.annonce = data;
    })
  }
  editForm() {
    this.AnnonceServices.EditAnnocne(this.annonce,this.id).subscribe({
      next:(Updat)=>{
        if (Updat){
          this.snackBar.open('Annonces Modifier avec succès ', 'Fermer',{
            duration : 3000
          });
          this.route.navigateByUrl('/index/listAnnonce')

        }
      },
      error:()=>{
        this.snackBar.open(' Vous n’êtes pas autorisé à Modifier une Annonce. Rôle requis : CONDUCTEUR.', 'Fermer', {
          duration: 3000
        });

      }

    });
  }
}
