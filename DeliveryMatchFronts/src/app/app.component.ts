import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MatSlideToggle} from '@angular/material/slide-toggle';
import {NavComponent} from './Homme-Nav-Footer/nav/nav.component';
import {FooterComponent} from './Homme-Nav-Footer/footer/footer.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatSlideToggle, NavComponent, FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'DeliveryMatchFronts';
}
