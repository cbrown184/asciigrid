package services;

import lombok.extern.slf4j.Slf4j;
import model.Point;

import javax.inject.Inject;
import java.util.Scanner;

@Slf4j
public class UserInputService {

  private final String createCanvasCommandRegex = "[cC] [0-9]+ [0-9]+[ ]*";
  private final String drawLineCommandRegex = "[lL] [0-9]+ [0-9]+ [0-9]+ [0-9]+[ ]*";
  private final String drawRectangleCommandRegex = "[rR] [0-9]+ [0-9]+ [0-9]+ [0-9]+[ ]*";
  private final String quitCommandRegex = "[qQ][ ]*";

  Scanner scanInput = new Scanner(System.in);

  UserInputListener listener;

  @Inject
  public UserInputService(UserInputListener listener) {
    this.listener = listener;
  }

  public void init() {
    System.out.println(
            "  ___           _ _   _____      _     _ \n" +
            " / _ \\         (_|_) |  __ \\    (_)   | |\n" +
            "/ /_\\ \\___  ___ _ _  | |  \\/_ __ _  __| |\n" +
            "|  _  / __|/ __| | | | | __| '__| |/ _` |\n" +
            "| | | \\__ \\ (__| | | | |_\\ \\ |  | | (_| |\n" +
            "\\_| |_/___/\\___|_|_|  \\____/_|  |_|\\__,_|\n" +
            "                                         ");
    while (true) {
      System.out.println("Please enter your command and press enter.");
      command(scanInput.nextLine());
    }
  }

  public void command(String input) {
    String[] args = input.split(" ");

    if (input.matches(createCanvasCommandRegex)) {
      log.debug("Create canvas command received");
      int sizeX = Integer.valueOf(args[1]);
      int sizeY = Integer.valueOf(args[2]);
      listener.createCanvasCommand(sizeX, sizeY);
    } else if (input.matches(drawLineCommandRegex)) {
      log.debug("Line command received");
      int x1 = Integer.valueOf(args[1]);
      int y1 = Integer.valueOf(args[2]);
      int x2 = Integer.valueOf(args[3]);
      int y2 = Integer.valueOf(args[4]);
      listener.drawLineCommand(new Point(x1, y1), new Point(x2, y2));
    } else if (input.matches(drawRectangleCommandRegex)) {
      log.debug("Rectangle command received");
      int x1 = Integer.valueOf(args[1]);
      int y1 = Integer.valueOf(args[2]);
      int x2 = Integer.valueOf(args[3]);
      int y2 = Integer.valueOf(args[4]);
      listener.drawRectangleCommand(new Point(x1, y1), new Point(x2, y2));
    } else if (input.matches(quitCommandRegex)) {
      listener.quit();
    } else {
      log.warn("*** Unrecognised command *** - input must match one of the following regex patterns:"
          + "\nCreate canvas:  " + createCanvasCommandRegex
          + "\nDraw line:      " + drawLineCommandRegex
          + "\nDraw Rectangle: " + drawRectangleCommandRegex
          + "\nQuit:           " + quitCommandRegex
      );
    }
  }
}

