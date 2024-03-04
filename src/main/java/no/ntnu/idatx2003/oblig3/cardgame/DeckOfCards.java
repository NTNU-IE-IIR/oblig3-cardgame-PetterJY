package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
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
   * Returns the cards of hearts in the given array of cards.
   *
   * @return the cards of hearts in the given array of cards.
   */
  public ArrayList<PlayingCard> cardsOfHearts(ArrayList<PlayingCard> cards) {
    ArrayList<PlayingCard> hearts = new ArrayList<>();
    for (PlayingCard card : cards) {
      if (card.getSuit() == 'H') {
        hearts.add(card);
      }
    }
    return hearts;
  }

  /**
   * Return the sum of the faces given in the array of cards.
   *
   * @return the sum of the faces given in the array of cards.
   */
  public int sumOfFaces(ArrayList<PlayingCard> cards) {
    int sum = 0;
    for (PlayingCard card : cards) {
      sum += card.getFace();
    }
    return sum;
  }

  /**
   * Checks if the provided in the arraylist is a flush or not.
   * Returns true if it's a flush, else return false.
   *
   * @param cards the hand to check
   * @return true if it's a flush, false if not.
   */
  public boolean checkFlush(ArrayList<PlayingCard> cards) {
    boolean isFlush = true;
    char firstCardType = cards.get(0).getSuit();
    int i = 0;
    while (i < cards.size() && isFlush) {
      char cardType =  cards.get(i).getSuit();
      if (firstCardType == cardType) {
        isFlush = false;
      }
      i++;
    }
    return isFlush;
  }

  /**
   * Checks if the provided array contains the queen of spades.
   * Returns true if it contains the queen of spades, else return false.
   *
   * @param cards the hand to check
   * @return true if it contains the queen of spades, false if not.
   */
  public boolean containsQueenOfSpades(ArrayList<PlayingCard> cards) {
    boolean containQueenOfSpades = false;
    int i = 0;
    while (i < cards.size() && !containQueenOfSpades) {
      PlayingCard card = cards.get(i);
      if (card.getAsString().equals("S12")) {
        containQueenOfSpades = true;
      }
      i++;
    }
    return containQueenOfSpades;
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