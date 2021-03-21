public class Hand
{
   public final int MAX_CARDS = 50;
   Card[] myCards;
   int numCards;
   public Hand()
   {  
   }
   public void resetHand()
   {
      numCards = 0;
   }
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
   public Card playCard()
   {
      return myCards[numCards - 1];
   }
   public String toString()
   {
      String str = "";
      for(int i = 0; i < numCards; i++)
      {
         if(numCards == MAX_CARDS - 1)
         {
            str += myCards[i].getValue() + " of " + myCards[i].getSuit() + " ";
         }
         else
         {
            str += myCards[i].getValue() + " of " + myCards[i].getSuit() + ", ";
         }
      }
      return str;
   }
   public int numCards()
   {
      return numCards;
   }
   Card inspectCard(int k)
   {
      if(k < 0 || k > MAX_CARDS)
      {
         Card card = new Card('W', Card.Suit.SPADES);
         return card;
      }
      else
      {
         return myCards[k];
      }
   }
}