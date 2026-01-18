package za.co.wethinkcode.toyrobot;

public class LeftCommand extends Command {
    public LeftCommand() {
        super("left");
    }

    @Override
    public boolean execute(Robot target) {
        if(target.getCurrentDirection() == Direction.LEFT){
            target.setStatus("Turned left.");
            target.setCurrentDirection(Direction.DOWN);
        }
        else if(target.getCurrentDirection() == Direction.DOWN){
            target.setStatus("Turned left.");
            target.setCurrentDirection(Direction.RIGHT);
        }
        else if(target.getCurrentDirection() == Direction.RIGHT){
            target.setStatus("Turned left.");
            target.setCurrentDirection(Direction.UP);
        }else{
            target.setStatus("Turned left.");
            target.setCurrentDirection(Direction.LEFT);
        }
        return true;
    }
}
