package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShutdownTest {
    @Test
    void shutdown() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = new ShutdownCommand();
        assertTrue(robot.handleCommand(command));
    }

}
