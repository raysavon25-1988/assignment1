
import java.awt.*;

// CLASS DEFINITION:
public abstract class Vehicle implements Movable{
//--------------------------------------------------------------------

    // FIELDS:
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;
    private double x;
    private double y;
    private Direction direction;

    //--------------------------------------------------------------------

    //CONSTRUCTORS BY PARAMETERS:
    // this. = parameter: connect the field
    public Vehicle(int nrDoors, double enginePower,
                   Color color, String modelName) {

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentSpeed = 0;
        this.x = 0;
        this.y = 0;
        this.direction = Direction.NORTH;
    }
    //--------------------------------------------------------------------

    //GETTER METHODS:
    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public String getModelName() {
        return modelName;
    }

    public Color getColor() {
        return color;

    }
    //--------------------------------------------------------------------

    //SHARED METHODS: Allows controlled modification of an object's state.
    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }
    @Override
    public void move() {

        if (direction == Direction.NORTH) {
            y = y + currentSpeed;
        }
        else if (direction == Direction.EAST) {
            x = x + currentSpeed;
        }
        else if (direction == Direction.SOUTH) {
            y = y - currentSpeed;
        }
        else if (direction == Direction.WEST) {
            x = x - currentSpeed;
        }
    }
    @Override
    public void turnLeft() {

        if (direction == Direction.NORTH) {
            direction = Direction.WEST;
        }
        else if (direction == Direction.WEST) {
            direction = Direction.SOUTH;
        }
        else if (direction == Direction.SOUTH) {
            direction = Direction.EAST;
        }
        else if (direction == Direction.EAST) {
            direction = Direction.NORTH;
        }
    }
    @Override
    public void turnRight() {

        if (direction == Direction.NORTH) {
            direction = Direction.EAST;
        }
        else if (direction == Direction.EAST) {
            direction = Direction.SOUTH;
        }
        else if (direction == Direction.SOUTH) {
            direction = Direction.WEST;
        }
        else if (direction == Direction.WEST) {
            direction = Direction.NORTH;
        }
    }
//--------------------------------------------------------------------

    // ABSTRACT METHOD: Declare the method without implementing it.

    public abstract double speedFactor();

//-------------------------------------------------------------------------------------
    // TASK 4 STARTS:
    // CHANGED: the speed can never go above enginePower.
    // Math.min picks the SMALLER of the two numbers, so enginePower acts as a ceiling.
    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,
                getEnginePower());
    }

    // CHANGED: the speed can never go below 0.
    // Math.max picks the BIGGER of the two numbers, so 0 acts as a floor.
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    // CHANGED: check the input first, then do the work.
    public void gas(double amount) {
        checkAmount(amount);
        incrementSpeed(amount);
    }

    // CHANGED: same idea for brake.
    public void brake(double amount) {
        checkAmount(amount);
        decrementSpeed(amount);
    }

    // NEW: private helper. Only Vehicle uses it, so outsiders never see it.
    // Allowed means 0 <= amount <= 1. Anything else is rejected with an exception.
    // Writing !(allowed) also catches NaN ("not a number"), which a plain
    // "amount < 0 || amount > 1" check would let through.
    private void checkAmount(double amount) {
        if (!(amount >= 0 && amount <= 1)) {
            throw new IllegalArgumentException(
                    "amount must be in [0,1] but was " + amount);
        }
    }
    // TASK 4 ENDS.
}