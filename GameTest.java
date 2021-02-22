import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void test_main() {
        Players players[]=new Players[5];
        players[0]=new Players("chintanjehani12345@gmail.com",1500,"Iron Man");
        players[1]=new Players("jay.thakkar@gmail.com",10,"Thor");
        players[2]=new Players("201701141@daiict.ac.in",500,"Hulk");
        players[3]=new Players("steve.rogers@marvel.com",100,"Captain America");
        players[4]=new Players("natasha@marvel.com",200,"Black Widow");
        Tables table=new Tables("Earth",1000);
        Tables tables[]=new Tables[5];
        tables[0]=new Tables("Ego",100);
        tables[1]=new Tables("Earth",200);
        tables[2]=new Tables("Asgard",500);
        tables[3]=new Tables("Vormir",1000);
        tables[4]=new Tables("Titan",2000);
        Deck playingDeck=new Deck();
        playingDeck.creteFullDeck();
        int sizeOfTheDeck=playingDeck.deckSize();
        Assert.assertEquals(52,sizeOfTheDeck);
        playingDeck.shuffleCards();
        Assert.assertEquals(52,playingDeck.deckSize());
        Deck playerDeck=new Deck();
        Deck dealerDeck=new Deck();
        int index=0;
        int tempTableNumber=4;  //To Check the If Condition
        Game g=new Game();
        String ans=g.checkBet(players[index].BankRoll,tables[tempTableNumber].betSize);
        Assert.assertEquals("You have not enough money to play on these table",ans);
        int tempTable=3;
        String ans2=g.checkBet(players[index].BankRoll,tables[tempTable].betSize);
        Assert.assertEquals("You have enough money",ans2);
    }
}