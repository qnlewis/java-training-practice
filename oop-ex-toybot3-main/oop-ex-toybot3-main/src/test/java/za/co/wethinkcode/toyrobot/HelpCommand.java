package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelpCommandTest {
    @Test
    void testHelpCommandExecution() {
        Robot robot = new Robot("TestBot");
        HelpCommand command = new HelpCommand();
        assertTrue(command.execute(robot));
        assertTrue(robot.getStatus().contains("OFF"));
        assertTrue(robot.getStatus().contains("HELP"));
        assertTrue(robot.getStatus().contains("FORWARD"));
    }
}