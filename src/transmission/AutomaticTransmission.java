package transmission;

import java.util.Arrays;

/**
 * This class represents an AutomaticTransmission with a gear that accepts 5 thresholds
 */
public class AutomaticTransmission implements Transmission {

    private int speed;
    private final int[] gears;

    /**
     * Constructor for the AT class.It has 5 integers representing the threshold between gears.
     * @param g1 first Threshold
     * @param g2 second Threshold
     * @param g3 third Threshold
     * @param g4 fourth Threshold
     * @param g5 Fifth Threshold
     * @throws IllegalArgumentException If the first threshold is lower than 1, or if there is a method less or
     * equal than the previous gear.
     */
    public AutomaticTransmission(int g1, int g2, int g3, int g4, int g5) throws IllegalArgumentException {
        this.speed = 0;
        gears = new int[]{g1, g2, g3, g4, g5};

        //g1 has to be greater than 1
        if ( g1 <= 1) {throw new IllegalArgumentException();}

        //Check if the next Gear is lower than the previous
        for (int i  = 1 ; i < gears.length; i++){
            if (gears[i] <= gears[i-1]) {throw new IllegalArgumentException();}
        }
    }

    @Override
    public void increaseSpeed() {
        this.speed++;
    }

    @Override
    public void decreaseSpeed() throws IllegalStateException {

        if (this.getSpeed() == 0) {
            throw new IllegalStateException("Negative speed is not allowed");
        }

        this.speed--;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getGear() {

        //If not in movement
        if(this.getSpeed() == 0) return 0;

        int counterGear = 1;

        for (int i = 0; i < this.gears.length ; i++) {

            if(this.gears[i]<=this.getSpeed()) {
                counterGear++;
            }
        }
        return counterGear;
    }

    /**
     * Override the toString method with a new Structure
     * @return the following format of string Transmission (speed = _, gear = _)
     */
    @Override
    public String toString() {
        return "Transmission (" +
                "speed = " + this.getSpeed() +
                ", gear = " + this.getGear() +
                ')';
    }
}
