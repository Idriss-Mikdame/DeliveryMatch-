import {Component, OnInit} from '@angular/core';
import {Router, RouterLink, RouterOutlet} from '@angular/router';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIcon} from '@angular/material/icon';
import {MatAnchor, MatIconButton} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import {RegisterLoginService} from '../services/register-login.service';
import {MatMenu, MatMenuItem, MatMenuTrigger} from '@angular/material/menu';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [
    MatSidenavModule,
    RouterLink,
    MatToolbarModule,
    MatIcon,
    MatIconButton,
    MatAnchor,
    RouterOutlet,
    MatMenu,
    MatMenuTrigger,
    MatMenuItem,
    NgIf
  ],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent implements OnInit{
  roles= ["EXPEDITEUR","CONDUCTEUR"]
  constructor(private Services:RegisterLoginService , private route:Router) {
  }
  ngOnInit(): void {
  }
  logout(){
    this.Services.logout();
  this.route.navigateByUrl("/login")}
}
