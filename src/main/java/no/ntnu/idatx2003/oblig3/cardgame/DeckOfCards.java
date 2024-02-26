package no.ntnu.idatx2003.oblig3.cardgame;

public class DeckOfCards {
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private final char[] faces = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
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
  
  public DeckOfCards dealHand(int n) {
    return null;
  }
}