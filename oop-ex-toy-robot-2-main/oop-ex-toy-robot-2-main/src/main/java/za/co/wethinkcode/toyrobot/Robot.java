package za.co.wethinkcode.toyrobot;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private final Position TOP_LEFT = new Position(-200,100);
    private final Position BOTTOM_RIGHT = new Position(100,-200);

    public static final Position CENTRE = new Position(0,0);

    private Position position;
    private Direction currentDirection;
    private String status;
    private String name;
    private final List<Command> history = new ArrayList<>();

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.position = CENTRE;
        this.currentDirection = Direction.UP;
    }

    public String getStatus() {
        return this.status;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public boolean handleCommand(Command command) {
        boolean result = command.execute(this);
        if (result && !(command instanceof ReplayCommand)) {
            addToHistory(command);
        }
        return result;
    }

    public boolean updatePosition(int nrSteps) {
        int newX = this.position.getX();
        int newY = this.position.getY();

        switch (this.currentDirection) {
            case UP:
            case NORTH:
                newY += nrSteps;
                break;
            case DOWN:
                newY -= nrSteps;
                break;
            case LEFT:
                newX -= nrSteps;
                break;
            case RIGHT:
                newX += nrSteps;
                break;
        }

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT, BOTTOM_RIGHT)) {
            this.position = newPosition;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
       return "[" + this.position.getX() + "," + this.position.getY() + "] "
               + this.name + "> " + this.status;
    }

    public void addToHistory(Command command) {
        if (command instanceof ForwardCommand ||
                command instanceof BackCommand ||
                command instanceof LeftCommand ||
                command instanceof RightCommand ||
                command instanceof SprintCommand) {
            history.add(command);
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }

    public List<Command> getHistory() {
        return new ArrayList<>(history);
    }
}