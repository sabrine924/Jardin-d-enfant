export class Event {
  [x: string]: any;
    public idEvent : number;
    public subject: string;
    public description  :string;
    public startHour: number;
    public endHour: number; 
    public date: Date;
    public nbrlike :number;
    public name: string;
    public location: string;
    public jackpotDonation: number
    public category : string;
    comments: Comment;
    public cagnotte: Cagnotte;
  coords: any;
    constructor()
    {
        this.idEvent = 0;
        this.subject = '';
        this.description= '';
        this.startHour = 0
        this.endHour= 0;
        this.date = new Date;
        this.nbrlike =0;
        this.name = '';
        this.location= '';
        this.jackpotDonation = 0;
        this.category  = '';
        this.comments = new Comment;
        this. cagnotte = new Cagnotte;      
    }
}

export class Comments{
    public idComment: string;
    public content :string;
    public parents: string;
    constructor(){
        this.idComment = '';
        this.content = '';
        this.parents = '';
    }
}

export class Cagnotte{
     public idCagnotte : string;
     public totalAmount: number; 
     constructor(){
         this.idCagnotte = '';
         this.totalAmount = 0
     }  
 
}
export class getEventsBetweenTwoDates{
    public date1: Date;
    public date2: Date;

constructor()
    {
        this.date1 = new Date;
        this.date2 = new Date;

    }
}