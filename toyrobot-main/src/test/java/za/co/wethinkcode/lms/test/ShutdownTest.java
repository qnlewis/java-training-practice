package za.co.wethinkcode.lms.test;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.toyrobot.Command;
import za.co.wethinkcode.toyrobot.Robot;
import za.co.wethinkcode.toyrobot.ShutdownCommand;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShutdownTest{
    @Test
    void shutdown() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = new ShutdownCommand();
        assertTrue(robot.handleCommand(command));
    }

}
