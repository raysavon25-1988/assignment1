import java.awt.*;

public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab95 with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    /* private static void testTrimFactor(){
        Volvo240 slowVolvo = new Volvo240();
        Volvo240 fastVolvo = new Volvo240();
        fastVolvo.trimFactor(2.5);
    }

     */

    static void main() {
        testTurbo();
        //TODO: add and run more tests:

        // NEW OBJECTS

        Vehicle volvo = new Volvo240();
        Vehicle saab = new Saab95();

// TEST 1: Confirm that all values are up.

        reportResult("Volvo has 4 doors", volvo.getNrDoors() == 4);
        reportResult("Volvo has an engine power or", volvo.getEnginePower() == 100);
        reportResult("Volvo has the color", volvo.getColor() == Color.BLACK);
        reportResult("Volvo´s model´s name is", volvo.getModelName().equals("Volvo240"));
        reportResult("Saab has the current speed on", volvo.getCurrentSpeed() == 0);


        // Expected output: True, true, true, FALSE, true
        //__________________________________________________________________________________________

        reportResult("Saab has 4 doors", saab.getNrDoors() == 3); // it should be 2, not 3.
        reportResult("Saab has an engine power or", saab.getEnginePower() == 125);
        reportResult("Saab has the color", saab.getColor() == Color.RED);
        reportResult("Saab´s model´s name is", saab.getModelName().equals("Saab95"));
        reportResult("Saab has the current speed on", saab.getCurrentSpeed() == 0);

        //Expected output: False, Tru, true,true, True
        //-------------------------------------------------------------------------


        //TEST 2 - Volvo acceleration: To verify that Volvo uses the correct speedFactor().

        volvo.gas(0.5);

        reportResult("Volvo acceleration", volvo.getCurrentSpeed() == 0.625);

        //Expected output: False, true
        //-------------------------------------------------------------------------

        // TEST 3 — Saab95 turbo behavior

        volvo.gas(0.5);

        // CALL saab2.setTurboOn()
        //
        //CALL saab1.gas(0.5)
        //CALL saab2.gas(0.5)
        //
        //CHECK saab1.currentSpeed ≈ 0.625
        //CHECK saab2.currentSpeed ≈ 0.8125
        //CHECK saab2.currentSpeed > saab1.currentSpeed

        reportResult("Volvo acceleration", volvo.getCurrentSpeed() == 0.625);



    }
}
