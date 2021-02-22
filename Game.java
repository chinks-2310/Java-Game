import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to the Game!!");
        Scanner sc = new Scanner(System.in);
        //Create the new 52 cards Deck
        //After creating all the 52 cards we need to shuffle all the Cards.
        //Created Method for Shuffling the cards in the deck class.
        //Created Method for Removing the cards from the deck.
        System.out.println("Enter player's email, bankRoll and userName");
        String email=sc.next();
        int bankRoll= sc.nextInt();
        String userName= sc.next();
        Players player=new Players(email,bankRoll,userName);
        Tables table=new Tables("Earth",1000);
        Tables tables[];
        System.out.println("Enter the number of tables");
        int numberOfTables= sc.nextInt();
        String tableName;
        int betSize;
        tables=new Tables[numberOfTables];
        for(int i=0;i<numberOfTables;i++) {
            System.out.println("Enter the name of the table");
            tableName=sc.next();
            System.out.println("Enter the betSize of that table");
            betSize= sc.nextInt();
            tables[i]=new Tables(tableName,betSize);
        }
        Deck playingDeck=new Deck();
        playingDeck.creteFullDeck();
        playingDeck.shuffleCards();
        //System.out.println(playingDeck);
        //Create a deck for player and Dealer
        Deck playerDeck=new Deck();
        Deck dealerDeck=new Deck();
        int playerChosenTable=-1;
        for(int i=0;i<numberOfTables;i++) {
            if(tables[i].betSize<=player.BankRoll){
                playerChosenTable=i;
                break;
            }
        }
        //Game Loop
        if(playerChosenTable==-1) {
            System.out.println("Player has not enough money. He can't play the game");
        }
        else {
            while (player.BankRoll >= tables[playerChosenTable].betSize) {
                //Game Started
                //Take the players bet
                System.out.println("You have $" + player.BankRoll);
                //Start Dealing
                //Give player two cards

                boolean endRound = false;
                playerDeck.draw(playingDeck);
                playerDeck.draw(playingDeck);
                //Dealer also gets 2 cards
                dealerDeck.draw(playingDeck);
                dealerDeck.draw(playingDeck);
                while (true) {
                    System.out.println("Your Turn");
                    System.out.println(playerDeck.toString());      //Display two cards of the player
                    System.out.println("The hand value of player's deck: " + playerDeck.cardsValue());
                    //Display 1 card of dealer and another card is hidden
                    System.out.println("Dealer Hand: " + dealerDeck.getCard(1).toString() + " and [Hidden]");
                    //Pick the choice of the player
                    System.out.println("Would you like to (1) Hit or (2) Stand?");
                    int response = sc.nextInt();
                    //First Condition for Hit(1)
                    if (response == 1) {
                        playerDeck.draw(playingDeck);
                        System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                        //Bust if > 21
                        if (playerDeck.cardsValue() > 21) {
                            System.out.println("Bust.. Currently value of deck: " + playerDeck.cardsValue());
                            player.BankRoll -= tables[playerChosenTable].betSize;
                            endRound = true;
                            break;
                        }
                    }
                    if (response == 2) {
                        break;
                    }
                }
                //Reveal the Dealer's Cards
                System.out.println("Dealer Cards: " + dealerDeck.toString());
                //See if the dealer has more score than player
                if ((dealerDeck.cardsValue() >= 17) && (dealerDeck.cardsValue() > playerDeck.cardsValue()) && endRound == false) {
                    System.out.println("Sorry, You lost !!");
                    player.BankRoll -= tables[playerChosenTable].betSize;
                    endRound = true;
                }
                //Dealer Draws at 16, stand at 17
                while (dealerDeck.cardsValue() < 17 && endRound == false) {
                    dealerDeck.draw(playingDeck);
                    System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
                }
                //Display Total Value For Dealer
                System.out.println("Dealer's hand value is: " + dealerDeck.cardsValue());
                //Determine if dealer busted
                if ((dealerDeck.cardsValue() > 21) && endRound == false) {
                    System.out.println("Dealer busts !!! Congratulation! You Won!");
                    player.BankRoll += (tables[playerChosenTable].betSize * 2);
                    endRound = true;
                }

                //Determine if draw(push)
                if (playerDeck.cardsValue() == dealerDeck.cardsValue() && endRound == false) {
                    System.out.println("Push");
                    endRound = true;
                }
                if ((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
                    System.out.println("Congratulations!! You won!!");
                    player.BankRoll += (2 * tables[playerChosenTable].betSize);
                    endRound = false;
                }
                else if (endRound == false) {
                    System.out.println("Sorry, You Lost !!");
                    player.BankRoll -= tables[playerChosenTable].betSize;
                    endRound = true;
                }
                //Move all the cards to the playing deck
                playerDeck.moveAllToDeck(playingDeck);
                dealerDeck.moveAllToDeck(playingDeck);
                System.out.println("End of the Hand");
            }
            System.out.println("Game over! You are running out of money!");
        }
    }
}
