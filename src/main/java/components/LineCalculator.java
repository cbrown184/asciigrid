package components;

import model.Point;

import java.util.List;

public interface LineCalculator {
  List<Point> calculateLine(Point a, Point b);
}
