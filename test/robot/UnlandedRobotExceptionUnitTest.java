package robot;


import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class UnlandedRobotExceptionUnitTest {

    @Test (expected = UnlandedRobotException.class)
    public void testComputeRoadTo() throws UnlandedRobotException, InsufficientChargeException, LandSensorDefaillance, UndefinedRoadbookException, InaccessibleCoordinate {
        Robot robot=new Robot();
        robot.computeRoadTo(new Coordinates(4,4));
    }

}
