package robot;

import org.junit.Assert;
import org.junit.Test;

public class LandUnitTest {

    @Test
    public void TestCountLand(){
       // Land land=new Land(2);
        //System.out.print(land.CountLand());
    }

    @Test(expected = TerrainNonRepertorieException.class)
    public void TestGetLandByOrdinal() throws TerrainNonRepertorieException {
        Assert.assertEquals(Land.Terre,Land.getLandByOrdinal(0));

        Land land = Land.getLandByOrdinal(6);

    }
}
