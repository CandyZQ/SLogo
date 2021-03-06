package slogo.model;

import java.util.Map;
import slogo.controller.listings.MovingObjectProperties;

/**
 * This is the backend internal API for the slogo project.
 * <p></p>
 * This class stores necessary state information, multiple operations that changes some or all of
 * the state information, and a getter methods that returns all state information. The state
 * information includes:
 * <ul>
 *   <li>the x position</li>
 *   <li>the y position</li>
 *   <li>the direction in which this object is heading</li>
 *   <li>the visibility</li>
 * </ul>
 */
public interface MovingObject {

  /**
   * Rotates turtle by changing heading
   *
   * @param offset Positive offset is clockwise, negative offset is counterclockwise
   * @return offset
   */
  double rotate(double offset);

  /**
   * Gets the distance this {@link MovingObject} travelled when the state changes
   *
   * @return the distance travelled
   */
  double getDistanceTravelled();

  /**
   * Moves this object forward/backward certain distance
   *
   * @param distance the distance to be moved, positive value moves this object forward while
   *                 negative value moves it backward
   * @return the distance moved
   */
  double moveDistance(double distance);

  /**
   * Sets the new heading of this object
   *
   * @param angle the new heading, which assumes EAST of (0,0) is 0 degree and turning
   *              counterclockwise from EAST increases angle
   * @return the number of degree moved
   */
  double setHeading(double angle);

  void clear();

  /**
   * Updates Turtle heading to face (x,y) Does this by calculating angle then called public double
   * setheading(double angle)
   *
   * @param (x,y) is point turtle has rotated to face.
   * @return absolute value of number of degrees moved
   */
  double setHeading(double x, double y);

  /**
   * Sets the position of this object
   *
   * @param x the x position
   * @param y the y position
   * @return the distance moved
   */
  double setCoordinates(double x, double y);


  /**
   * Moves this object to the center of the screen and sets heading ot 0
   *
   * @Return total distance travelled by object since instantiated TODO: did they mean distance to
   * get back home??
   */
  double reset();

  /**
   * Gets all state information of this object as a {@link Map}
   *
   * @return a {@link Map} containing all state information
   */
  Map<MovingObjectProperties, Object> getState();
}