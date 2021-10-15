import { Component, Input, OnDestroy, OnInit, ElementRef } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { Login } from 'src/app/service/login';
import { LoginService } from 'src/app/service/login.service';

@Component({
	selector: 'app-navbar',
	templateUrl: './navbar.component.html',
	styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy {

	isLoggedin = false;
	private userSub: Subscription = new Subscription;
	constructor(private loginServ:LoginService, private elementRef:ElementRef) {
	 }

	ngOnDestroy(): void {
	 this.userSub.unsubscribe();
	}

	fname:string="";

	ngOnInit() {
		this.userSub = this.loginServ.user.subscribe(user=>{
			this.isLoggedin =!user ? false : true; 
			this.fname=user.user_fname;
		});
	}

	ngAfterViewInit() {
		const navbarToggler = document.getElementsByClassName("navToggler")[0];
		let link = document.getElementsByClassName("navLink")[0];
		navbarToggler.addEventListener('click', () => {
			link.classList.toggle('active');
		});
	}

	onlogout(){
		this.loginServ.logout();
	}
}
