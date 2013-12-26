package robot;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LandSensorUnitTest {

    @Test
    public void testGetPointToPointEnergyCoefficient(){
        LandSensor sensor=new LandSensor(new Random());
        Coordinates coord1=new Coordinates(5,6);
        Coordinates coord2=new Coordinates(6,6);
        System.out.println(sensor.getPointToPointEnergyCoefficient(coord1,coord2));
    }

}
