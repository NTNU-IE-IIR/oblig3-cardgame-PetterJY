package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A UI for the DeckOfCards class.
 */
public class DeckOfCardsUi extends Application {
  private DeckOfCards deck; // The deck of cards.
  private ArrayList<PlayingCard> hand; // The hand of cards.

  /**
   * Constructor for the DeckOfCardsUi.
   */
  public DeckOfCardsUi() {
    this.deck = new DeckOfCards(); // Create a new deck of cards.
  }

  /**
   * Starts the UI.
   *
   * @param stage the window.
   * @throws Exception if the UI cannot be started.
   */
  @Override
  public void start(Stage stage) throws Exception {
    GridPane subBottom = new GridPane();
    //Setting the position of the GridPanes
    subBottom.setPadding(new Insets(10, 10, 10, 10));
    subBottom.setHgap(10);
    subBottom.setVgap(10);
    GridPane subCenter = new GridPane();
    subCenter.setPadding(new Insets(10, 10, 10, 10));
    subCenter.setHgap(10);
    subCenter.setVgap(10);

    //Setting boxes
    VBox center = new VBox();
    VBox right = new VBox();
    HBox bottom = new HBox();

    //Setting the size of the boxes
    center.setPrefSize(300, 200);
    right.setPrefSize(100, 300);
    bottom.setPrefSize(300, 50);

    //Adding colors to the boxes
    //Set to White for now
    center.setStyle("-fx-background-color: #FFFFFF");
    right.setStyle("-fx-background-color: #FFFFFF");
    bottom.setStyle("-fx-background-color: #FFFFFF");

    //Buttons
    Button dealHand = new Button("Deal Hand");
    Button checkHand = new Button("Check Hand");

    //Adding buttons to the boxes
    right.getChildren().add(dealHand);
    right.getChildren().add(checkHand);

    //Adding labels to the cards
    Label card1 = new Label();
    Label card2 = new Label();
    Label card3 = new Label();
    Label card4 = new Label();
    Label card5 = new Label();

    //Adding the checkHand labels
    TextField displaySumOfTheFaces = new TextField();
    TextField displayCardsOfHearts = new TextField();
    TextField displayIsFlush = new TextField();
    TextField displayQueenOfSpades = new TextField();

    //Adding the card labels to the subCenter GridPane
    //To be centered in the middle of the center box
    subCenter.add(card1, 0, 0);
    subCenter.add(card2, 1, 0);
    subCenter.add(card3, 2, 0);
    subCenter.add(card4, 3, 0);
    subCenter.add(card5, 4, 0);

    ArrayList<Label> cardLabels = new ArrayList<>();
    cardLabels.add(card1);
    cardLabels.add(card2);
    cardLabels.add(card3);
    cardLabels.add(card4);
    cardLabels.add(card5);

    //Setting alignment of the subCenter GridPane
    subCenter.setAlignment(Pos.CENTER);

    //Adding action to dealHand button
    try {
      dealHand.setOnAction(e -> {
        this.hand = this.deck.dealHand(5);
        for (int i = 0; i < this.hand.size(); i++) {
          cardLabels.get(i).setText(this.hand.get(i).getAsString());
        }
      });
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      checkHand.setOnAction(e -> {
        boolean isQueenOfSpades = this.deck.containsQueenOfSpades(this.hand);
        boolean isFlush = this.deck.checkFlush(this.hand);
        ArrayList<PlayingCard> hearts = this.deck.cardsOfHearts(this.hand);
        ArrayList<String> heartsAsString = new ArrayList<>();
        for (PlayingCard card : hearts) {
          heartsAsString.add(card.getAsString());
        }
        int sumOfFaces = this.deck.sumOfFaces(this.hand);
        displayQueenOfSpades.setText("" + isQueenOfSpades);
        displayIsFlush.setText("" + isFlush);
        displaySumOfTheFaces.setText("" + sumOfFaces);
        displayCardsOfHearts.setText(heartsAsString.toString());
      });
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    //Adding GridPanes to the boxes
    bottom.getChildren().addAll(subBottom);
    center.getChildren().addAll(subCenter);

    //Setting alignment of the boxes
    center.setAlignment(Pos.CENTER);
    bottom.setAlignment(Pos.CENTER);
    right.setAlignment(Pos.CENTER);

    //Adding labels fields of checkHand to the GridPanes
    subBottom.add(displaySumOfTheFaces, 1, 0);
    subBottom.add(displayCardsOfHearts, 3, 0);
    subBottom.add(displayIsFlush, 1, 1);
    subBottom.add(displayQueenOfSpades, 3, 1);

    //Adding labels to the text fields
    Label sumOfTheFacesLabel = new Label("Sum of the faces:");
    Label cardsOfHeartsLabel = new Label("Cards of hearts:");
    Label flushLabel = new Label("Flush:");
    Label queenOfSpadesLabel = new Label("Queen of spades:");

    //Adding labels to the GridPanes
    subBottom.add(sumOfTheFacesLabel, 0, 0);
    subBottom.add(cardsOfHeartsLabel, 2, 0);
    subBottom.add(flushLabel, 0, 1);
    subBottom.add(queenOfSpadesLabel, 2, 1);

    //BorderPane
    BorderPane borderPane = new BorderPane();

    //Adding boxes to the border
    borderPane.setCenter(center);
    borderPane.setRight(right);
    borderPane.setBottom(bottom);

    //Adding minimum size to the stage
    Scene scene = new Scene(borderPane, 300, 200);
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.setMinHeight(300);
    stage.setMinWidth(300);
    stage.show();
    stage.show();
  }

  /**
   * Returns the deck of cards.
   *
   * @return the deck of cards
   */
  public ArrayList<PlayingCard> getHand() {
    return hand;
  }

  public static void appMain(String[] args) {
    launch();
  }
}