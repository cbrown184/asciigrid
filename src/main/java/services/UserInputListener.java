package services;

import model.Point;

public interface UserInputListener {
    public void createCanvasCommand(int sizeX, int sizeY);
    public void drawRectangleCommand(Point a, Point b);
    public void drawLineCommand(Point a, Point b);
    public void quit();
}