import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Lab 3: Decks of Cards
 * CST 338: Software Design (Spring B 2021)
 *
 * Prompts the user for a number of players between 1 and 10.
 * Creates a hand for each player by drawing cards from
 * a deck. Displays each player's (unshuffled) hand,
 * resets all objects, re-deals to each player, and
 * prints each player's (shuffled) hand.
 *
 * @author Michael Hackett, Katherine Vickstrom, Mike Limpus, Deen Altawil
 */
public class Main {
    private static Scanner userInput = new Scanner(System.in);
    public static final int MAX_PLAYERS = 10;
    public static void main(String[] args) {
        //Phase 4 Test
        Deck testDeck = new Deck();
        Hand[] players = new Hand[MAX_PLAYERS];
        int numPlayers = getNumPlayers();
        //Create N hands for N players
        for (int i = 0; i < numPlayers; i++)
            players[i] = new Hand();
        Card newCard;
        int dealTracker = 0;
        //While the deck still has cards, deal to each player
        while ((newCard = testDeck.dealCard()) != null) {
            players[dealTracker++].takeCard(newCard);
            if (dealTracker > MAX_PLAYERS) dealTracker = 0;
        }
        //Print the hands
        System.out.println("Hands from an unshuffled deck:");
        for (int i = 0; i < numPlayers; i++)
            System.out.println(players[i].toString()+"\n");
        //Reset all objects
        for (int i = 0; i < numPlayers; i++)
            players[i].resetHand();
        testDeck.init();
        //Shuffle, re-deal, and print
        testDeck.shuffle();
        dealTracker = 0;
        while ((newCard = testDeck.dealCard()) != null) {
            players[dealTracker++].takeCard(newCard);
            if (dealTracker > MAX_PLAYERS) dealTracker = 0;
        }
        System.out.println("Hands from a shuffled deck:");
        for (int i = 0; i < numPlayers; i++)
            System.out.println(players[i].toString()+"\n");
        userInput.close();
    }
    /**
     * A recursive method for receiving and
     * validating user input.
     * @return The inputted number of players.
     */
    private static int getNumPlayers() {
        int numPlayers;
        System.out.println("How many players? (1 - 10)");
        try {
           numPlayers = userInput.nextInt();
        }catch (InputMismatchException e) {
            userInput = new Scanner(System.in);
            numPlayers = getNumPlayers();
        }
        if (numPlayers < 1 || numPlayers > MAX_PLAYERS) numPlayers = getNumPlayers();
        return numPlayers;
    }
}
