import { Component, OnInit, NgZone } from '@angular/core';
import { AuthService } from '../shared/services/auth.service';
import { Router } from '@angular/router';


import {EnviamentsService} from '../providers/enviaments.service';

import { Enviament } from '../model/enviament';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['dashboard.component.css'],
  providers: [EnviamentsService]
})
export class DashboardComponent implements OnInit {

    enviaments: Enviament[] = [];


  constructor(
    public authService: AuthService,
    private enviamentsService: EnviamentsService,
    public router: Router,
    public ngZone: NgZone
  ) { }

  public ngOnInit() {
	alert("Dashboard OnInit");
      this.enviamentsService
        .getAllEnviaments()
        .subscribe(
          (enviaments) => {
            this.enviaments = enviaments;
		
          }
        );
    }
  
/*  addEnviament(enviament) {
      this.enviamentsService
        .createEnviament(enviament)
        .subscribe(
         (newEnviament) => {
            this.enviaments = this.enviaments.concat(newEnviament);
          }
        );
    }*/

  onToggleHotelComplete(enviament) {
       this.enviamentsService
        .updateEnviament(enviament)
        .subscribe(
          (updateEnviament) => {
            enviament = updateEnviament;
         }
        );
    }

  onRemoveEnviament(enviament) {
      this.enviamentsService
        .deleteEnviamentById(enviament.id)
        .subscribe(
          (_) => {
           this.enviaments = this.enviaments.filter((t) => t.enviamentId !== enviament.id);
         }
      );
    }


	goEnviaments() {
		alert("adeu1");
		this.router.navigate(['/enviament']);
	}
	
	addEnviament() {
	alert("Dashboard:addEnviament");
	this.enviamentsService.createEnviament(new Enviament({enviamentId:"44" , comandaId: "14" , estatEnviament: '2'}))
	}	
	
	
	

}

