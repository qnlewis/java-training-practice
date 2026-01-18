package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShutdownCommandTest {
    @Test
    void testShutdownCommandExecution() {
        Robot robot = new Robot("TestBot");
        ShutdownCommand command = new ShutdownCommand();
        assertFalse(command.execute(robot));
        assertEquals("Shutting down...", robot.getStatus());
    }
}