public class Cards {
    public Suits suits;
    public Values values;
    //Suits contains all fours suits like CLUB,DIAMOND,SPADE,HEART
    //Values enumeration contains all cards from 2 to 10 and JACK,QUEEN, KING AND ACE
    //Create Constructor for Cards class:
    public Cards(Suits suit,Values value) {
        this.suits=suit;
        this.values=value;
    }
    public String toString() {
        return this.suits.toString() + "-" + this.values.toString();
    }
    //Next Method is used to get the value of the card. I have used switch-case statement for Cards Value
    public Values getValues() {
        return this.values;
    }
}
