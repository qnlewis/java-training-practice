package za.co.wethinkcode.botworld.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class ExplorerBot
{
    private World world;
    private Heading heading = Heading.North;
    public static float MAX_FUEL = 100f;
    public static float MIN_FUEL = 0f;
    private float fuelLevel;
    private float fuelPerKlik = 1.0f;



    public ExplorerBot(World world, Coord coord, float fuelLevel) {
        if (fuelLevel < MIN_FUEL || fuelLevel > MAX_FUEL) {
            throw new IllegalArgumentException("Fuel must be between 0 and 100");
        }
        this.fuelLevel = fuelLevel;
        this.world = world;
        world.add(this, coord);
    }


    public ExplorerBot(World world, Heading heading){
        this.world = world;
        this.heading = heading;
    }

    public ExplorerBot( World aWorld ){
        world = checkNotNull( aWorld );
    }
    public ExplorerBot(World world, int x, int y, float fuelLevel) {
        this(world, new Coord(x, y), fuelLevel);
    }


    /**
     * Turn the receiver bot to a new heading.
     * @param newHeading What direction the receiver should face
     */
    public void turnTo( Heading newHeading ){heading = newHeading;}

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
        if (fuelLevel < fuelPerKlik || fuelPerKlik <= 0) {
            return;
        }

        Coord newPosition = switch( heading() ){
            case North -> position().decrementY();
            case South -> position().incrementY();
            case West  -> position().decrementX();
            case East  -> position().incrementX();
        };

        if (world.contains(newPosition)) {
            world.moveBot(this, newPosition);
            fuelLevel -= fuelPerKlik;
            if (fuelLevel < 0) fuelLevel = 0;
        }
    }

    public void addFuel(float amount){
        if (amount > 0) {
            this.fuelLevel += amount;
            if (fuelLevel > MAX_FUEL) fuelLevel = MAX_FUEL;
        }
    }

    public float fuelLevel(){
        return fuelLevel;
    }
    public void setFuelConsumptionPerKlik(float fuelPerKlik){
        if (fuelPerKlik >= 0) {
            this.fuelPerKlik = fuelPerKlik;
        } else {
            throw new IllegalArgumentException("Fuel consumption must be positive.");
        }
    }


    @Override
    public String toString(){
        return "[" + ExplorerBot.class.getSimpleName()
                + '@'
                + position() + "]";
    }
}