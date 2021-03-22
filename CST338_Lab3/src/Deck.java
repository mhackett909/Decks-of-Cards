/**
 * Lab 3: Decks of Cards
 * CST 338: Software Design (Spring B 2021)
 * 
 * Deck: class object that will contain the source of all Card objects. Contains
 * and array of Card objects <code>cards[]</code>. It will contain a multiple 
 * of 52 cards, as some games rely on multiple decks.
 */
public class Deck {
    // Members and constants
    public static final int MAX_CARDS = 312;    // 312 = 6 * 52, so, six decks
    private static boolean allocated = false; 
    private static Card[] masterPack = new Card[52]; // contains every card type
    private Card[] cards;
    private int topCard; 

    // Public Methods
    /**
     * Default Constructor assumes 1 pack
     */
    public Deck() {
        allocateMasterPack();
        init(1);
    }

    /**
     * Constructor will populate the arrays
     * @param numPacks
     */
    public Deck(int numPacks) {
        allocateMasterPack();        
        init(numPacks);
    }

/*  TODO probably remove this, I don't think we need this
    public Deck(Deck deck) {
        cards = deck.cards;
        topCard = deck.topCard;
        if (allocated == false) {
            allocateMasterPack();
        }
    } */

    /**
     * fill the cards array with Card objects from the masterPack
     * @param numPacks
     */
    public void init(int numPacks) {
        cards = new Card[(numPacks * 52)]; 
        // an 'iterator' that should not be > 52 for masterPack reference
        int j = 0;      
        for (int i = 0; i < cards.length; ++i) {
            cards[i] = masterPack[j];
            j++;
            if (i % 52 == 0 && i != 0) { // Start at masterPack[0] again
                j = 0;
            }
        }
    }

    /**
     * Mixes up the cards with the help of the standard random number generator
     */
    public void shuffle() { 
        for (int i = 0; i < cards.length; ++i) {
           int randIndex = (int) (Math.random() * 100);
           // TODO Finish this
        }
    }

    /**
     * dealCard returns and removes the card in the top occupied position of 
     * cards[]. Make sure there are still cards available.  This is an object
     * copy, not a reference copy, since the source of the Card might destroy or
     * change its data after it is sent out.
     * @return A card or null if none available
     */

    public Card dealCard() {
        Card dealtCard;
        for (int i = 0; i < cards.length; ++i) {
            if (cards[i] != null) {
                dealtCard = cards[i];
                cards[i] = null;
                return new Card(dealtCard.getValue(), dealtCard.getSuit());
            }
        }
        return null;
    }


    public int getTopCard() {
        return topCard;
    }
    
    /**
     * Accessor for an individual card.  Returns a card with errorFlag = true if
     * k is bad.  Also returns an object copy, not a reference copy.
     * 
     * TODO: implement errorflag; need to ask about this
     * @param k
     */
    public Card inspectCard(int k) {
            return new Card(cards[k].getValue(), cards[k].getSuit());
    }

    private static void allocateMasterPack() {
        if(allocated == false) {
            char[] values = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T',
                 'J', 'Q', 'K'};
            Card.Suit[] suits = { Card.Suit.CLUBS, Card.Suit.DIAMONDS, 
                Card.Suit.HEARTS, Card.Suit.SPADES };
            int k = 0; // Reference for the location in masterPack[]
            for (int i = 0; i < 4; ++i) {
                for(int j = 0; j < 13; ++j) {
                    masterPack[k] = new Card(values[j], suits[i]);
                }
            }
            allocated = true;
        }
    }

}
