package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DeckOfCardUI extends Application {
  public DeckOfCardUI(Stage stage) {
  }

  @Override
  public void start(Stage stage) throws Exception {
    Button button1 = new Button("Button 1");
    Button button2 = new Button("Button 2");
    Button button3 = new Button("Button 3");
    Button button4 = new Button("Button 4");

    FlowPane rootNode = new FlowPane();
    rootNode.getChildren().addAll(button1, button2, button3, button4);

    Scene scene = new Scene(rootNode, 300, 200);
    stage.setScene(scene);
    stage.setTitle("HelloWorld");
    stage.show();
  }
}