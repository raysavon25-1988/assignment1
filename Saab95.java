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



}
