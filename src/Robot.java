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

class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
        while (robot.getX() != toX || robot.getY() != toY) {

            if (robot.getX() < toX) {
                rotate(robot, "RIGHT");
                moveToX(robot, toX);
            }

            if (robot.getY() < toY) {
                rotate(robot, "UP");
                moveToY(robot, toY);
            }

            if (robot.getX() > toX) {
                rotate(robot, "LEFT");
                moveToX(robot, toX);
            }

            if (robot.getY() > toY) {
                rotate(robot, "DOWN");
                moveToY(robot, toY);
            }
        }
    }
    
    private static void rotate(Robot robot, String destination) {
        while (!robot.getDirection().toString().equals(destination)) {
            robot.turnLeft();
        }
    }
    
    private static void moveToX(Robot robot, int toX) {
        while (robot.getX() != toX) {
            robot.stepForward();
        }
    }
    
    private static void moveToY(Robot robot, int toY) {
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
