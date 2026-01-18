package za.co.wethinkcode.toyrobot;

public class RightCommand extends Command {
    public RightCommand() {
        super("right");
    }

    @Override
    public boolean execute(Robot target) {
        if(target.getCurrentDirection() == Direction.RIGHT){
            target.setStatus("Turned right.");
            target.setCurrentDirection(Direction.DOWN);
        }
        else if(target.getCurrentDirection() == Direction.DOWN){
            target.setStatus("Turned right.");
            target.setCurrentDirection(Direction.LEFT);
        }
        else if(target.getCurrentDirection() == Direction.LEFT){
            target.setStatus("Turned right.");
            target.setCurrentDirection(Direction.UP);
        }else{
            target.setStatus("Turned right.");
            target.setCurrentDirection(Direction.RIGHT);
        }
        return true;
    }
}
