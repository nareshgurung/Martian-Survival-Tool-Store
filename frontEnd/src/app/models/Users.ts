import { Login } from "../service/login";

export class Users{
  valid: any;
    constructor(public user_id:number, public user_role:number, public user_email:string, public user_fname:string, public user_midinnitial:string,
        public user_lname:string, public user_street:string, public user_zip:number, public user_city:string, public user_state:string,
        public user_username:string, public user_password:string) {
    this.user_id = user_id;
    this.user_role = user_role;
    this.user_email = user_email;
    this.user_fname = user_fname;
    this.user_midinnitial = user_midinnitial;
    this.user_lname = user_lname;
    this.user_street = user_street;
    this.user_zip = user_zip;
    this.user_city = user_city;
    this.user_state = user_state;
    this.user_username = user_username;
    this.user_password = user_password;

}
getUserId():number{
    return this.user_id;
}
getUserRold():number{
    return this.user_role;
}
getUserEmail():string{
    return this.user_email;
}
getUserFristName():string{
    return this.user_fname;
}
getUserMidName():string{
    return this.user_midinnitial;
}
getUserLastName():string{
    return this.user_lname
}

getUserStreet():string{
    return this.user_street;
}
getUserZip():number{
    return this.user_zip;
}
getUserCity():string{
    return this.user_city;
}
getUserState():string{
    return this.user_state;
}
getUserUsername():string{
    return this.user_username;
}
getUserPassword():string{
    return this.user_password;
}

}