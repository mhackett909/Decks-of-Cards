/**
 * Lab 3: Decks of Cards
 * CST 338: Software Design (Spring B 2021)
 *
 * The Hand class defines what hand the player was dealt by
 * the dealer. It uses the Card class to define the cards.
 */
public class Hand
{
   public final int MAX_CARDS = 50;
   Card[] myCards;
   int numCards;
   public Hand()
   {
      numCards = 0;
      myCards = new Card[MAX_CARDS];
   }
   //Public methods
   /**
    * Method to remove all cards from hand. Resets
    * the array index to 0.
    */
   public void resetHand()
   {
      numCards = 0;
   }
   /**
    * Method to add a new card to the hand.
    * Adds an object copy of the card to the
    * current array position and increments numCards.
    *
    * @param card The card to add to the hand
    * @return false if an invalid card was pulled, otherwise true
    */
   public boolean takeCard(Card card)
   {
      if(card.errorFlag() == true || card == null || numCards == MAX_CARDS)
      {
         return false;
      }
      else
      {
         myCards[numCards++] = new Card(card.getValue(),card.getSuit());
         return true;
      }
   }
   /**
    * Returns and removes the top card to be played.
    * Decrements numCards and returns a new card
    * object with copied values.
    *
    * @return The card to be played
    */
   public Card playCard()
   {
      return (numCards > 0 ? new Card(myCards[--numCards].getValue(), myCards[numCards].getSuit()): null);
   }
   /**
    * Method to return the full hand as a string
    */
   public String toString()
   {
      String str = "";
      for(int i = 0; i < numCards; i++)
      {
         //checks if last card which doesn't need comma
         if(i == numCards - 1)
         {
            str += myCards[i].getValue() + " of " + myCards[i].getSuit();
         }
         else
         {
            str += myCards[i].getValue() + " of " + myCards[i].getSuit() + ", ";
         }
      }
      return str;
   }
   //Accessors
   public int getNumCards()
   {
      return numCards;
   }
   /**
    * An accessor method for a card at index k.
    * If the requested card does not exist, return
    * an invalid card.
    *
    * @param k The array index
    * @return The card at index k or an invalid card
    */
   public Card inspectCard(int k)
   {
      if(k < 0 || k > MAX_CARDS || myCards[k] == null)
      {
         return new Card('W', Card.Suit.SPADES);
      }
      else
      {
         return new Card(myCards[k].getValue(), myCards[k].getSuit());
      }
   }
}