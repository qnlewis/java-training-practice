package za.co.wethinkcode.botworld.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest
{
    @Test
    void topLeftIsAlwaysLessThanBottomRight(){
        Rectangle rect1 =  new Rectangle(10,10,0,0);
        assertEquals(new Coord(0,0),rect1.getTopLeft());
        assertEquals(new Coord(10,10),rect1.getBottomRight());  // corrected y=10

        Rectangle rect2 =  new Rectangle(5,20,15,10);
        assertEquals(new Coord(5,10),rect2.getTopLeft());
        assertEquals(new Coord(15,20),rect2.getBottomRight());  // corrected y=20

        Rectangle rect3 =  new Rectangle(15,5,5,15);
        assertEquals(new Coord(5,5),rect3.getTopLeft());
        assertEquals(new Coord(15,15),rect3.getBottomRight());  // corrected y=15
    }



    @Test
    void createRectArea_singlePointAreaIsOK(){
        Coord p1 = new Coord( 10, 10 );
        Coord p2 = new Coord( 10, 10 );
        new Rectangle( p1, p2 );
    }

    @Test
    void whatIsInsideTheRectangle(){
        Rectangle r = new Rectangle( 0, 0, 10, 10 );
        assertTrue( r.contains( new Coord( 5, 5 )));
        assertTrue( r.contains( new Coord( 0, 0 )));
        assertTrue( r.contains( new Coord( 10, 10 )));
        assertFalse( r.contains( new Coord( -1, 5 )));
        assertFalse( r.contains( new Coord( 5, -1 )));
        assertFalse( r.contains( new Coord( 11, 5 )));
        assertFalse( r.contains( new Coord( 5, 11 )));
    }
}
