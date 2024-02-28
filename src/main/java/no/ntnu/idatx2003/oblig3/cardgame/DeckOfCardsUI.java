package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DeckOfCardsUI extends Application {
  @Override
  public void start(Stage stage) throws Exception {

    //Buttons
    Button startButton = new Button("Start Game");
    Button quitButton = new Button("Quit Game");

    //BorderPane
    BorderPane borderMenu = new BorderPane();

    //Setting boxes
    HBox topMenu = new HBox();
    VBox leftMenu = new VBox();
    VBox rightMenu = new VBox();
    HBox bottomMenu = new HBox();

    //Setting the size of the boxes
    topMenu.setPrefSize(300, 50);
    leftMenu.setPrefSize(100, 300);
    rightMenu.setPrefSize(100, 300);
    bottomMenu.setPrefSize(300, 50);

    //Adding colors to the boxes
    topMenu.setStyle("-fx-background-color: #336699;");
    leftMenu.setStyle("-fx-background-color: #190257;");
    rightMenu.setStyle("-fx-background-color: #682734;");
    bottomMenu.setStyle("-fx-background-color: #942374;");

    //Adding buttons to the boxes
    leftMenu.getChildren().add(startButton);
    leftMenu.getChildren().add(quitButton);

    //Adding boxes to the border
    borderMenu.setTop(topMenu);
    borderMenu.setLeft(leftMenu);
    borderMenu.setRight(rightMenu);
    borderMenu.setBottom(bottomMenu);

    //Root
    FlowPane rootNodeMenu = new FlowPane();

    //Setting colors to the groups

    rootNodeMenu.getChildren().addAll(borderMenu);

    Scene scene = new Scene(rootNodeMenu, 300, 200);
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();
  }

  public static void appMain(String[] args) {
    launch();
  }
}