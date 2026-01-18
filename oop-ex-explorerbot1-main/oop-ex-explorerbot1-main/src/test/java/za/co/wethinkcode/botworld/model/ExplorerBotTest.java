package za.co.wethinkcode.botworld.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static za.co.wethinkcode.botworld.model.Heading.*;

public class ExplorerBotTest
{
    private World world = new World( 3, 3 );

    @Test
    void move_north_toANewPositionInsideTheWorld(){
        ExplorerBot bot = new ExplorerBot(world,North);
        Heading expected = South;
        bot.turnTo(South);
        assertEquals(expected,bot.heading());
    }

    @Test
    void move_south_toANewPositionInsideTheWorld(){
        ExplorerBot bot = new ExplorerBot(world,South);
        Heading expected = West;
        bot.turnTo(West);
        assertEquals(expected,bot.heading());
    }

    @Test
    void move_west_toANewPositionInsideTheWorld(){
        ExplorerBot bot = new ExplorerBot(world,West);
        Heading expected = East;
        bot.turnTo(East);
        assertEquals(expected,bot.heading());
    }

    @Test
    void move_east_toANewPositionInsideTheWorld(){
        ExplorerBot bot = new ExplorerBot(world,East);
        Heading expected = North;
        bot.turnTo(North);
        assertEquals(expected,bot.heading());
    }

    @Test
    void move_north_toANewPositionOutsideTheWorld(){
        ExplorerBot bot = new ExplorerBot(world,North);
        Heading expected = South;
        bot.turnTo(South);
        assertEquals(expected,bot.heading());
    }

    @Test
    void move_south_toANewPositionOutsideTheWorld(){
        ExplorerBot bot = new ExplorerBot(world,South);
        Heading expected = West;
        bot.turnTo(West);
        assertEquals(expected,bot.heading());
    }

    @Test
    void move_west_toANewPositionOutsideTheWorld(){
        ExplorerBot bot = new ExplorerBot(world,West);
        Heading expected = East;
        bot.turnTo(East);
        assertEquals(expected,bot.heading());
    }

    @Test
    void move_east_toANewPositionOutsideTheWorld(){
        ExplorerBot bot = new ExplorerBot(world,East);
        Heading expected = North;
        bot.turnTo(North);
        assertEquals(expected,bot.heading());
    }
}