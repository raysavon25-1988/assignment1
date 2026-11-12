import java.awt.*;

public class Volvo240 extends Vehicle {

    // Volvo-SPEC FIELD:
    public static final double trimFactor = 1.25;

    // CONSTRUCTOR:
    public Volvo240() {
        super(4, 100, Color.BLACK, "Volvo240");
    }


    // METHOD by Override - an inherited method
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }




    
    /* public int getNrDoors() {
        return nrDoors;
    }
    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }
    
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

     */
}
