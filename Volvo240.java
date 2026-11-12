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


    }

