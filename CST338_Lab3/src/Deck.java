/**
 * Lab 3: Decks of Cards
 * CST 338: Software Design (Spring B 2021)
 * 
 * Deck: class object that will contain the source of all Card objects. Contains
 * and array of Card objects <code>cards[]</code>. It will contain a multiple 
 * of 52 cards, as some games rely on multiple decks. 
 * 
 * @author Michael Hackett, Katherine Vickstrom, Mike Limpus, Deen Altawil
 */
public class Deck {
    // Members and constants
    public static final int MAX_CARDS = 312;    // 312 = 6 * 52, so, six decks
    private Card[] masterPack = new Card[52];   // contains every card type
    private Card[] cards;
    int topCard; 

    // Public Methods
    // Constructor will populate the arrays
    public Deck(int numPacks) {
        allocateMasterPack();        
        init(numPacks);
    }

    public void init(int numPacks) {
        cards = new Card[(numPacks * 52)]; 
    }

    public Card dealCard() {
        return null;
    }

    public void shuffle() { }
    private static void allocateMasterPack() {
        // TODO Write me pls
    }

}
