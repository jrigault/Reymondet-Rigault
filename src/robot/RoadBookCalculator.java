package robot;

import java.util.ArrayList;
import java.util.List;

import static robot.Direction.*;
import static robot.Instruction.*;

public class RoadBookCalculator {

    // le calcul du trajet n'est pas optimisé selon la documentation :
    // - le meilleur chemin n'est pas cherché => seul le plus court est cherché
    // - le chemin n'évite pas les zones infranchissables
    static RoadBook calculateRoadBook(Direction direction, Coordinates position, Coordinates destination, ArrayList<Instruction> instructions) {
        List<Direction> directionList = new ArrayList<Direction>();

        if (destination.getX() < position.getX()) directionList.add(WEST);
        if (destination.getX() > position.getX()) directionList.add(Direction.EAST);
        if (destination.getY() > position.getY()) directionList.add(Direction.SOUTH);
        if (destination.getY() < position.getY()) directionList.add(Direction.NORTH);
        if (directionList.isEmpty()) return new RoadBook(instructions);
        if (directionList.contains(direction)) {
            instructions.add(FORWARD);
            return calculateRoadBook(direction, MapTools.nextForwardPosition(position, direction), destination, instructions);
        }
        else if(directionList.contains(MapTools.clockwise(direction))){
            instructions.add(TURNRIGHT);
            return calculateRoadBook(MapTools.clockwise(direction), position, destination, instructions);
        }
        else if(directionList.contains(MapTools.counterclockwise(direction))){
            instructions.add(TURNLEFT);
            return calculateRoadBook(MapTools.counterclockwise(direction), position, destination, instructions);
        }
        else{ // marche arrière non préférable => on fait retourner le robot à la place
            instructions.add(TURNRIGHT);
            instructions.add(TURNRIGHT);
            instructions.add(FORWARD);
            return calculateRoadBook(MapTools.clockwise(MapTools.clockwise(direction)), MapTools.nextBackwardPosition(position, direction), destination, instructions);
        }
    }
}