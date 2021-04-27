export class SignUpInfo {
    username: string;
    firstname: string;
    lastname :string;
    phone :string;
    email: string;
    adress :string ;
    roles: string[];
    password: string;

    constructor(username: string, firstname: string, email: string, password: string , lastname :string , adress :string ,phone :string) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.adress = adress;
        this.password = password;
        this.phone = phone;
        this.roles= ['user'];
    }
}
