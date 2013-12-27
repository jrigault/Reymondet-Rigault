package robot;

import org.junit.Test;

import java.util.Random;

public class UndefinedRoadbookExceptionUnitTest {

    @Test (expected = UndefinedRoadbookException.class)
    public void testLetsGo() throws UndefinedRoadbookException, LandSensorDefaillance, UnlandedRobotException, InsufficientChargeException, InaccessibleCoordinate {

        LandSensor sensor = new LandSensor(new Random());
        Coordinates coord = new Coordinates(5,5);
        Robot robot=new Robot();
        robot.land(coord,sensor);
        robot.letsGo();
    }
}
