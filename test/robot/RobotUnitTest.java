package robot;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class RobotUnitTest {

    // test les class suivantes : getYPosition, getXPosition, letsGo, moveBackward, setRoadBook, getDirection, moveTo, land
    @Test
    public void testLetsGo() throws UnlandedRobotException, InsufficientChargeException, LandSensorDefaillance, UndefinedRoadbookException, InaccessibleCoordinate {

        LandSensor sensor = new LandSensor(new Random());
        Coordinates coord = new Coordinates(5,5);
        Robot robot=new Robot();
        robot.land(coord,sensor);
        List instructions = new ArrayList<Instruction>();
        instructions.add(Instruction.BACKWARD);
        RoadBook book= new RoadBook(instructions);
        robot.setRoadBook(book);
        Assert.assertEquals(5, robot.getYposition(), 0);
        try{
            robot.letsGo();
            Assert.assertEquals(Direction.NORTH,robot.getDirection());
            Assert.assertEquals(5,robot.getXposition(),0);
            Assert.assertEquals(6,robot.getYposition(),0); // erreur de l'Assert : retourne 4 au lieu de 6 => mauvaise direction
            // erreur car la position initiale est : 5,5 direction north, et donc avec une instruction BACKWARD le robot devrait être en position 5,6
            // erreur réctifié dans la class MapTools.java : méthode : nextForwardPosition et nextBackwardPosition
        }
        catch(InaccessibleCoordinate e){
            System.out.println("passage par des coordonnées invalides");
        }

    }


    // test computeRoadTo, turnLeft, moveForward
    @Test
    public void testComputeRoadTo() throws UnlandedRobotException, InsufficientChargeException, LandSensorDefaillance, UndefinedRoadbookException, InaccessibleCoordinate {

        LandSensor sensor = new LandSensor(new Random());
        Coordinates coord = new Coordinates(5,5);
        Robot robot=new Robot();
        robot.land(coord,sensor) ;
        Assert.assertEquals(Direction.NORTH,robot.getDirection());
        robot.computeRoadTo(new Coordinates(4,4));// erreur lors de l'appel a calculateRoadBook => StackOverflowError et donc il y a une boucle infinie
        // problème du au fait que la position SOUTH est appelée si on veut aller au NORTH et inversement => problème réctifié dans RoadBookCalculator
        // d'après la documentation le robot doit :
        // - Aller en avant => FORWARD
        // - Tourner sens inverse des aiguille d'une montre => TURNLEFT
        // - Aller en avant => FORWARD

        // on observe en placant un S.O.P. que le robot ce tourne vers EAST au lieu de WEST => problème d'optimisation qui ne correspond pas avec la documentation
        // problème d'optimisation rectifié dans RoadBookCalculator afin de correspondre à la documentation
        try{
            robot.letsGo();
            Assert.assertEquals(4,robot.getYposition(),0);
            Assert.assertEquals(4,robot.getXposition(),0);
            Assert.assertEquals(Direction.WEST,robot.getDirection());
        }
        catch(InaccessibleCoordinate e){
            System.out.println("passage par des coordonnées invalides");
        }

    }

    // test l'énergie dans moveTo, turnRight
    @Test
    public void testEnergySufficiant() throws UnlandedRobotException, InsufficientChargeException, LandSensorDefaillance, UndefinedRoadbookException, InaccessibleCoordinate {
        LandSensor sensor = new LandSensor(new Random());
        Coordinates coord = new Coordinates(5,5);
        Robot robot=new Robot(101,new Battery());
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
    }

}
