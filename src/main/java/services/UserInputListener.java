package services;

import model.Point;

public interface UserInputListener {
  void createCanvasCommand(int sizeX, int sizeY);

  void drawRectangleCommand(Point a, Point b);

  void drawLineCommand(Point a, Point b);

  void quit();
}