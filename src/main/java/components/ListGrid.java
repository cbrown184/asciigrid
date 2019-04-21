package components;


import java.util.List;

public interface ListGrid<T> {
  void setNewGrid(int sizeX, int sizeY, T defaultValue);

  T getGridSquare(int x, int y);

  void setGridSquare(int x, int y, T t);

  int noGridSquares();

  List<List<T>> getGrid();
}
