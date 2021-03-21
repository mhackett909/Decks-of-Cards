//Assignment 3:
/*Create a deck of cards program that includes several types of classes.
 *Each class contains it's own function within the program.
 *4 phases are to be created and tested.
*/
public class Card
{
   //Phase 1
   public static void main(String[] args)
   {
      Card card1 = new Card('1', Card.Suit.DIAMONDS);
      Card card2 = new Card('K', Card.Suit.SPADES);
      Card card3 = new Card('J', Card.Suit.CLUBS);

      System.out.print(card1.toString());
      System.out.print(card2.toString());
      System.out.print(card3.toString());

      card1.set('1', Card.Suit.DIAMONDS);
      card2.set('Q', Card.Suit.SPADES);

      System.out.print(card1.toString());
      System.out.print(card2.toString());
      System.out.print(card3.toString());
   }
}
