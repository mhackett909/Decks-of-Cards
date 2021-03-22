/**
 * Lab 3: Decks of Cards
 * CST 338: Software Design (Spring B 2021)
 *
 * Holds information about an individual card.
 * Contains the value, suit, and an error flag.
 * Uses an enum for card suits.
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
   //Constructors
   public Card(char value, Suit suit)
   {
      set(value, suit);
   }
   public Card()
   {
      value = 'A';
      suit = Suit.SPADES;
   }
   //Accessors and Modifier
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
   /**
    * A single modifier for all private data.
    * Sets the card's value and suit. Sets an
    * error flag upon failure.
    *
    * @param value The card's value
    * @param suit The card's suit
    * @return The card's error flag
    */
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
   //Public methods
   /**
    * A "stringizer" method that returns a clean representation of a card.
    *
    * @return "[invalid]" if errorFlag == true
    *
   */
   public String toString()
   {
      if(!errorFlag)
      {
         return value + " of " + suit;
      }
      return "[invalid]";
   }
   /**
    * Checks if this card is identical to the provided card.
    *
    * @param card The card to compare
    * @return True if cards are identical
    */
   public boolean equals(Card card)
   {
      return (value == card.value && suit == card.suit && errorFlag == card.errorFlag);
   }
   //Private methods
   /**
    * Validates that the received data can be
    * used to create a card. Card value must be
    * found in the array of valid characters.
    *
    * @param value The card value to be verified
    * @param suit The card's suit
    * @return True if the card is valid.
    */
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
   /*Phase 1
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
   }*/
}



