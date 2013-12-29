package robot;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LandUnitTest {

    @Test
    public void TestCountLand() throws UnlandedRobotException, UndefinedRoadbookException, LandSensorDefaillance, InaccessibleCoordinate {
        // Land land=new Land(2);
        //System.out.print(land.CountLand());
       /* LandSensor sensor = new LandSensor(new Random());
        Coordinates coord = new Coordinates(5,5);
        Robot robot=new Robot();
        robot.land(coord,sensor) ;
        robot.computeRoadTo(new Coordinates(6,6));
        boolean pasMarché=false;
        try{
            robot.letsGo();
        }
        catch(InsufficientChargeException e){
            // doit forcément passer par le catch
            pasMarché=true;
        }
        Assert.assertTrue(pasMarché);
        Assert.assertEquals(5,robot.getYposition(),0);
        Assert.assertEquals(5,robot.getXposition(),0);
        Assert.assertEquals(Direction.EAST,robot.getDirection()); // le robot ce tourne sans besoin d'energie => pas de précision dans la documentation
    */
    }

    @Test(expected = TerrainNonRepertorieException.class)
    public void TestGetLandByOrdinal() throws TerrainNonRepertorieException {
        Assert.assertEquals(Land.Terre,Land.getLandByOrdinal(0));

        Land land = Land.getLandByOrdinal(6);

    }
}
