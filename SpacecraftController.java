public class SpacecraftController {
    private int x;
    private int y;
    private int z;
    private Direction direction;

    public SpacecraftController(int x, int y, int z, Direction direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }

    public void executeCommands(String[] commands) {
        for (String command : commands) {
            switch (command) {
                case "f":
                    moveForward();
                    break;
                case "b":
                    moveBackward();
                    break;
                case "r":
                    turnRight();
                    break;
                case "l":
                    turnLeft();
                    break;
                case "u":
                    moveUp();
                    break;
                case "d":
                    moveDown();
                    break;
                default:
                    // Ignore invalid command
                    break;
            }
        }
    }

    private void moveForward() {
        switch (direction) {
            case N:
                y++;
                break;
            case S:
                y--;
                break;
            case E:
                x++;
                break;
            case W:
                x--;
                break;
            case Up:
                z++;
                break;
            case Down:
                z--;
                break;
        }
    }

    private void moveBackward() {
        switch (direction) {
            case N:
                y--;
                break;
            case S:
                y++;
                break;
            case E:
                x--;
                break;
            case W:
                x++;
                break;
            case Up:
                z--;
                break;
            case Down:
                z++;
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case N:
                direction = Direction.E;
                break;
            case S:
                direction = Direction.W;
                break;
            case E:
                direction = Direction.S;
                break;
            case W:
                direction = Direction.N;
                break;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case N:
                direction = Direction.W;
                break;
            case S:
                direction = Direction.E;
                break;
            case E:
                direction = Direction.N;
                break;
            case W:
                direction = Direction.S;
                break;
        }
    }

    private void moveUp() {
        if (direction == Direction.N || direction == Direction.S) {
            z++;
        }
    }

    private void moveDown() {
        if (direction == Direction.N || direction == Direction.S) {
            z--;
        }
    }

    public String getPosition() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public Direction getDirection() {
        return direction;
    }

    public static void main(String[] args) {
        String[] commands = {"f", "r", "u", "b", "l"};
        SpacecraftController controller = new SpacecraftController(0, 0, 0, Direction.N);
        controller.executeCommands(commands);
        System.out.println("Final Position: " + controller.getPosition());
        System.out.println("Final Direction: " + controller.getDirection());
    }
}

enum Direction {
    N, S, E, W, Up, Down
}
