package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.random.*;

public class DeckOfCards {
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private final char[] faces = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
  private final PlayingCard[] deck;

  /**
   * Constructor for the DeckOfCards.
   */
  public DeckOfCards() {
    this.deck = new PlayingCard[52];
    int i = 0;
    for (char suit : this.suits) {
      for (char face : this.faces) {
        this.deck[i++] = new PlayingCard(suit, face);
      }
    }
  }

  /**
   * Returns  random cards from the deck.
   * Number of cards returned is specified by the parameter numberOfRandomCards.
   *
   * @param numberOfRandomCards the number of random cards to return.
   * @return an array of random cards.
   */
  public PlayingCard[] dealHand(int numberOfRandomCards) {
    PlayingCard[] randomDeck;
    randomDeck = new PlayingCard[numberOfRandomCards]; // Create a new array of random cards.
    Random rand = new Random(); // Create a new random object.
    for (int i = 0; i < numberOfRandomCards; i++) { // Loop through the random deck.
      PlayingCard randomPlayingCard = new PlayingCard(this.suits[rand.nextInt(suits.length)],
                                      this.faces[rand.nextInt(faces.length)]); // Create a new random card.
      for (PlayingCard checkedCard : randomDeck) { // Loop through the random deck.
        if (!randomPlayingCard.equals(checkedCard)) { // Check if the random card is not in the random deck.
          randomDeck[i] = randomPlayingCard; // Add the random card to the random deck.
        }
      }
    }
    return randomDeck;
  }

  /**
   * Returns the deck of cards.
   *
   * @return the deck of cards.
   */
  public Iterator<PlayingCard> getDeck() {
    ArrayList<PlayingCard> deckList = new ArrayList<PlayingCard>(Arrays.asList(this.deck));
    return deckList.iterator();
  }
}