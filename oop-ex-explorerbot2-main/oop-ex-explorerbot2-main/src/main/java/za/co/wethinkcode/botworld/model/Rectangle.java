package za.co.wethinkcode.botworld.model;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rectangle
{
    private final Coord topLeft;
    private final Coord bottomRight;

    public Rectangle( int leftX, int topY, int rightX, int bottomY ){
        this(
            new Coord( min( leftX, rightX ), min( topY, bottomY )),
            new Coord( max( leftX, rightX ), max( topY, bottomY ))
        );
    }


    public Rectangle( Coord topLeft, Coord bottomRight ){
        this.topLeft = new Coord(
                min(topLeft.x(), bottomRight.x()),
                min(topLeft.y(), bottomRight.y())
        );
        this.bottomRight = new Coord(
                max(topLeft.x(), bottomRight.x()),
                max(topLeft.y(), bottomRight.y())
        );
    }


    public Coord getTopLeft() {
        return topLeft;
    }

    public Coord getBottomRight() {
        return bottomRight;
    }

    /**
     * Answer whether a point is inside the receiver.
     * @param aPoint Any point
     * @return {@literal true} if the point intersects the receiver's area, {@literal false} otherwise.
     */
    public boolean contains( Coord aPoint ){
        return left() <= aPoint.x()
            && top() <= aPoint.y()
            && right() >= aPoint.x()
            && bottom() >= aPoint.y();
    }

    public int right(){
        return bottomRight.x();
    }

    public int left(){
        return topLeft.x();
    }

    public int top(){
        return topLeft.y();
    }

    public int bottom(){
        return bottomRight.y();
    }



}
