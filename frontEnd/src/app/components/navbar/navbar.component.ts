@Component({
	selector: 'app-navbar',
	templateUrl: './navbar.component.html',
	styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy {

  static userInfo:Users = new Users(-1,1," "," "," "," "," ",1," "," "," ","");
  isLoggedin = false;
  fname:string="";
	private userSub: Subscription = new Subscription;
	constructor(private loginServ:LoginService, private elementRef:ElementRef, private router:Router) {
	 }

	ngOnDestroy(): void {
	 this.userSub.unsubscribe();
	}

	fname:string="";

	ngOnInit() {
    this.router.events
    .subscribe(
      (event: NavigationEvent) => {
        if(event instanceof NavigationStart) {
          this.update();
        }
      });

	ngAfterViewInit() {
		const navbarToggler = document.querySelector<HTMLElement>("#menuToggleID");
		const menuLinks = document.getElementsByClassName("navMenuMM")[0];
		if (navbarToggler) {
			navbarToggler.addEventListener('click', () => {
				navbarToggler.classList.toggle('is-active');
				menuLinks.classList.toggle('active');
			});
		}
	}
  update(){
    this.fname = NavbarComponent.userInfo.user_fname;
    if(NavbarComponent.userInfo.user_id>0)
      this.isLoggedin=true;
    else
      this.isLoggedin=false;
  }

	onlogout(){
		this.loginServ.logout();
	}
}

