/*
Inheritance Hierarchy: Implementation inheritance

It seems to be both Saab and Volvo240 be child
since they have differences in the fields and constructors.
The rest remains quite similar.
This is the reason why I choose to create a superclass completing the design as follow:
Superclass =Vehicle --> subclasses = Volvo240 and Saab95

------------------------------------------------------------
Q1. Should you use implementation inheritance (subclassing) or specification inheritance (interfaces)?
Why?

Since both subclasses have similar structure and attributes.
The only difference is the initial values.
the most accurate design for that case is the implementation inheritance.
This will eliminate duplicated implementation reducing the maintainance effort
and permitting subclasses specialize behaviour.
The only disadvantage using supercalss is the fact that both programs
becomes dependent on superclass design which is the advantage of using interfaces
However, I perceive no danger since both subclasses are cars and they share almost the same sturcture.
are cars. That is why using specification inheritance (interface) is not necessary for TASK 1.

------------------------------------------------------------
Q2. Can both be used? What advantages and disadvantages do you see?

I still think supercall implementation  is more suitable for TASK 1 since the goal is to
reduce duplicates. Interfaces only reduce dependency of particular implementations
and since both car classes implement identical logic mehtods, there is no use for interface.

------------------------------------------------------------
Q3. How does your solution follow the Open-Closed Principle better than the original code?
Think of an extension that is now possible without modifying existing code.

Our superclass design follows the Open-Closed Principle (OCP) because it allows to us
to introduce new class car models by extending all the structure from the superclass.
This allows us to spare resources and include new features or behaviour without modifying
the other existing models.


------------------------------------------------------------
Q4. Can you think of any extensions that would require changing existing code?


 */

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

//---------------------------------------------------
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

    //  private helper. Only Vehicle uses it, so outsiders never see it.
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