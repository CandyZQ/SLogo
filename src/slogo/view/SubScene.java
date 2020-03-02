package slogo.view;

import java.util.*;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import slogo.controller.listings.MovingObjectProperties;

public abstract class SubScene {

  //new Locale("fr", "FR")
  //new Locale("zh", "CN")
  //
  protected Group root;
  protected VBox vBox;
  protected Object language;
  protected Locale languageLocation;

  protected static ResourceBundle myResources =
      ResourceBundle.getBundle("resources", Locale.getDefault());
  protected static ResourceBundle myLanguages =
      ResourceBundle.getBundle("languages", Locale.getDefault());

  public Group getRoot() {
    return root;
  }

  public abstract void update(Queue<EnumMap<MovingObjectProperties, Object>> movements);

//  private String getLanguage() {
//    languageLocation = new Locale()
//  }
}
