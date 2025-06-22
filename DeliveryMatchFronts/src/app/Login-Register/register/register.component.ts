import {Component, OnInit} from '@angular/core';
import {MatCard, MatCardContent, MatCardHeader} from '@angular/material/card';
import {MatCardModule} from '@angular/material/card';
import {MatTabsModule} from '@angular/material/tabs';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {FormsModule} from '@angular/forms';
import {RegisterLoginService} from '../../services/register-login.service';
import { Router } from '@angular/router';
import {MatOption, MatSelect} from '@angular/material/select';
import {NgForOf} from '@angular/common';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    FormsModule,
    MatInputModule,
    MatTabsModule,
    MatCardModule,
    MatCardHeader,
    MatCard,
    MatCardContent,
    MatButtonModule,
    FormsModule,
    MatSelect,
    MatOption,
    NgForOf,

  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit{
  register = {
  prenom: '',
  nom: '',
  email: '',
  motDePasse: '',
  role: ''
}
  authenticate = {
  email: '',
  motDePasse: ''

}
  roles= ["EXPEDITEUR","CONDUCTEUR"]
  constructor(private RegisterLoginServices:RegisterLoginService,private route:Router,private snackBar: MatSnackBar) {
  }
  login() {
    this.RegisterLoginServices.Login(this.authenticate).subscribe({
      next: () => {
        this.snackBar.open('Connexion réussie', 'Fermer', { duration: 3000 });
        this.route.navigate(['/index/home']);
      },
      error: () => {
        this.snackBar.open('Identifiants invalides', 'Fermer', { duration: 3000 });
      }
    });
  }

  ngOnInit(): void {

  }


  registers() {
    this.RegisterLoginServices.RegisterUser(this.register).subscribe({
      next: () => {
        this.snackBar.open('Inscription réussie', 'Fermer', { duration: 3000 });
        this.route.navigate(['/index/home']);
      },
      error: () => {
        this.snackBar.open('Erreur lors de l\'inscription', 'Fermer', { duration: 3000 });
      }
    });
  }
}
