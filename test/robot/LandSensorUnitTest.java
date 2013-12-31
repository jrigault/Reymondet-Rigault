package robot;

import org.junit.Assert;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LandSensorUnitTest {

    // ce test vérifie aussi la méthode rajoutée addCoordinates
    @Test(expected = InaccessibleCoordinate.class)
    public void testGetPointToPointEnergyCoefficient() throws InaccessibleCoordinate, LandSensorDefaillance {
        LandSensor sensor=new LandSensor(new Random());
        Random random = new Random();
        Coordinates coord1=new Coordinates(5,6);
        Coordinates coord2=new Coordinates(6,6);

        sensor.addCoordinates(coord1,Land.Terre);
        sensor.addCoordinates(coord2,Land.Terre);
        Assert.assertEquals(1.00, sensor.getPointToPointEnergyCoefficient(coord1, coord2), 0);
        Assert.assertEquals(0, sensor.getPointToPointEnergyCoefficient(coord1, coord1), 0);
        Coordinates coord3=new Coordinates(5,5);

        sensor.addCoordinates(coord3,Land.Infranchissable);
        double test=sensor.getPointToPointEnergyCoefficient(coord1,coord3);

    // on ne peut pas déclencher une LandSensorDefaillance car à priori la méthode getLandByOrdinal est correctement utilisé
    }
}
