package controller;

import exceptions.GridOutOfBoundsException;
import lombok.extern.slf4j.Slf4j;
import model.Point;
import services.GridService;
import services.UserInputListener;

import javax.inject.Inject;
@Slf4j
public class AsciiGridController implements UserInputListener {

  @Inject
  GridService gridService;
  private int sizeX = 0, sizeY = 0;

  @Override
  public void createCanvasCommand(int sizeX, int sizeY) {
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    gridService.createGrid(sizeX, sizeY);
    log.info(gridService.gridToString());
  }


  private void checkCanvasSize(Point... points) throws GridOutOfBoundsException {
    for (Point p : points)
      if (p.getX() > sizeX - 1 || p.getY() > sizeY - 1)
        throw new GridOutOfBoundsException();
  }

  @Override
  public void drawRectangleCommand(Point a, Point b) {
    try {
      checkCanvasSize(a, b);
      gridService.drawRec(a, b);
      log.info(gridService.gridToString());
    } catch (GridOutOfBoundsException e) {
      printCoordinatesOutOfBoundsMessage();
    }
  }

  @Override
  public void drawLineCommand(Point a, Point b) {
    try {
      checkCanvasSize(a, b);
      gridService.drawLine(a, b);
      log.info(gridService.gridToString());
    } catch (GridOutOfBoundsException e) {
      printCoordinatesOutOfBoundsMessage();
    }
  }

  private void printCoordinatesOutOfBoundsMessage() {
    log.error("Coordinates out of bounds! Min coords (0,0). Max coords (" + (sizeX - 1) + "," + (sizeY - 1) + ")");
  }

  @Override
  public void quit() {
    log.debug("Quit command received");
    log.info("Bye!");
    System.exit(0);
  }
}
