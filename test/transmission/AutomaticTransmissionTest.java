package transmission;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutomaticTransmissionTest {

    private Transmission bmw;
    private Transmission honda;
    private Transmission parkingCar;


    @Before
    public void setUp() throws Exception {

        bmw = new AutomaticTransmission(4, 22, 129, 247, 368);
        honda = new AutomaticTransmission(2,5,10,20,80);
        parkingCar = new AutomaticTransmission(2,3,4,6,7);


        int speed = 130;

        while (speed > 0) {
            bmw.increaseSpeed();
            if(speed % 2 == 0) honda.increaseSpeed(); //65
            speed--;
        }

    }

    /**
     * Greater Gear with lower value
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLowerValue() {
        Transmission hotWheels = new AutomaticTransmission(10, 20, 30, 40, 30);
    }

    /**
     * wrong initial array provided
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalFirstElement() {
        Transmission hotWheels = new AutomaticTransmission(1, 20, 30, 40, 30);
    }

    /**
     * Test the toString method with this format Transmission (speed = x, gear = y)
     */
    @Test
    public void testToString() {

        assertEquals("Transmission (speed = 130, gear = 4)", bmw.toString());
        assertEquals("Transmission (speed = 65, gear = 5)", honda.toString());
        assertEquals("Transmission (speed = 0, gear = 0)", parkingCar.toString());
    }

    /**
     * Test that the increase method include the speed by 1
     */
    @Test
    public void testIncreaseSpeed() {
        bmw.increaseSpeed();
        honda.increaseSpeed();
        parkingCar.increaseSpeed();

        assertEquals(66, honda.getSpeed());
        assertEquals(131, bmw.getSpeed());
        assertEquals(1, parkingCar.getSpeed());
    }

    /**
     * Test that the decrease method reduce the speed by 1
     */
    @Test
    public void testDecreaseSpeed() {

        bmw.decreaseSpeed();
        honda.decreaseSpeed();

        assertEquals(64, honda.getSpeed());
        assertEquals(129, bmw.getSpeed());

    }

    /**
     * Test if the speed goes lower than 0
     */
    @Test (expected = IllegalStateException.class)
    public void testDecreaseLowerThanZero() {
        parkingCar.decreaseSpeed();
    }

    /**
     * Get the current speed value
     */
    @Test
    public void testGetSpeed() {

        assertEquals(130, bmw.getSpeed());
        assertEquals(65, honda.getSpeed());
        assertEquals(0, parkingCar.getGear());
    }

    /**
     * Get the current gear of the transmission.
     */
    @Test
    public void getGear() {

        assertEquals(4, bmw.getGear());
        assertEquals(5, honda.getGear());
        assertEquals(0, parkingCar.getGear());
    }
}