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
    public static final int MAX_PLAYERS = 10, DECK = 52;
    public static void main(String[] args) {
        // Phase 3 Test
        // Deck of 2 packs, unshuffled then shuffled
        Deck deck = new Deck(2); //Declare a 2-pack deck
        for (int i = 0; i < (DECK*2); ++i) {
            Card testCard = deck.dealCard();
            if (testCard != null) System.out.print(testCard.toString() + " | ");
        }
        System.out.println("\n-------------------------------------------------");
        deck = new Deck(2);
        deck.shuffle();
        for (int i = 0; i < (DECK*2); ++i) {
            Card testCard = deck.dealCard();
            if (testCard != null) System.out.print(testCard.toString() + " | ");
        }
        System.out.println("\n-------------------------------------------------");
        // Deck of 1 pack, unshuffled then shuffled
        deck = new Deck(); //Declare a 1-pack deck
        for (int i = 0; i < DECK; ++i) {
            Card testCard = deck.dealCard();
            if (testCard != null) System.out.print(testCard.toString() + " | ");
        }
        System.out.println("\n-------------------------------------------------");
        deck = new Deck();
        deck.shuffle();
        for (int i = 0; i < DECK; ++i) {
            Card testCard = deck.dealCard();
            if (testCard != null) System.out.print(testCard.toString() + " | ");
        }
        System.out.println("\n-------------------------------------------------");
        System.out.println();
        //Phase 4 Test
        Deck testDeck = new Deck();
        Hand[] players = new Hand[MAX_PLAYERS];
        //User input
        int numPlayers = getNumPlayers();
        //Create N hands for N players
        for (int i = 0; i < numPlayers; i++)
            players[i] = new Hand();
        Card newCard;
        int dealTracker = 0;
        //While the deck still has cards, deal to each player
        while ((newCard = testDeck.dealCard()) != null) {
            players[dealTracker++].takeCard(newCard);
            if (dealTracker == numPlayers) dealTracker = 0;
        }
        //Print the hands
        System.out.println("Hands from an unshuffled deck:");
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Hand "+(i+1)+": ( ");
            System.out.println(players[i].toString() + " )\n");
        }
        //Reset all objects
        for (int i = 0; i < numPlayers; i++)
            players[i].resetHand();
        testDeck.init(1);
        //Shuffle, re-deal, and print
        testDeck.shuffle();
        dealTracker = 0;
        while ((newCard = testDeck.dealCard()) != null) {
            players[dealTracker++].takeCard(newCard);
            if (dealTracker == numPlayers) dealTracker = 0;
        }
        System.out.println("Hands from a shuffled deck:");
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Hand "+(i+1)+": ( ");
            System.out.println(players[i].toString() + " )\n");
        }
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
/* -------------------------Phase 3 Test----------------------------------
A of CLUBS | 2 of CLUBS | 3 of CLUBS | 4 of CLUBS | 5 of CLUBS | 6 of CLUBS | 7 of CLUBS | 8 of CLUBS | 9 of CLUBS
| T of CLUBS | J of CLUBS | Q of CLUBS | K of CLUBS | A of DIAMONDS | 2 of DIAMONDS | 3 of DIAMONDS | 4 of DIAMONDS
| 5 of DIAMONDS | 6 of DIAMONDS | 7 of DIAMONDS | 8 of DIAMONDS | 9 of DIAMONDS | T of DIAMONDS | J of DIAMONDS | Q
of DIAMONDS | K of DIAMONDS | A of HEARTS | 2 of HEARTS | 3 of HEARTS | 4 of HEARTS | 5 of HEARTS | 6 of HEARTS | 7
of HEARTS | 8 of HEARTS | 9 of HEARTS | T of HEARTS | J of HEARTS | Q of HEARTS | K of HEARTS | A of SPADES | 2 of
SPADES | 3 of SPADES | 4 of SPADES | 5 of SPADES | 6 of SPADES | 7 of SPADES | 8 of SPADES | 9 of SPADES | T of SPADES
| J of SPADES | Q of SPADES | K of SPADES | A of CLUBS | 2 of CLUBS | 3 of CLUBS | 4 of CLUBS | 5 of CLUBS | 6 of CLUBS
| 7 of CLUBS | 8 of CLUBS | 9 of CLUBS | T of CLUBS | J of CLUBS | Q of CLUBS | K of CLUBS | A of DIAMONDS | 2 of DIAMONDS
| 3 of DIAMONDS | 4 of DIAMONDS | 5 of DIAMONDS | 6 of DIAMONDS | 7 of DIAMONDS | 8 of DIAMONDS | 9 of DIAMONDS | T of
DIAMONDS | J of DIAMONDS | Q of DIAMONDS | K of DIAMONDS | A of HEARTS | 2 of HEARTS | 3 of HEARTS | 4 of HEARTS | 5 of
HEARTS | 6 of HEARTS | 7 of HEARTS | 8 of HEARTS | 9 of HEARTS | T of HEARTS | J of HEARTS | Q of HEARTS | K of HEARTS
| A of SPADES | 2 of SPADES | 3 of SPADES | 4 of SPADES | 5 of SPADES | 6 of SPADES | 7 of SPADES | 8 of SPADES | 9 of
SPADES | T of SPADES | J of SPADES | Q of SPADES | A of CLUBS |
-------------------------------------------------
6 of HEARTS | 8 of HEARTS | K of HEARTS | 8 of DIAMONDS | 8 of SPADES | A of DIAMONDS | 8 of CLUBS | 5 of HEARTS | 2 of
HEARTS | 4 of CLUBS | Q of CLUBS | 6 of DIAMONDS | Q of SPADES | 3 of HEARTS | 3 of HEARTS | J of HEARTS | 4 of HEARTS
| 5 of SPADES | K of DIAMONDS | 8 of SPADES | A of HEARTS | T of CLUBS | A of CLUBS | 2 of SPADES | 6 of SPADES | 3 of
SPADES | 4 of DIAMONDS | 6 of SPADES | 4 of DIAMONDS | 3 of SPADES | J of HEARTS | 9 of HEARTS | T of HEARTS | 5 of CLUBS
| K of CLUBS | K of CLUBS | 7 of DIAMONDS | 3 of DIAMONDS | 4 of CLUBS | A of CLUBS | 7 of CLUBS | 7 of SPADES | 5 of
HEARTS | A of HEARTS | A of SPADES | 9 of CLUBS | Q of HEARTS | K of HEARTS | 5 of CLUBS | Q of SPADES | 8 of HEARTS |
J of DIAMONDS | 9 of CLUBS | 2 of CLUBS | 2 of SPADES | K of DIAMONDS | J of CLUBS | 4 of SPADES | 4 of SPADES | Q of
HEARTS | 2 of DIAMONDS | A of CLUBS | J of DIAMONDS | 7 of SPADES | 2 of CLUBS | T of DIAMONDS | 9 of DIAMONDS | 6 of CLUBS
| Q of DIAMONDS | K of SPADES | Q of CLUBS | 5 of SPADES | 3 of CLUBS | J of SPADES | 7 of DIAMONDS | 8 of CLUBS | 3 of
DIAMONDS | T of DIAMONDS | 5 of DIAMONDS | 9 of HEARTS | J of CLUBS | 9 of DIAMONDS | T of SPADES | T of CLUBS | 7 of HEARTS
| J of SPADES | 8 of DIAMONDS | 6 of HEARTS | 7 of HEARTS | 7 of CLUBS | T of SPADES | 2 of DIAMONDS | 2 of HEARTS | Q of
DIAMONDS | 5 of DIAMONDS | 9 of SPADES | T of HEARTS | A of SPADES | 4 of HEARTS | 9 of SPADES | 3 of CLUBS | 6 of CLUBS |
6 of DIAMONDS | A of DIAMONDS |
-------------------------------------------------
A of CLUBS | 2 of CLUBS | 3 of CLUBS | 4 of CLUBS | 5 of CLUBS | 6 of CLUBS | 7 of CLUBS | 8 of CLUBS | 9 of CLUBS | T of
CLUBS | J of CLUBS | Q of CLUBS | K of CLUBS | A of DIAMONDS | 2 of DIAMONDS | 3 of DIAMONDS | 4 of DIAMONDS | 5 of DIAMONDS
| 6 of DIAMONDS | 7 of DIAMONDS | 8 of DIAMONDS | 9 of DIAMONDS | T of DIAMONDS | J of DIAMONDS | Q of DIAMONDS | K of
DIAMONDS | A of HEARTS | 2 of HEARTS | 3 of HEARTS | 4 of HEARTS | 5 of HEARTS | 6 of HEARTS | 7 of HEARTS | 8 of HEARTS
| 9 of HEARTS | T of HEARTS | J of HEARTS | Q of HEARTS | K of HEARTS | A of SPADES | 2 of SPADES | 3 of SPADES | 4 of
SPADES | 5 of SPADES | 6 of SPADES | 7 of SPADES | 8 of SPADES | 9 of SPADES | T of SPADES | J of SPADES | Q of SPADES
| K of SPADES |
-------------------------------------------------
Q of SPADES | J of HEARTS | J of DIAMONDS | 9 of HEARTS | 9 of SPADES | 2 of DIAMONDS | K of SPADES | 6 of HEARTS | 5 of
SPADES | 5 of DIAMONDS | A of CLUBS | 4 of HEARTS | 3 of SPADES | 9 of CLUBS | 6 of DIAMONDS | T of CLUBS | A of SPADES
| 4 of CLUBS | 5 of HEARTS | A of HEARTS | 9 of DIAMONDS | 5 of CLUBS | 4 of DIAMONDS | 8 of DIAMONDS | A of DIAMONDS |
K of DIAMONDS | 7 of SPADES | Q of CLUBS | T of DIAMONDS | 8 of HEARTS | 8 of SPADES | 2 of SPADES | 3 of DIAMONDS | J of
CLUBS | 2 of CLUBS | 6 of SPADES | 6 of CLUBS | 3 of CLUBS | 3 of HEARTS | 2 of HEARTS | T of SPADES | T of HEARTS | 7 of
HEARTS | 8 of CLUBS | Q of DIAMONDS | 7 of DIAMONDS | K of CLUBS | 7 of CLUBS | J of SPADES | 4 of SPADES | Q of HEARTS |
K of HEARTS |
-------------------------------------------------
---------------------------End Phase 3 Test------------------------------------ */

/* ------------------------------Phase 4 Test Run #1----------------------------
How many players? (1 - 10)
1
Hands from an unshuffled deck:
Hand 1: ( A of CLUBS, 2 of CLUBS, 3 of CLUBS, 4 of CLUBS, 5 of CLUBS, 6 of CLUBS, 7 of CLUBS, 8 of CLUBS, 9 of CLUBS, T
of CLUBS, J of CLUBS, Q of CLUBS, K of CLUBS, A of DIAMONDS, 2 of DIAMONDS, 3 of DIAMONDS, 4 of DIAMONDS, 5 of DIAMONDS,
6 of DIAMONDS, 7 of DIAMONDS, 8 of DIAMONDS, 9 of DIAMONDS, T of DIAMONDS, J of DIAMONDS, Q of DIAMONDS, K of DIAMONDS,
A of HEARTS, 2 of HEARTS, 3 of HEARTS, 4 of HEARTS, 5 of HEARTS, 6 of HEARTS, 7 of HEARTS, 8 of HEARTS, 9 of HEARTS, T
of HEARTS, J of HEARTS, Q of HEARTS, K of HEARTS, A of SPADES, 2 of SPADES, 3 of SPADES, 4 of SPADES, 5 of SPADES, 6 of
SPADES, 7 of SPADES, 8 of SPADES, 9 of SPADES, T of SPADES, J of SPADES )

Hands from a shuffled deck:
Hand 1: ( 6 of HEARTS, 3 of HEARTS, 6 of CLUBS, J of SPADES, 4 of DIAMONDS, 7 of HEARTS, 6 of SPADES, A of DIAMONDS, 3 of
SPADES, A of CLUBS, J of CLUBS, 2 of CLUBS, 8 of DIAMONDS, 9 of SPADES, T of DIAMONDS, T of HEARTS, 5 of HEARTS, 3 of CLUBS,
2 of SPADES, K of DIAMONDS, 8 of CLUBS, 5 of CLUBS, 5 of SPADES, 7 of SPADES, 7 of CLUBS, K of CLUBS, 2 of DIAMONDS,
8 of SPADES, 8 of HEARTS, 9 of DIAMONDS, Q of CLUBS, Q of DIAMONDS, 9 of HEARTS, A of SPADES, K of SPADES, T of CLUBS,
2 of HEARTS, 7 of DIAMONDS, A of HEARTS, J of HEARTS, 6 of DIAMONDS, 5 of DIAMONDS, J of DIAMONDS, K of HEARTS, T of SPADES,
Q of SPADES, 9 of CLUBS, 4 of HEARTS, 3 of DIAMONDS, 4 of CLUBS )


Process finished with exit code 0
---------------------------End Phase 4 Test Run #1------------------------------------ */

/* ------------------------------Phase 4 Test Run #2----------------------------
How many players? (1 - 10)
10
Hands from an unshuffled deck:
Hand 1: ( A of CLUBS, J of CLUBS, 8 of DIAMONDS, 5 of HEARTS, 2 of SPADES, Q of SPADES )

Hand 2: ( 2 of CLUBS, Q of CLUBS, 9 of DIAMONDS, 6 of HEARTS, 3 of SPADES, K of SPADES )

Hand 3: ( 3 of CLUBS, K of CLUBS, T of DIAMONDS, 7 of HEARTS, 4 of SPADES )

Hand 4: ( 4 of CLUBS, A of DIAMONDS, J of DIAMONDS, 8 of HEARTS, 5 of SPADES )

Hand 5: ( 5 of CLUBS, 2 of DIAMONDS, Q of DIAMONDS, 9 of HEARTS, 6 of SPADES )

Hand 6: ( 6 of CLUBS, 3 of DIAMONDS, K of DIAMONDS, T of HEARTS, 7 of SPADES )

Hand 7: ( 7 of CLUBS, 4 of DIAMONDS, A of HEARTS, J of HEARTS, 8 of SPADES )

Hand 8: ( 8 of CLUBS, 5 of DIAMONDS, 2 of HEARTS, Q of HEARTS, 9 of SPADES )

Hand 9: ( 9 of CLUBS, 6 of DIAMONDS, 3 of HEARTS, K of HEARTS, T of SPADES )

Hand 10: ( T of CLUBS, 7 of DIAMONDS, 4 of HEARTS, A of SPADES, J of SPADES )

Hands from a shuffled deck:
Hand 1: ( 7 of CLUBS, 2 of DIAMONDS, A of CLUBS, 8 of DIAMONDS, 7 of SPADES, Q of DIAMONDS )

Hand 2: ( Q of SPADES, 8 of SPADES, 5 of SPADES, T of SPADES, 5 of HEARTS, 4 of SPADES )

Hand 3: ( 8 of CLUBS, 9 of SPADES, T of DIAMONDS, Q of HEARTS, 9 of DIAMONDS )

Hand 4: ( 6 of CLUBS, 7 of HEARTS, J of SPADES, 8 of HEARTS, T of HEARTS )

Hand 5: ( 5 of DIAMONDS, 5 of CLUBS, 2 of HEARTS, 3 of DIAMONDS, A of DIAMONDS )

Hand 6: ( 2 of SPADES, 7 of DIAMONDS, 4 of CLUBS, K of SPADES, 4 of DIAMONDS )

Hand 7: ( 3 of HEARTS, A of SPADES, 6 of DIAMONDS, J of HEARTS, 3 of CLUBS )

Hand 8: ( K of DIAMONDS, 9 of CLUBS, 9 of HEARTS, 6 of HEARTS, K of CLUBS )

Hand 9: ( K of HEARTS, J of DIAMONDS, Q of CLUBS, J of CLUBS, T of CLUBS )

Hand 10: ( 2 of CLUBS, 4 of HEARTS, A of HEARTS, 6 of SPADES, 3 of SPADES )


Process finished with exit code 0
---------------------------End Phase 4 Test Run #2------------------------------------ */

/* ------------------------------Phase 4 Test Run #3----------------------------
How many players? (1 - 10)
-1
How many players? (1 - 10)
0
How many players? (1 - 10)
11
How many players? (1 - 10)
qw
How many players? (1 - 10)
5
Hands from an unshuffled deck:
Hand 1: ( A of CLUBS, 6 of CLUBS, J of CLUBS, 3 of DIAMONDS, 8 of DIAMONDS, K of DIAMONDS, 5 of HEARTS, T of HEARTS,
2 of SPADES, 7 of SPADES, Q of SPADES )

Hand 2: ( 2 of CLUBS, 7 of CLUBS, Q of CLUBS, 4 of DIAMONDS, 9 of DIAMONDS, A of HEARTS, 6 of HEARTS, J of HEARTS,
3 of SPADES, 8 of SPADES, K of SPADES )

Hand 3: ( 3 of CLUBS, 8 of CLUBS, K of CLUBS, 5 of DIAMONDS, T of DIAMONDS, 2 of HEARTS, 7 of HEARTS, Q of HEARTS,
4 of SPADES, 9 of SPADES )

Hand 4: ( 4 of CLUBS, 9 of CLUBS, A of DIAMONDS, 6 of DIAMONDS, J of DIAMONDS, 3 of HEARTS, 8 of HEARTS, K of HEARTS,
5 of SPADES, T of SPADES )

Hand 5: ( 5 of CLUBS, T of CLUBS, 2 of DIAMONDS, 7 of DIAMONDS, Q of DIAMONDS, 4 of HEARTS, 9 of HEARTS, A of SPADES,
6 of SPADES, J of SPADES )

Hands from a shuffled deck:
Hand 1: ( 9 of SPADES, 7 of SPADES, A of HEARTS, 6 of HEARTS, 6 of DIAMONDS, 4 of HEARTS, 7 of DIAMONDS, 4 of CLUBS,
6 of CLUBS, A of DIAMONDS, T of CLUBS )

Hand 2: ( 7 of CLUBS, K of DIAMONDS, A of CLUBS, T of HEARTS, K of SPADES, 8 of DIAMONDS, 9 of DIAMONDS, 5 of DIAMONDS,
9 of CLUBS, 4 of DIAMONDS, 2 of HEARTS )

Hand 3: ( 3 of CLUBS, 8 of SPADES, K of HEARTS, J of CLUBS, 4 of SPADES, 2 of CLUBS, 2 of SPADES, 5 of HEARTS, 8 of HEARTS,
Q of SPADES )

Hand 4: ( J of SPADES, Q of HEARTS, 3 of HEARTS, T of DIAMONDS, 6 of SPADES, 8 of CLUBS, 3 of DIAMONDS, T of SPADES, 5 of
CLUBS, Q of CLUBS )

Hand 5: ( Q of DIAMONDS, A of SPADES, 3 of SPADES, 7 of HEARTS, K of CLUBS, J of HEARTS, J of DIAMONDS, 9 of HEARTS, 5 of
SPADES, 2 of DIAMONDS )


Process finished with exit code 0
---------------------------End Phase 4 Test Run #3------------------------------------ */