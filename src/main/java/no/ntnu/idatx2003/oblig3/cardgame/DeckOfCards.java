package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class DeckOfCards {
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private final char[] faces = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
  private final ArrayList<PlayingCard> deck;

  /**
   * Constructor for the DeckOfCards.
   */
  public DeckOfCards() {
    this.deck = new ArrayList<>(52);
    for (char suit : this.suits) {
      for (char face : this.faces) {
        this.deck.add(new PlayingCard(suit, face));
      }
    }
  }

  /**
   * Returns a deck of n random cards.
   * The cards are removed from the deck.
   *
   * @param numberOfRandomCards the number of random cards to return.
   * @return an array of random cards.
   */
  public ArrayList<PlayingCard> dealHand(int numberOfRandomCards) {
    if (numberOfRandomCards > this.deck.size()) {
      throw new IllegalArgumentException("Number of cards to deal is greater than the number of cards in the deck.");
    } else if (numberOfRandomCards <= 0) {
      throw new IllegalArgumentException("Number of cards to deal cannot be negative or 0.");
    }
    ArrayList<PlayingCard> randomDeck = new ArrayList<>(); // Create a new array list for the random deck.
    Random rand = new Random(); // Create a new random object.
    for (int i = 0; i < numberOfRandomCards; i++) { // Loop through the random deck.
      int randomIndex = rand.nextInt(this.deck.size()); // Get a random index from the deck list.
      randomDeck.add(this.deck.get(randomIndex)); // Add the card to the random deck.
      this.deck.remove(randomIndex); // Remove the card from the deck list.
    }
    return randomDeck;
  }

  /**
   * Returns the deck of cards.
   *
   * @return the deck of cards.
   */
  public Iterator<PlayingCard> getDeck() {
    ArrayList<PlayingCard> deckList = new ArrayList<PlayingCard>(this.deck);
    return deckList.iterator();
  }
}