package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    DeckOfCards deck = new DeckOfCards();
    PlayingCard[] shuffledCards = deck.dealHand(5);
    for (PlayingCard card : shuffledCards) {
      System.out.println(card.getAsString());
    }
  }
}