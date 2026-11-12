import java.awt.*;

//CLASS:
public class Saab95 extends Vehicle {

    //SPEC FIELD
    private boolean turboOn;

    //CONSTRUCTOR:
    // super() - Call the Vehicle constructor
    // this.turboOn -  Initialize turboOn to false
    public Saab95() {

            super(2, 125, Color.RED, "Saab95");
            this.turboOn = false;
        }

        // METHOD by Override - an inherited method
    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }


    /*
        stopEngine();
    }
    
    public int getNrDoors() {
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
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    // TODO fix this method according to assignment pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to assignment pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

     */
}
