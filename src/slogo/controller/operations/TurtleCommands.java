package slogo.controller.operations;

import slogo.controller.MovingObjectProperties;
import slogo.model.Turtle;

public class TurtleCommands {

  Turtle turtle;

  public TurtleCommands(Turtle turtle) {
    this.turtle = turtle;
  }

  public void forward(Double pixels) {
    turtle.moveDistance(pixels);
  }

  public void backward(Double pixels) {
    turtle.moveDistance(-pixels);
  }

  public void left(Double degrees) {
    turtle.setHeading((Double) turtle.getState().get(MovingObjectProperties.HEADING) + degrees);
  }

  public void right(Double degrees) {
    left(-degrees);
  }

  public void setHeading(Double degrees) {
    turtle.setHeading(degrees);
  }

  public void setTowards(Double x, Double y) {
    turtle.setHeading(x, y);
  }

  public void setPosition(Double x, Double y) {
    turtle.setHeading(x, y);
    turtle.setCoordinates(x, y);
  }

  public void penDown() {
    turtle.getState().put(MovingObjectProperties.PEN, 1);
    turtle.getState().put(MovingObjectProperties.RETURN_VALUE, 1);
  }

  public void penUp() {
    turtle.getState().put(MovingObjectProperties.PEN, 0);
    turtle.getState().put(MovingObjectProperties.RETURN_VALUE, 0);
  }

  public void showTurtle() {
    turtle.getState().put(MovingObjectProperties.VISIBILITY, 1);
    turtle.getState().put(MovingObjectProperties.RETURN_VALUE, 1);
  }

  public void hideTurtle() {
    turtle.getState().put(MovingObjectProperties.VISIBILITY, 0);
    turtle.getState().put(MovingObjectProperties.RETURN_VALUE, 0);
  }

  public void home() {
    turtle.setCoordinates(0, 0);
  }

  public void clearScreen() {
    // TODO: remove screen trails
    turtle.setCoordinates(0, 0);
  }
}