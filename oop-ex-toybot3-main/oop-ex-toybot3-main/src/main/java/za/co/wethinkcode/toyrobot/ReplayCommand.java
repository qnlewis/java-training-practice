package za.co.wethinkcode.toyrobot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReplayCommand extends Command {

    public ReplayCommand(String argument) {
        super("replay", argument);
    }

    @Override
    public boolean execute(Robot target) {
        List<Command> history = target.getHistory();
        int total = history.size();

        boolean reversed = getArgument().contains("reversed");
        String cleanedArgument = getArgument().replace("reversed", "").trim();

        int[] range = getReplayRange(cleanedArgument, total);
        int startIndex = range[0];
        int endIndex = range[1];

        if (startIndex == -1) {
            target.setStatus("Invalid range: n must be greater than m.");
            return true;
        }

        List<Command> commandsToReplay = new ArrayList<>(
                history.subList(startIndex, endIndex)
        );

        if (reversed) {
            Collections.reverse(commandsToReplay);
        }

        replayCommands(target, commandsToReplay);
        target.setStatus("replayed " + commandsToReplay.size() + " commands.");
        return true;
    }

    private int[] getReplayRange(String input, int totalCommands) {
        int start = 0;
        int end = totalCommands;

        if (input.isEmpty()) {
            return new int[] {start, end};
        }

        if (input.contains("-")) {
            String[] parts = input.split("-");

            if (parts.length == 2) {
                int n = parsePositiveInt(parts[0]);
                int m = parsePositiveInt(parts[1]);

                if (n <= m) {
                    return new int[] {-1, -1};
                }

                start = Math.max(0, totalCommands - n);
                end = Math.max(0, totalCommands - m);
                return new int[] {start, end};
            }
        } else {
            int n = parsePositiveInt(input);
            start = Math.max(0, totalCommands - n);
            return new int[] {start, end};
        }
        return new int[] {start, end};
    }

    private int parsePositiveInt(String input) {
        try {
            return Math.max(0, Integer.parseInt(input.trim()));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void replayCommands(Robot target, List<Command> commands) {
        for (Command cmd : commands) {
            cmd.execute(target);
            System.out.println(target);
        }
    }
}