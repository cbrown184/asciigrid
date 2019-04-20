package services;

import model.Point;

import javax.inject.Inject;
import java.util.Scanner;

public class UserInputService {

    private final String createCanvasCommandRegex = "[cC] [0-9]+ [0-9]+";
    private final String drawLineCommandRegex = "[lL] [0-9]+ [0-9]+ [0-9]+ [0-9]+";
    private final String drawRectangleCommandRegex = "[rR] [0-9]+ [0-9]+ [0-9]+ [0-9]+";
    private final String quitCommandRegex = "[qQ]";

    Scanner scanInput  = new Scanner(System.in);

    UserInputListener listener;

    @Inject
    public UserInputService( UserInputListener listener){
        this.listener = listener;
    }

    public void init(){
        System.out.println("*** Ascii grid ***");
        while (true){
            System.out.println("Please enter your command and press enter.");
            command(scanInput.nextLine());
        }
    }
    public void command(String input){
        String [] args = input.split(" ");

        if(input.matches(createCanvasCommandRegex)){
            int sizeX = Integer.valueOf(args[1]);
            int sizeY = Integer.valueOf(args[2]);
            listener.createCanvasCommand(sizeX, sizeY);
        }
        else if (input.matches(drawLineCommandRegex)){
            int x1 = Integer.valueOf(args[1]);
            int y1 = Integer.valueOf(args[2]);
            int x2 = Integer.valueOf(args[3]);
            int y2 = Integer.valueOf(args[4]);
            listener.drawLineCommand(new Point(x1, y1), new Point(x2, y2));
        }
        else if (input.matches(drawRectangleCommandRegex)){
            int x1 = Integer.valueOf(args[1]);
            int y1 = Integer.valueOf(args[2]);
            int x2 = Integer.valueOf(args[3]);
            int y2 = Integer.valueOf(args[4]);
            listener.drawRectangleCommand(new Point(x1, y1), new Point(x2, y2));
        }
        else if (input.matches(quitCommandRegex)){
            listener.quit();
        }
        else {
            System.out.println("*** Unrecognised command *** - input must match one of the following regex patterns:");
            System.out.println("Create canvas:  " + createCanvasCommandRegex);
            System.out.println("Draw line:      " + drawLineCommandRegex);
            System.out.println("Draw Rectangle: " + drawRectangleCommandRegex);
            System.out.println("Quit:           " + quitCommandRegex);
        }
    }
}

