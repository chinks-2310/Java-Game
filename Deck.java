import java.util.ArrayList;
import java.util.Random;

public class Deck {
    //We need to create the deck of card. There are 52 cards in the deck. There are four suits each contains 13 cards.
    //We need to create one list of type Cards which contains the value of the card and suits of the card.
    public ArrayList<Cards> cards;

    //Constructor for Deck.
    public Deck() {
        this.cards=new ArrayList<Cards>();
    }

    //Now we need to create (generate) the Full Deck of Cards
    public void creteFullDeck() {
        //Generate all the cards. 13 cards per suits
        for(Suits s: Suits.values()){                   //This for loop is used for 4 suits
            for(Values v:Values.values()) {             //This for loop is used for 13 Card values
                // Add a new card in the deck.
                this.cards.add(new Cards(s,v));
            }
        }
    }
    //Function to Shuffle all the Cards.

    public void shuffleCards(){
        //Generate random index between 0 to 51 remove that card from the original deck move that card in the temp deck.
        //In the last step original deck = temporary Deck.
        ArrayList<Cards> tempDeck=new ArrayList<Cards>();
        //Generate Random. Use Random class to generate number between 0 and 51(0 and 51 inclusive)
        Random r=new Random();
        int randomIndex=0;
        int size= this.cards.size();   //52
        for(int i=0;i<size;i++) {
            //Generate random index. Pull that card from the originalDeck and push into temp deck
            //rand.nextInt((max-min)+1))+min;
            randomIndex= r.nextInt((this.cards.size()-1 -0)+1) + 0;
            tempDeck.add(this.cards.get(randomIndex));
            //Remove the card from the original deck.
            this.cards.remove(randomIndex);
        }
        this.cards=tempDeck;
    }

    //toString Method
    public String toString() {
        String CardList="";         //empty String. We are using this string to display all the cards.
        //int i=0;                //Used for total number of cards i.e 52
        for(Cards c:this.cards) {
            CardList+=c.toString()+"\n";
        }
        return CardList;
    }
    //Method to remove the cards from the Deck.
    public void removeCards(int i) {
        this.cards.remove(i);
    }
    //Method to get the card
    public Cards getCard(int i) {
        return this.cards.get(i);
    }
    //Giving Card back
    public void addCard(Cards addCard) {
        this.cards.add(addCard);
    }

    //Draw the card from the deck.
    public void draw(Deck comingFrom) {
        this.cards.add(comingFrom.getCard(0));      //For First Card
        comingFrom.removeCards(0);                  //After giving the first Card, remove the first card.
    }

    //Return the DeckSize
    public int deckSize() {
        return this.cards.size();
    }
    //Move all the cards to the Deck
    public void moveAllToDeck(Deck moveTo) {
        int thisDeckSize=this.cards.size();
        //put the cards into moveTo deck
        for(int i=0;i<thisDeckSize;i++) {
            moveTo.addCard(this.getCard(i));
        }
        for (int i=0;i<thisDeckSize;i++) {
            this.removeCards(0);
        }
    }

    //Return totalValue of cards in the deck
    public int cardsValue()
    {
        int totalValue=0;
        int aces=0;
        for(Cards aCard:this.cards) {
            switch (aCard.getValues()) {
                case TWO: totalValue+=2;break;
                case THREE: totalValue+=3;break;
                case FOUR: totalValue+=4;break;
                case FIVE: totalValue+=5;break;
                case SIX: totalValue+=6;break;
                case SEVEN: totalValue+=7;break;
                case EIGHT: totalValue+=8;break;
                case NINE: totalValue+=9;break;
                case TEN:
                case QUEEN:
                case JACK:
                case KING:
                    totalValue+=10;break;
                case ACE: aces+=1;break;
            }
        }
        for(int i=0;i<aces;i++) {
            if(totalValue>10) {
                totalValue+=1;
            }
            else {
                totalValue+=11;
            }
        }
        return totalValue;
    }
}
