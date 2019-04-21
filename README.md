# Ascii Grid
 
Draw straight & diagonal lines using ascii. Diagonal lines are raster based using [Bresenham's line algorithm.](https://rosettacode.org/wiki/Bitmap/Bresenham%27s_line_algorithm#Java) 

## Commands
**C w h** Create a new canvas of width w and height h

**L x1 y1 x2 y2** Draw a new line from coordinates (x1, y1) to (x2, y2) horizontally or vertically. Lines are made up of the x character

**R x1 y1 x2 y2** Draw a new rectangle, with upper left corner at coordinate (x1, y1) and lower right coordinate at (x2, y2). Lines are made up of the x character

**Q** Quit the program


## Getting Started

download jar

Build jar
```
Chris@Chris-PC MINGW64 ~/Desktop/asciigrid (master)
$ gradle build
BUILD SUCCESSFUL in 14s
5 actionable tasks: 5 executed
```

Run jar
```
$ java -jar asciigrid-1.0-SNAPSHOT.jar
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$2 (file:/C:/Users/Chris/IdeaProjects/asciigrid/build/libs/asciigrid-1.0-SNAPSHOT.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$2
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
  ___           _ _   _____      _     _
 / _ \         (_|_) |  __ \    (_)   | |
/ /_\ \___  ___ _ _  | |  \/_ __ _  __| |
|  _  / __|/ __| | | | | __| '__| |/ _` |
| | | \__ \ (__| | | | |_\ \ |  | | (_| |
\_| |_/___/\___|_|_|  \____/_|  |_|\__,_|

Please enter your command and press enter.
```

Create new canvas will create an empty grid of size x times y. The grid by default is 0 by 0 until the user enters the create canvas command for the first time. The create canvas command will overwrite the existing grid.
```
Please enter your command and press enter.
c 40 10
14:05:14.162 [main] DEBUG services.UserInputService - Create canvas command received
14:05:14.166 [main] INFO components.impl.ListGridImpl - Setting grid size to 40 * 10. Default value - false
14:05:14.167 [main] INFO controller.AsciiGridController -
------------------------------------------
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
------------------------------------------
```

The line command can be used to draw a single point if points X and Y are equal or a line between the two points if they are not equal.
``` 
Please enter your command and press enter.
l 19 4 19 4
14:05:44.889 [main] DEBUG services.UserInputService - Line command received
14:05:44.890 [main] DEBUG components.impl.BresenhamLineCalculator - Calculating line between points: Point(x=19, y=4),Point(x=19, y=4)
14:05:44.902 [main] DEBUG components.impl.BresenhamLineCalculator - Line points generated: Point(x=19, y=4)
14:05:44.904 [main] INFO controller.AsciiGridController -
------------------------------------------
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
|                   x                    |
|                                        |
|                                        |
|                                        |
|                                        |
------------------------------------------
Please enter your command and press enter.
l 18 6 21 6
14:06:18.809 [main] DEBUG services.UserInputService - Line command received
14:06:18.810 [main] DEBUG components.impl.BresenhamLineCalculator - Calculating line between points: Point(x=18, y=6),Point(x=21, y=6)
14:06:18.810 [main] DEBUG components.impl.BresenhamLineCalculator - Line points generated: Point(x=18, y=6)Point(x=19, y=6)Point(x=20, y=6)Point(x=21, y=6)
14:06:18.811 [main] INFO controller.AsciiGridController -
------------------------------------------
|                                        |
|                                        |
|                                        |
|                  xxxx                  |
|                                        |
|                   x                    |
|                                        |
|                                        |
|                                        |
|                                        |
------------------------------------------
```

Draw rectangle 
```
Please enter your command and press enter.
r 30 0 39 9
14:06:59.797 [main] DEBUG services.UserInputService - Rectangle command received
14:06:59.797 [main] DEBUG components.impl.BresenhamLineCalculator - Calculating line between points: Point(x=30, y=0),Point(x=30, y=9)
14:06:59.797 [main] DEBUG components.impl.BresenhamLineCalculator - Line points generated: Point(x=30, y=0)Point(x=30, y=1)Point(x=30, y=2)Point(x=30, y=3)Point(x=30, y=4)Point(x=30, y=5)Point(x=30, y=6)Point(x=30, y=7)Point(x=30, y=8)Point(x=30, y=9)
14:06:59.797 [main] DEBUG components.impl.BresenhamLineCalculator - Calculating line between points: Point(x=30, y=9),Point(x=39, y=9)
14:06:59.798 [main] DEBUG components.impl.BresenhamLineCalculator - Line points generated: Point(x=30, y=9)Point(x=31, y=9)Point(x=32, y=9)Point(x=33, y=9)Point(x=34, y=9)Point(x=35, y=9)Point(x=36, y=9)Point(x=37, y=9)Point(x=38, y=9)Point(x=39, y=9)
14:06:59.798 [main] DEBUG components.impl.BresenhamLineCalculator - Calculating line between points: Point(x=39, y=9),Point(x=39, y=0)
14:06:59.798 [main] DEBUG components.impl.BresenhamLineCalculator - Line points generated: Point(x=39, y=9)Point(x=39, y=8)Point(x=39, y=7)Point(x=39, y=6)Point(x=39, y=5)Point(x=39, y=4)Point(x=39, y=3)Point(x=39, y=2)Point(x=39, y=1)Point(x=39, y=0)
14:06:59.798 [main] DEBUG components.impl.BresenhamLineCalculator - Calculating line between points: Point(x=39, y=0),Point(x=30, y=0)
14:06:59.798 [main] DEBUG components.impl.BresenhamLineCalculator - Line points generated: Point(x=39, y=0)Point(x=38, y=0)Point(x=37, y=0)Point(x=36, y=0)Point(x=35, y=0)Point(x=34, y=0)Point(x=33, y=0)Point(x=32, y=0)Point(x=31, y=0)Point(x=30, y=0)
14:06:59.809 [main] INFO controller.AsciiGridController -
------------------------------------------
|                              xxxxxxxxxx|
|                              x        x|
|                              x        x|
|                  xxxx        x        x|
|                              x        x|
|                   x          x        x|
|                              x        x|
|                              x        x|
|                              x        x|
|                              xxxxxxxxxx|
------------------------------------------
```

Lines can also be diagonal
```
Please enter your command and press enter.
l 0 0 39 9
14:07:34.549 [main] DEBUG services.UserInputService - Line command received
14:07:34.549 [main] DEBUG components.impl.BresenhamLineCalculator - Calculating line between points: Point(x=0, y=0),Point(x=39, y=9)
14:07:34.550 [main] DEBUG components.impl.BresenhamLineCalculator - Line points generated: Point(x=0, y=0)Point(x=1, y=0)Point(x=2, y=0)Point(x=3, y=1)Point(x=4, y=1)Point(x=5, y=1)Point(x=6, y=1)Point(x=7, y=2)Point(x=8, y=2)Point(x=9, y=2)Point(x=10, y=2)Point(x=11, y=3)Point(x=12, y=3)Point(x=13, y=3)Point(x=14, y=3)Point(x=15, y=3)Point(x=16, y=4)Point(x=17, y=4)Point(x=18, y=4)Point(x=19, y=4)Point(x=20, y=5)Point(x=21, y=5)Point(x=22, y=5)Point(x=23, y=5)Point(x=24, y=6)Point(x=25, y=6)Point(x=26, y=6)Point(x=27, y=6)Point(x=28, y=6)Point(x=29, y=7)Point(x=30, y=7)Point(x=31, y=7)Point(x=32, y=7)Point(x=33, y=8)Point(x=34, y=8)Point(x=35, y=8)Point(x=36, y=8)Point(x=37, y=9)Point(x=38, y=9)Point(x=39, y=9)
14:07:34.551 [main] INFO controller.AsciiGridController -
------------------------------------------
|                              xxxxxxxxxx|
|                              x  xxxx  x|
|                             xxxx      x|
|                  xxxx  xxxxx x        x|
|                    xxxx      x        x|
|                xxxx          x        x|
|           xxxxx              x        x|
|       xxxx                   x        x|
|   xxxx                       x        x|
|xxx                           xxxxxxxxxx|
------------------------------------------
```

User input is checked for correctness using regex pattern matching.
```
Please enter your command and press enter.
asf safjipo
14:08:19.047 [main] WARN services.UserInputService - *** Unrecognised command *** - input must match one of the following regex patterns:
Create canvas:  [cC] [0-9]+ [0-9]+[ ]*
Draw line:      [lL] [0-9]+ [0-9]+ [0-9]+ [0-9]+[ ]*
Draw Rectangle: [rR] [0-9]+ [0-9]+ [0-9]+ [0-9]+[ ]*
Quit:           [qQ][ ]*
```

Coordinates of lines and rectangles are also checked against grid size for out of bounds exception.
```
Please enter your command and press enter.
r 0 0 50 50
14:08:43.819 [main] DEBUG services.UserInputService - Rectangle command received
14:08:43.819 [main] ERROR controller.AsciiGridController - Coordinates out of bounds! Min coords (0,0). Max coords (39,9)
```


## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
