package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplayCommandTest {

    @Test
    void testReplayWithNoHistory() {
        Robot robot = new Robot("HAL");
        ReplayCommand replayCommand = new ReplayCommand("");
        replayCommand.execute(robot);

        String expectedStatus = "replayed 0 commands.";
        assertEquals(expectedStatus, robot.getStatus());
    }
}
