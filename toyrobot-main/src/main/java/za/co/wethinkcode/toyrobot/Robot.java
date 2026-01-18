package za.co.wethinkcode.toyrobot;

import java.util.Arrays;
import java.util.List;

public class Robot {
    public static final Position CENTRE = new Position(0,0);
    private static final List<String> VALID_COMMANDS = Arrays.asList("off", "help", "forward");

    private static int MIN_Y = -200, MAX_Y = 200;
    private static int MIN_X = -100, MAX_X = 100;

    private int positionX;
    private int positionY;
    private Direction currentDirection;
    private String status;
    private String name;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.positionX = 0;
        this.positionY = 0;
        this.currentDirection = Direction.NORTH;
    }

    public String getStatus() {                                                                         //<5>
        return this.status;
    }

    public int getPositionX() {                                                                         //<6>
        return this.positionX;
    }

    public int getPositionY() {                                                                         //<7>
        return this.positionY;
    }

    public Direction getCurrentDirection() {                                                               //<8>
        return this.currentDirection;
    }

    public boolean isValidCommand(String commandInput){
        String[] args = commandInput.strip().split(" ");
        String command = args[0].trim().toLowerCase();
        return VALID_COMMANDS.contains(command);
    }

    public boolean handleCommand(Command command) {
        String commandName = command.getName();

        switch (commandName){
            case "off":
                this.status = "Shutting down";
                break;
            case "help":
                this.status = doHelp();
                break;
            case "forward":
                String argument = command.getArgument();
                this.status = doForward(Integer.parseInt(argument));
                break;
            default:
                this.status = "I am not programmed for: " + command.getName();
        }
        return true;
    }

    private String doHelp() {
        return "I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'";
    }


    private boolean isPositionAllowed(int newX, int newY){
        return MIN_X <= newX && newX <= MAX_X
                && MIN_Y <= newY && newY <= MAX_Y;
    }

    boolean updatePosition(int nrSteps){
        int newY = this.positionY;
        int newX = this.positionX;

        if (Direction.NORTH.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }

        if (isPositionAllowed(newX, newY)){
            this.positionX = newX;
            this.positionY = newY;
            return true;
        }
        return false;
    }


    private String doForward(int nrSteps){
        if (updatePosition(nrSteps)){
            return "Moved forward by "+nrSteps+" steps.";
        } else {
            return "Sorry, I cannot go outside my safe zone.";
        }
    }

    @Override
    public String toString() {
        return "[" + this.positionX + "," + this.positionY + "] "
                /*+ "{" + this.currentDirection + "} "*/ + this.name + "> " + this.status;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public Position getPosition() {
        return new Position(this.positionX, this.positionY);
    }
}
