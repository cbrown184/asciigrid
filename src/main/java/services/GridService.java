package services;

import components.LineCalculator;
import components.ListGrid;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import model.Point;

import javax.inject.Inject;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Slf4j
public class GridService {

  @Getter
  @Inject
  ListGrid<Boolean> booleanGrid;

  @Inject
  LineCalculator lineCalculator;

  public void createGrid(int sizeX, int sizeY) {
    booleanGrid.setNewGrid(sizeX, sizeY, false);
  }

  public void drawLine(Point a, Point b) {
    lineCalculator.calculateLine(a, b).forEach(point -> booleanGrid.setGridSquare(point.getX(), point.getY(), true));
  }

  public void drawRec(Point corner1, Point corner3) {
    Point corner2 = new Point(corner1.getX(), corner3.getY());
    Point corner4 = new Point(corner3.getX(), corner1.getY());

    Stream.of(
        lineCalculator.calculateLine(corner1, corner2),
        lineCalculator.calculateLine(corner2, corner3),
        lineCalculator.calculateLine(corner3, corner4),
        lineCalculator.calculateLine(corner4, corner1)
    )
        .flatMap(Collection::stream)
        .collect(Collectors.toList())
        .forEach(point -> booleanGrid.setGridSquare(point.getX(), point.getY(), true));
  }

  public void drawSqaure(Point bottomLeftCorner, int length) {
    Point topLeftCorner = new Point(bottomLeftCorner.getX(), bottomLeftCorner.getY() + length - 1);
    Point topRightCorner = new Point(topLeftCorner.getX() + length - 1, topLeftCorner.getY());
    Point bottomRightCorner = new Point(bottomLeftCorner.getX() + length - 1, bottomLeftCorner.getY());

    Stream.of(
        lineCalculator.calculateLine(bottomLeftCorner, topLeftCorner),
        lineCalculator.calculateLine(topLeftCorner, topRightCorner),
        lineCalculator.calculateLine(topRightCorner, bottomRightCorner),
        lineCalculator.calculateLine(bottomRightCorner, bottomLeftCorner))
        .flatMap(Collection::stream)
        .collect(Collectors.toList())
        .forEach(point -> booleanGrid.setGridSquare(point.getX(), point.getY(), true));

  }

  public String gridToString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    for (int j = 0; j < booleanGrid.getGrid().size() + 2; j++) {
      sb.append("-");
    }

    sb.append("\n");

    for (int i = booleanGrid.getGrid().get(0).size() - 1; i >= 0; i--) {
      sb.append("|");
      for (int j = 0; j < booleanGrid.getGrid().size(); j++) {
        sb.append(booleanGrid.getGrid().get(j).get(i) ? "x" : " ");
      }
      sb.append("|");
      sb.append("\n");
    }

    for (int j = 0; j < booleanGrid.getGrid().size() + 2; j++) {
      sb.append("-");
    }

    return sb.toString();
  }
}
