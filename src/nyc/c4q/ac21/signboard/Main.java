package nyc.c4q.ac21.signboard;

import java.lang.ref.SoftReference;
import java.util.Random;

public class Main {
    /**
     * Draws a scene with a scrolling multicolor zig-zag ribbon.
     *
     * @param board     The board on which to draw.
     * @param numCycles The number of cycles to draw for.
     */


    public static void ribbonScene(SignBoard board, int numCycles) {
        int width = board.getWidth();
        int height = board.getHeight();
        for (int i = 1; i < numCycles; ++i) {
            SignBoard.Frame frame = board.newFrame();

            for (int x = -2; x < width; ++x) {
                int y = (2 * height - 2 + x + i) % (2 * height - 2);
                if (y >= height)
                    y = 2 * height - y - 2;

                if (y >= height)
                    y = 3 * height - y - 1;

                if (0 < x) {
                    frame.setWhite();
                    frame.write(x, y, "~");
                }
                if (0 < x + 2 && x + 1 > width) {
                    frame.setGreen();
                    frame.write(x + 1, y, "_");
                }
                if (x + 2 < width) {
                    frame.setRed();
                    frame.write(x + 2, y, "~");
                }
            }

            frame.finish(0.06);
        }
    }


    /**
     * Draws a scene with text scrolling across the screen..
     *
     * @param board The board on which to draw.
     * @param text  The text to scroll.
     */
    public static void scrollTextScene(SignBoard board, String text) {

        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text.length(); x <= width; ++x) { //array [0]
            SignBoard.Frame frame = board.newFrame();

            if (x >= width)
                break;

            if (x < 0)
                //for(int i =0; i < t.lenght;i++) {
                // Scrolling on to the left side.
                frame.write(0, y, text.substring(-x));
                //}

            else if (x + text.length() <= width) {
                // Fully on the board.
                frame.write(x, y - 1, text);


            } else {
                // Scrolling off the board.
                frame.write(x, y + 1, text.substring(0, width - x - 1));

            }


            frame.finish(0.01);
        }

    }


    /**
     * Draws a scene which flashes the words "FRESH" and "HOT".
     *
     * @param board  The board on which to draw.
     * @param cycles The number of cycles to draw for.
     */
    public static void flashFreshHotScene(SignBoard board, int cycles) {
        Random random = new Random();

        int width = board.getWidth();
        int leftPosition = width / 4 - 12;
        int rightPosition = 3 * width / 4 - 7;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();

            // Choose a color at random.
            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();
            // Write a word.


            if (i % 2 == 1) {
                frame.setYellow();
                frame.write(leftPosition, y - 3, "oxoxxoxoxoxox      ");
                frame.write(leftPosition, y - 2, "oxoxoxo o   x      ");
                frame.write(leftPosition, y - 1, "oxoxo   oxoxo      ");
                frame.write(leftPosition, y, "oxoxo       -~ ~ ~ ~     YUM NOM YUM      ");
                frame.write(leftPosition, y + 1, "oxoxo   oxoxo      ");
                frame.write(leftPosition, y + 2, "oxoxo   x   x      ");
                frame.write(leftPosition, y + 3, "oxoxoxxoxoxoxo     ");

            }
            if (i % 2 == 0) {
                frame.setRed();
                frame.write(leftPosition, y - 3, "xoxoxoxoxoxxox      ");
                frame.write(leftPosition, y - 2, "xoxoxox o   ox     ");
                frame.write(leftPosition, y - 1, "xoxo               ");
                frame.write(leftPosition, y, "xoxo              NEED SNACK             ");
                frame.write(leftPosition, y + 1, "xoxo                ");
                frame.write(leftPosition, y + 2, "xoxoxoxoxoxxox      ");
                frame.write(leftPosition, y + 3, "xoxoxoxoxoxxox      ");


            } else if (i % 3 == 1) {

                frame.write(rightPosition, y - 3, "    || ");
                frame.write(rightPosition, y - 2, "    || ");
                frame.setWhite();
                frame.write(rightPosition, y - 1, ". <><><>.");
                frame.write(rightPosition, y, ".<><><><>.");
                frame.write(rightPosition, y + 1, "'<><><><>'");
                frame.write(rightPosition, y + 2, " '<><><>'");
            } else if (i % 3 == 2) {
                frame.setWhite();
                frame.write(rightPosition, y - 2, "  ~@~*~@~ ");
                frame.write(rightPosition, y - 1, "~*~@~*~@~*~");
                frame.write(rightPosition, y, "~*~OREO*~");
                frame.write(rightPosition, y + 1, "~*~@~*~@~*~ ");
                frame.write(rightPosition, y + 2, "  ~@~*~@~ ");

            } else {
                frame.setRed();
                frame.write(rightPosition, y - 2, "  '.    \\   :   /    .'");
                frame.write(rightPosition, y - 1, "    '.   \\  :  /   .'");
                frame.write(rightPosition, y, "       '.  \\ : /  .'       ");
                frame.setYellow();

                frame.write(rightPosition, y + 1, "  -----____   _  _____-----");
                frame.write(rightPosition, y + 2, "  ___________(_)___________");
            }

            frame.finish(0.7);
        }
    }



    public static void footSteps(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 10;
        int centerLeft = width / 4;
        int centerRight = width / 4 + 10;
        int farRightPosition = 2 * width / 4 + 10;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();

            // Choose a color at random.
            int color = random.nextInt(4);
            if (color == 0)
                frame.setWhite();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();
            // Write a word.
            if (i == 0) {
                frame.write(leftPosition, y   , "Come");
            } else if (i == 1) {
                frame.write(centerLeft, y - 1, "    ,-.   ,-.()");
                frame.write(centerLeft, y    , "   (   `-'   D");
                frame.write(centerLeft, y + 1, "    `-._  -- D");
                frame.write(centerLeft, y + 2, "        `-._,B");

            } else if (i == 2) {
               // frame.write(centerRight, y - 2, "   .'#'#   #'#'.");
                frame.write(centerRight, y - 1, "           _,-'`B");
                frame.write(centerRight, y    , "       _,-'  -- D");
                frame.write(centerRight, y + 1, "      (   ,-.   D");
                frame.write(centerRight, y + 2, "       `-'   `-'()");
            }
            else {

                frame.write(farRightPosition, y    , "        ,-.   ,-.()");
                frame.write(farRightPosition, y + 1, "       (   `-'   D");
                frame.write(farRightPosition, y + 2, "        `-._  -- D");
                frame.write(farRightPosition, y + 3, "            `-._,B");
            }

            frame.finish(0.25);
        }
    }


    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {
           // ribbonScene(signBoard, 48);
            footSteps(signBoard,8);
            //scrollTextScene(signBoard,".---/ `\\\n" +
            //ribbonScene(signBoard, 48);
            flashFreshHotScene(signBoard, 8);

        }
    }



    }

