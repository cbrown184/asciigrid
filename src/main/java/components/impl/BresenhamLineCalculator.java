package components.impl;

import components.LineCalculator;
import lombok.extern.slf4j.Slf4j;
import model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class BresenhamLineCalculator implements LineCalculator {

  //Most of this class is taken from https://rosettacode.org/wiki/Bitmap/Bresenham%27s_line_algorithm#Java
  @Override
  public List<Point> calculateLine(Point a, Point b) {
    log.debug("Calculating line between points: " + a + "," + b);
    int x1 = a.getX();
    int y1 = a.getY();
    int x2 = b.getX();
    int y2 = b.getY();

    List<Point> line = new ArrayList<>();
    // delta of exact value and rounded value of the dependent variable
    int d = 0;

    int dx = Math.abs(x2 - x1);
    int dy = Math.abs(y2 - y1);

    int dx2 = 2 * dx; // slope scaling factors to
    int dy2 = 2 * dy; // avoid floating point

    int ix = x1 < x2 ? 1 : -1; // increment direction
    int iy = y1 < y2 ? 1 : -1;

    int x = x1;
    int y = y1;

    if (dx >= dy) {
      while (true) {
        line.add(new Point(x, y));
        if (x == x2)
          break;
        x += ix;
        d += dy2;
        if (d > dx) {
          y += iy;
          d -= dx2;
        }
      }
    } else {
      while (true) {
        line.add(new Point(x, y));
        if (y == y2)
          break;
        y += iy;
        d += dx2;
        if (d > dy) {
          x += ix;
          d -= dy2;
        }
      }
    }
    log.debug( "Line points generated: " + line.stream().map(Point::toString).collect(Collectors.joining()) );
    return line;
  }
}
