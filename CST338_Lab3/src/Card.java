/**
 * Lab 3: Decks of Cards
 * CST 338: Software Design (Spring B 2021)
 * 
 * Create a deck of cards program that includes several types of classes.
 * Each class contains it's own function within the program.
 * 4 phases are to be created and tested.
 * 
 * @author Michael Hackett, Katherine Vickstrom, Mike Limpus, Deen Altawil
 */

public class Card
{
   private char value;
   private Suit suit;
   private boolean errorFlag;
   public enum Suit
   {
      CLUBS, DIAMONDS, HEARTS, SPADES
   }
   public Card(char value, Suit suit)
   {
      set(value, suit);
   }
   public Card()
   {
      value = 'A';
      suit = Suit.SPADES;
   }
   public char getValue()
   {
      return value;
   }
   public Suit getSuit()
   {
      return suit;
   }
   public boolean errorFlag()
   {
      return errorFlag;
   }
   public boolean equals(Card card)
   {
      return (value == card.value && suit == card.suit && errorFlag == card.errorFlag);
   }
   public boolean set(char value, Suit suit)
   {
      errorFlag = !isValid(value, suit);
      if(!errorFlag)
      {
         this.value = value;
         this.suit = suit;
      }
      return !errorFlag;
   }

   public String toString()
   {
      if(!errorFlag)
      {
         return value + " of " + suit;
      }
      return "[invalid]";
   }
   private boolean isValid(char value, Suit suit)
   {
      boolean isValid = false;
      char[] validChars = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
      for (int i = 0; i < validChars.length; i++)
      {
         if (value == validChars[i]) isValid = true;
      }
      return isValid;
   }
   //Phase 1
   public static void main(String[] args)
   {
      Card card1 = new Card('1', Card.Suit.DIAMONDS);
      Card card2 = new Card('K', Card.Suit.SPADES);
      Card card3 = new Card('J', Card.Suit.CLUBS);

      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());

      card1.set('Q', Card.Suit.DIAMONDS);
      card2.set('1', Card.Suit.SPADES);

      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());
   }
}



