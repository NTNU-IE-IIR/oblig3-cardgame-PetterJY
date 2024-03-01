package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DeckOfCardsUI extends Application {
  private DeckOfCards deck; // The deck of cards.
  public DeckOfCardsUI() {
    this.deck = new DeckOfCards(); // Create a new deck of cards.
  }
  @Override
  public void start(Stage stage) throws Exception {
    //Buttons
    Button dealHand = new Button("Deal Hand");
    Button checkHand = new Button("Check Hand");

    //Text fields
    TextField sumOfTheFaces = new TextField();
    TextField cardsOfHearts = new TextField();
    TextField flush = new TextField();
    TextField queenOfSpades = new TextField();

    //BorderPane
    BorderPane borderPane = new BorderPane();

    //Setting boxes
    VBox center = new VBox();
    VBox right = new VBox();
    HBox bottom = new HBox();

    //Setting GridPanes
    GridPane subBottom = new GridPane();
    GridPane subCenter = new GridPane();

    //Setting the position of the GridPanes
    subBottom.setPadding(new Insets(10, 10, 10, 10));
    subBottom.setHgap(10);
    subBottom.setVgap(10);

    subCenter.setPadding(new Insets(10, 10, 10, 10));
    subCenter.setHgap(10);
    subCenter.setVgap(10);

    //Setting the size of the boxes
    center.setPrefSize(300, 200);
    right.setPrefSize(100, 300);
    bottom.setPrefSize(300, 50);

    //Adding colors to the boxes
    //Set to White for now
    center.setStyle("-fx-background-color: #FFFFFF");
    right.setStyle("-fx-background-color: #FFFFFF");
    bottom.setStyle("-fx-background-color: #FFFFFF");

    //Adding buttons to the boxes
    right.getChildren().add(dealHand);
    right.getChildren().add(checkHand);

    //Adding labels to the cards
    Label card1 = new Label();
    Label card2 = new Label();
    Label card3 = new Label();
    Label card4 = new Label();
    Label card5 = new Label();

    //Adding the card labels to the subCenter GridPane
    //To be centered in the middle of the center box
    subCenter.add(card1, 0, 0);
    subCenter.add(card2, 1, 0);
    subCenter.add(card3, 2, 0);
    subCenter.add(card4, 3, 0);
    subCenter.add(card5, 4, 0);

    //Setting alignment of the subCenter GridPane
    subCenter.setAlignment(Pos.CENTER);

    //Adding action to dealHand button
    try {
    dealHand.setOnAction(e -> {
      ArrayList<PlayingCard> hand = this.deck.dealHand(5);
      card1.setText(hand.get(0).getAsString());
      card2.setText(hand.get(1).getAsString());
      card3.setText(hand.get(2).getAsString());
      card4.setText(hand.get(3).getAsString());
      card5.setText(hand.get(4).getAsString());
    });} catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    //Adding GridPanes to the boxes
    bottom.getChildren().addAll(subBottom);
    center.getChildren().addAll(subCenter);

    //Setting alignment of the boxes
    center.setAlignment(Pos.CENTER);
    bottom.setAlignment(Pos.CENTER);
    right.setAlignment(Pos.CENTER);

    //Adding text fields to the GridPanes
    subBottom.add(sumOfTheFaces, 1, 0);
    subBottom.add(cardsOfHearts, 3, 0);
    subBottom.add(flush, 1, 1);
    subBottom.add(queenOfSpades, 3, 1);

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

  public static void appMain(String[] args) {
    launch();
  }
}