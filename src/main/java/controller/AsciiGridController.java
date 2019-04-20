package controller;

import exceptions.GridOutOfBoundsException;
import model.Point;
import services.GridService;
import services.UserInputListener;

import javax.inject.Inject;

public class AsciiGridController implements UserInputListener {

    @Inject
    GridService gridService;

    int sizeX = 0, sizeY = 0;

    @Override
    public void createCanvasCommand(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        gridService.createGrid(sizeX, sizeY);
        System.out.println(gridService.gridToString());
    }

    private void checkCanvasSize(Point... points) throws GridOutOfBoundsException {
        for(Point p : points)
            if( p.getX() > sizeX-1  || p.getY() > sizeY-1)
                throw new GridOutOfBoundsException();
    }
    @Override
    public void drawRectangleCommand(Point a, Point b) {
        try {
            checkCanvasSize(a,b);
            gridService.drawRec(a,b);
            System.out.println(gridService.gridToString());
        } catch (GridOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Coordinates out of bounds! Min coords (0,0). Max coords (" + (sizeX-1) + "," + (sizeY-1) +")" );
        }
    }

    @Override
    public void drawLineCommand(Point a, Point b) {
        try {
            checkCanvasSize(a,b);
            gridService.drawLine(a,b);
            System.out.println(gridService.gridToString());
        } catch (GridOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Coordinates out of bounds! Min coords (0,0). Max coords (" + (sizeX-1) + "," + (sizeY-1) +")" );
        }
    }

    @Override
    public void quit() {
        System.out.println("Bye!");
        System.exit(0);
    }
}
