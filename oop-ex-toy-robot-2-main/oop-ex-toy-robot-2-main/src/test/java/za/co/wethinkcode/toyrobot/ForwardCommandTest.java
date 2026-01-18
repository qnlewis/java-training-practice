package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ForwardCommandTest {

    @Test
    void testForwardExecutionOutOfBounds() {
        Robot robot = new Robot("TestBot");
        ForwardCommand command = new ForwardCommand("1000");
        assertTrue(command.execute(robot));
        assertEquals(Robot.CENTRE, robot.getPosition());
        assertEquals("Sorry, I cannot go outside my safe zone.", robot.getStatus());
    }

    @Test
    void testForwardCommandCreation() {
        ForwardCommand command = new ForwardCommand("10");
        assertEquals("forward", command.getName());
        assertEquals("10", command.getArgument());
    }

    @Test
    void testForwardExecutionWithinBounds() {
        Robot robot = new Robot("TestBot");
        ForwardCommand command = new ForwardCommand("10");
        assertTrue(command.execute(robot));
        assertEquals(new Position(0, 10), robot.getPosition());
    }

}