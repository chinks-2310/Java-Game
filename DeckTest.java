import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void test_creteFullDeck() {
        Deck deck=new Deck();
        deck.creteFullDeck();
        int result=deck.deckSize();
        Assert.assertEquals(52,result);
    }

    @Test
    void test_shuffleCards() {
        Deck deck=new Deck();
        deck.creteFullDeck();
        deck.shuffleCards();
        int result=deck.deckSize();
        Assert.assertEquals(52,result);
    }

    @Test
    void test_ToString() {
        Deck deck=new Deck();
        deck.creteFullDeck();
        int result=deck.deckSize();
        Assert.assertEquals(52,result);
        //Here we can use another test case. Display all the 52 cards.
    }

    @Test
    void test_removeCards() {
        Deck deck=new Deck();
        deck.creteFullDeck();
        deck.removeCards(49);
        int result=deck.deckSize();
        Assert.assertEquals(51,result);
    }
    @Test
    void test_removeMultipleCards() {
        Deck deck=new Deck();
        deck.creteFullDeck();
        deck.removeCards(0);
        deck.removeCards(1);
        deck.removeCards(2);
        int result=deck.deckSize();
        Assert.assertEquals(49,result);
    }

    @Test
    void test_getCard() {
        Deck deck=new Deck();
        deck.creteFullDeck();
        Cards result=deck.getCard(0);
        String value=result.toString();
        Assert.assertEquals("CLUB-TWO",value);
    }

    @Test
    void test_getMultipleCards() {
        Deck deck=new Deck();
        deck.creteFullDeck();
        Cards r1=deck.getCard(0);
        String v1=r1.toString();
        Cards r2=deck.getCard(1);
        String v2=r2.toString();
        Cards r3=deck.getCard(2);
        String v3=r3.toString();
        String ans=v1+"\n"+v2+"\n"+v3;
        Assert.assertEquals("CLUB-TWO"+"\n"+"CLUB-THREE"+"\n"+"CLUB-FOUR",ans);
    }

    @Test
    void test_addCard() {
        Deck deck=new Deck();
        deck.creteFullDeck();
        deck.removeCards(0);
        int size=deck.deckSize();
        Assert.assertEquals(51,size);
        Suits s1=Suits.CLUB;
        Values v1=Values.TWO;
        Cards c1=new Cards(s1,v1);
        deck.addCard(c1);
        int updatedSize=deck.deckSize();
        Assert.assertEquals(52,updatedSize);
    }

    @Test
    void test_draw() {
        Deck d=new Deck();  //Whole playing deck of size 52
        d.creteFullDeck();
        Deck playerDeck=new Deck();
        playerDeck.addCard(d.getCard(0));
        d.removeCards(0);
        int playerDeckSize=playerDeck.deckSize();
        int wholeDeckSize=d.deckSize();
        Assert.assertEquals(1,playerDeckSize);
        Assert.assertEquals(51,wholeDeckSize);
    }

    @Test
    void test_deckSize() {
        Deck deck=new Deck();
        deck.creteFullDeck();
        int size=deck.deckSize();
        Assert.assertEquals(52,size);
    }

    @Test
    void test_cardsValue() {
        Deck deck=new Deck();
        Suits s1=Suits.CLUB;
        Values v1=Values.TWO;
        Cards c1=new Cards(s1,v1);
        deck.addCard(c1);
        Suits s2=Suits.CLUB;
        Values v2=Values.JACK;
        Cards c2=new Cards(s2,v2);
        deck.addCard(c2);
        int ans=deck.cardsValue();
        Assert.assertEquals(12,ans);
    }
    //When the totalValue is less than 11
    @Test
    void test_cardsValueWithAce() {
        Deck deck=new Deck();
        Suits s1=Suits.CLUB;
        Values v1=Values.TWO;
        Cards c1=new Cards(s1,v1);
        deck.addCard(c1);
        Suits s2=Suits.CLUB;
        Values v2=Values.ACE;
        Cards c2=new Cards(s2,v2);
        deck.addCard(c2);
        int ans=deck.cardsValue();
        Assert.assertEquals(13,ans);
    }
    //When the totalValue is greater than 11
    @Test
    void test_cardsValueWithAceWhenGreaterThan11() {
        Deck deck=new Deck();
        Suits s1=Suits.CLUB;
        Values v1=Values.KING;
        Cards c1=new Cards(s1,v1);
        deck.addCard(c1);
        Suits s3=Suits.CLUB;
        Values v3=Values.TWO;
        Cards c3=new Cards(s3,v3);
        deck.addCard(c3);
        Suits s2=Suits.CLUB;
        Values v2=Values.ACE;
        Cards c2=new Cards(s2,v2);
        deck.addCard(c2);
        int ans=deck.cardsValue();
        Assert.assertEquals(13,ans);
    }
}