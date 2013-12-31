package robot;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LandUnitTest {

    @Test
    public void TestCountLand() throws UnlandedRobotException, UndefinedRoadbookException, LandSensorDefaillance, InaccessibleCoordinate {
        Assert.assertEquals(5,Land.CountLand(),0);
    }

    @Test(expected = TerrainNonRepertorieException.class)
    public void TestGetLandByOrdinal() throws TerrainNonRepertorieException {
        Assert.assertEquals(Land.Terre,Land.getLandByOrdinal(0)); // ordinal != coefficient
        Land land = Land.getLandByOrdinal(6);
    }
}
