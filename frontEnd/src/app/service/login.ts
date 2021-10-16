export class Login{

    constructor(public user_id:number, public user_fname:string, public user_lname:string, public user_username:string, 
                public user_password:string
        ){}


        get userId(){
            return this.user_id;
        }
        get userName(){
            return this.user_fname;
        }
        get lname(){
            return this.user_lname;
        }
        get username(){
            return this.user_username;
        }
        get passowrd(){
            return this.user_password;
        }
}