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


        // Expected output: True, true, true, True, true
        //__________________________________________________________________________________________

        reportResult("Saab has 4 doors", saab.getNrDoors() == 4); // it should be 2... not 4.
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

        Saab95 saab1 = new Saab95();
        Saab95 saab2 = new Saab95();

        saab2.setTurboOn();

        saab1.gas(0.5);
        saab2.gas(0.5);

        reportResult("Saab without turbo",
                saab1.getCurrentSpeed() == 0.625);

        reportResult("Saab with turbo",
                saab2.getCurrentSpeed() == 0.8125);

        reportResult("Volvo acceleration", volvo.getCurrentSpeed() == 0.625);


        /* Test 4 — Starting and stopping the engine
        Purpose: Verify the inherited engine methods.*/


        volvo.startEngine();
        reportResult("Engine starts", volvo.getCurrentSpeed() == 0.1);

        volvo.stopEngine();
        reportResult("Engine stops", volvo.getCurrentSpeed() == 0);

        volvo.startEngine();
        reportResult("Engine starts again", volvo.getCurrentSpeed() == 0.1);


        /*
        Test 5 — Braking
        Purpose: Verify that braking uses the correct vehicle-specific speed factor.*/
         Volvo240 brakingVolvo = new Volvo240();

        brakingVolvo.gas(0.8);
        reportResult("Volvo speed after gas(0.8) is 1.0",
                brakingVolvo.getCurrentSpeed() == 1.0);

        brakingVolvo.brake(0.4);
        reportResult("Volvo speed after brake(0.4) is 0.5",
                brakingVolvo.getCurrentSpeed() == 0.5);



        /*
        Test 6 — Object independence
        Expected: Changing one object's speed does not change the other object's speed.*/
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();

        volvo1.gas(0.5);

        reportResult("Volvo1 speed is 0.625",
                volvo1.getCurrentSpeed() == 0.625);

        reportResult("Volvo2 speed remains 0",
                volvo2.getCurrentSpeed() == 0);

        /*
        Test 7 — Polymorphism
        Purpose: Verify that both models can be used through the same superclass.*/

        Vehicle car1 = new Volvo240();
        Vehicle car2 = new Saab95();

        ((Saab95) car2).setTurboOn();

        car1.gas(0.5);
        car2.gas(0.5);

        reportResult("Volvo speed", car1.getCurrentSpeed() == 0.625);

        reportResult("Saab speed", car2.getCurrentSpeed() == 0.8125);




    }
}
