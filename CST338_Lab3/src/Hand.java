/*
 * The Hand class defines what hand the player was dealt by
 * the dealer. It uses the Card class to define the cards.
 */

public class Hand
{
   public final int MAX_CARDS = 50;
   Card[] myCards = new Card[MAX_CARDS];
   int numCards;
   public Hand()
   {  
   }
   //Method to remove all cards from hand
   public void resetHand()
   {
      numCards = 0;
   }
   /*
    * Method to add a card to the hand
    * Returns false if an invalid card was pulled, otherwise true
    */
   public boolean takeCard(Card card)
   {
      if(card.errorFlag() == true || card == null || numCards > MAX_CARDS)
      {
         return false;
      }
      else
      {
         myCards[numCards++] = new Card(card.getValue(),card.getSuit());
         return true;
      }
   }
   //Method returns the top card to be played
   public Card playCard()
   {
      Card card = new Card(myCards[numCards - 1].getValue(), 
            myCards[numCards - 1].getSuit());
      myCards[numCards - 1] = null;
      numCards--;
      return card;
   }
   //Method to return the full hand as a string
   public String toString()
   {
      String str = "";
      for(int i = 0; i < numCards; i++)
      {
         if(myCards[i] == null)
         {
            break;
         }
         //checks if last card which doesn't need comma
         else if(i == numCards - 1)
         {
            str += myCards[i].getValue() + " of " + myCards[i].getSuit();
         }
         else
         {
            str += myCards[i].getValue() + " of " + 
                  myCards[i].getSuit() + ", ";
         }
      }
      return str;
   }
   //Getter for numCards
   public int getNumCards()
   {
      return numCards;
   }
   //Method returns card at array index k, returns invalid card if k is bad
   Card inspectCard(int k)
   {
      if(k < 0 || k > MAX_CARDS || myCards[k] == null)
      {
         Card card = new Card('W', Card.Suit.SPADES);
         return card;
      }
      else
      {
         return myCards[k];
      }
   }
   //Phase 2 main program to test Hand class
   public static void main(String[] args)
   {
      Card card1 = new Card('2', Card.Suit.DIAMONDS);
      Card card2 = new Card('K', Card.Suit.SPADES);
      Card card3 = new Card('J', Card.Suit.CLUBS);
      Card card4 = new Card('Q', Card.Suit.HEARTS);
      Card card5 = new Card('9', Card.Suit.CLUBS);
      Hand hand = new Hand();
      for(int i = 0; i < 10; i++)
      {
         hand.takeCard(card1);
         hand.takeCard(card2);
         hand.takeCard(card3);
         hand.takeCard(card4);
         hand.takeCard(card5);
      }
      System.out.println("Hand = ( " + hand.toString() + " )");
      System.out.println("Testing inspectCard()\n" + 
            hand.inspectCard(0).toString());
      System.out.println(hand.inspectCard(-1).toString());
      for(int i = 0; i < hand.MAX_CARDS; i++)
      {
         System.out.println("Playing " + hand.playCard());
      }
      System.out.println("Hand = ( " + hand.toString() + " )");
   }
}