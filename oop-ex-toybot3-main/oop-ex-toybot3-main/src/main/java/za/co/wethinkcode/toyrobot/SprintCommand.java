package za.co.wethinkcode.toyrobot;

public class SprintCommand extends Command {
    public SprintCommand(String argument) {
        super("sprint", argument);
    }

    @Override
    public boolean execute(Robot target) {
        int nrSteps = Integer.parseInt(getArgument());

        if (target.updatePosition(nrSteps)) {
            while (nrSteps > 0) {
                target.setStatus("Moved forward by " + nrSteps + " steps.");
                System.out.println(target);
                target.setCurrentDirection(Direction.UP);
                nrSteps--;
                target.updatePosition(nrSteps);

                if (nrSteps == 1) {
                    break;
                }
            }
            target.setStatus("Moved forward by " + nrSteps + " steps.");
        } else {
            target.setStatus("Sorry I cannot go outside my safe zone.");
        }
        return true;
    }
}