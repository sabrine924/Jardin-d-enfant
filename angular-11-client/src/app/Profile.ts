import { Adresse } from "./Adresse.model";
import { Preference } from "./Preference.model";
import { Profession } from "./Profession.model";
import { User } from "./User";

export class Profile {
    id! : number;
    numberchilds!: number;
    datecreaction!: Date;
    phone!: number;
    adress!: Adresse;
    location!: string;
    prefernce!: Preference;
    profession!: Profession;
    user!: User;
}
