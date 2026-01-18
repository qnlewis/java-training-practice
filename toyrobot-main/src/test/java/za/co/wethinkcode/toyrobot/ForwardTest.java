package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForwardTest {
    @Test
    void forward() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = new ForwardCommand("10");
        assertTrue(robot.handleCommand(command));
        Position expectedPosition = new Position(Robot.CENTRE.getX(), Robot.CENTRE.getY() + 10);
        assertEquals(expectedPosition, robot.getPosition());
        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }

    @Test
    void forwardforward() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = new ForwardCommand("10");
        assertTrue(robot.handleCommand(command));
        assertTrue(robot.handleCommand(new ForwardCommand("5")));
        assertEquals("Moved forward by 5 steps.", robot.getStatus());
    }
    @Test
    void forwardforward8() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = new ForwardCommand("10");
        assertTrue(robot.handleCommand(command));
        assertTrue(robot.handleCommand(new ForwardCommand("8")));
        assertEquals("Moved forward by 8 steps.", robot.getStatus());
    }
    @Test
    void forwardforward10() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = new ForwardCommand("10");
        assertTrue(robot.handleCommand(command));
        assertTrue(robot.handleCommand(new ForwardCommand("10")));
        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }
    @Test
    void forwardforward4() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = new ForwardCommand("10");
        assertTrue(robot.handleCommand(command));
        assertTrue(robot.handleCommand(new ForwardCommand("4")));
        assertEquals("Moved forward by 4 steps.", robot.getStatus());
    }
    @Test
    void forwardforward7() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = new ForwardCommand("10");
        assertTrue(robot.handleCommand(command));
        assertTrue(robot.handleCommand(new ForwardCommand("7")));
        assertEquals("Moved forward by 7 steps.", robot.getStatus());
    }


    @Test
    void tooFarForward() {
        Robot robot = new Robot("CrashTestDummy");
        assertTrue(robot.handleCommand(new ForwardCommand("1000")));
        assertEquals(Robot.CENTRE, robot.getPosition());
        assertEquals("Sorry, I cannot go outside my safe zone.", robot.getStatus());
    }
}
