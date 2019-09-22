//   There is a robot on the game field.
//   The position of the robot on this field is described by two integer coordinates: X and Y.
//   The X axis is oriented from left to right, the Y axis — from bottom to top.
//   At the initial moment, the robot is in some coordinate on the field.
//   It's also known where the robot looks: up, down, to the right or to the left.
//   The initial position of the robot and its direction can have any values.
//   You need to bring the robot to the destination point of the game field.
//   A robot is described by the Robot class. You can use the following methods of this class
//   (with unknown implementation):
//    The direction of the robot is an enumeration:

//        The following values are passed to the method: toX == 3, toY == 0.
//        The initial state of this robot: robot.getX() == 0, robot.getY() == 0,
//        robot.getDirection() == Direction.UP.
//        To bring the robot to the destination point (3, 0),
//        the method should call the following methods:
//        robot.turnRight();
//        robot.stepForward();
//        robot.stepForward();
//        robot.stepForward();

public class Robot {

    private Direction getDirection() {
        // current direction
    }

    private int getX() {
        // current X coordinate
    }

    private int getY() {
        // current Y o
    }

    private void turnLeft() {
        // rotate the robot 90 degrees counterclockwise
    }

    private void turnRight() {
        // rotate the robot 90 degrees clockwise
    }

    private void stepForward() {
        // take one step in the current direction
        // x or y coordinate will be changed by 1
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static void moveRobot(Robot robot, int toX, int toY) {

        while (robot.getX() != toX || robot.getY() != toY) {

            String direction = robot.getDirection().toString();

            if (robot.getX() < toX) {
                while (!direction.equals("RIGHT")) {
                    robot.turnRight();
                }
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            }

            if (robot.getY() < toY) {
                while (!direction.equals("UP")) {
                    robot.turnLeft();
                }
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            }

            if (robot.getX() > toX) {
                while (!direction.equals("LEFT")) {
                    robot.turnLeft();
                }
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            }

            if (robot.getY() > toY) {
                while (!direction.equals("DOWN")) {
                    robot.turnLeft();
                }
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            }
        }
    }
}


