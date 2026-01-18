package za.co.wethinkcode.botworld.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class ExplorerBot
{
    private final World world;
    private Heading heading = Heading.North;

    public ExplorerBot(World world, Heading heading){
        this.world = world;
        this.heading = heading;
    }

    public ExplorerBot( World aWorld ){
        world = checkNotNull( aWorld );
    }

    /**
     * Turn the receiver bot to a new heading.
     * @param newHeading What direction the receiver should face
     */
    public void turnTo( Heading newHeading ){
        heading = newHeading;
    }

    /**
     * Answer the receiver bot's current heading.
     * @return a Heading
     */
    public Heading heading(){
        return heading;
    }

    /**
     * Answer the receiver's current position in the world.
     * @return The receiver's current position.
     */
    Coord position(){
        return world.locationOf( this );
    }

    /**
     * Move the receiver bot 1 klik in the direction it currently faces but not
     * beyond the edges of the world. If the move would result in the bot ending
     * up in an illegal position, simply ignore the request and don't move.
     */
    public void move(){
        Coord newPosition = switch( heading() ){
            case North -> position().decrementY();
            case South -> position().incrementY();
            case West -> position().decrementX();
            case East -> position().incrementX();
        };
        if(  world.contains( newPosition ) ) world.moveBot( this, newPosition );
    }

    @Override
    public String toString(){
        return "[" + ExplorerBot.class.getSimpleName()
            + '@'
            + position() + "]";
    }
}
