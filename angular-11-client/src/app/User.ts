import { Role } from "./Role.model";

export class User {
    id! : number;
    username!: string;
    email!: string;
    password!: string;
    firstName!: string;
    lastName!: string;
    phone!: string;
    adress!: string;
    roles!: Set<Role>;
}
