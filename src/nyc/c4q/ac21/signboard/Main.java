package nyc.c4q.ac21.signboard;

import java.util.Random;

public class Main {
    /**
     * Draws a scene with a scrolling multicolor zig-zag ribbon.
     * @param board
     *   The board on which to draw.
     * @param numCycles
     *   The number of cycles to draw for.
     */
    public static void ribbonScene(SignBoard board, int numCycles) {
        int width = board.getWidth();
        int height = board.getHeight();
        for (int i = 0; i < numCycles; ++i) {
            SignBoard.Frame frame = board.newFrame();

            for (int x = -2; x < width; ++x) {
                int y = (2 * height - 2 + x + i) % (2 * height - 2);
                if (y >= height)
                    y = 2 * height - y - 2;
                if (0 < x) {
                    frame.setYellow();
                    frame.write(x, y, "/");
                }
                if (0 < x + 1 && x + 1 < width) {
                    frame.setGreen();
                    frame.write(x + 1, y, "*");
                }
                if (x + 2 < width) {
                    frame.setRed();
                    frame.write(x + 2, y, "?");
                }
            }

            frame.finish(0.02);
        }
    }

    /**
     * Draws a scene with text scrolling across the screen..
     * @param board
     *   The board on which to draw.
     * @param text
     *   The text to scroll.
     */
    public static void scrollTextRightToLeft(SignBoard board, String text) {
        Random random = new Random();
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = width - 1; x <= width; --x) {
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
            if (x + text.length() < 0)
                break;

            if (x < 0)
                // Scrolling on to the left side.
                frame.write(0, y, text.substring(-x));
            else if (x + text.length() <= width)
                // Fully on the board.
                frame.write(x, y, text);
            else
                // Scrolling off the board.
                frame.write(x, y, text.substring(0, width - x));

            frame.finish(0.04);
        }
    }

    /**
     * Draws a scene which flashes the words "FRESH" and "HOT".
     * @param board
     *   The board on which to draw.
     * @param cycles
     *   The number of cycles to draw for.
     */
    public static void heartGrow(SignBoard board, int cycles) {
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
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();
            // Write a word.
            if (i == 0) {
                frame.write(leftPosition, y   , "-`ღ´-");
            } else if (i == 1) {
                frame.write(centerLeft, y - 1, " '#¯'v'¯#'");
                frame.write(centerLeft, y    , "  '#   #' ");
                frame.write(centerLeft, y + 1, "    '#'   ");

            } else if (i == 2) {
                frame.write(centerRight, y - 2, "   .'#'#   #'#'.");
                frame.write(centerRight, y - 1, "  '#.   'v'   .#'");
                frame.write(centerRight, y    , "   '#.       .#'");
                frame.write(centerRight, y + 1, "     '#.   .#'");
                frame.write(centerRight, y + 2, "        '#'");
            }
            else {
                frame.write(farRightPosition, y - 4, "  .'#'#       #'#'.");
                frame.write(farRightPosition, y - 3, "  #.   '#. .#'   .#'");
                frame.write(farRightPosition, y - 2, " '#.     '#'     .#'");
                frame.write(farRightPosition, y - 1, "  '#.           .#'");
                frame.write(farRightPosition, y    , "   '#.         .#'");
                frame.write(farRightPosition, y + 1, "     '#.     .#'");
                frame.write(farRightPosition, y + 2, "       '#. .#'");
                frame.write(farRightPosition, y + 3, "         '#'");
            }

            frame.finish(0.25);
        }
    }


    public static void mexicoJapan(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 15;
        int rightPosition = 2 * width / 4;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();

            // Write a word.
            if (i % 2 == 0) {
                frame.setWhite();
                frame.write(leftPosition, y - 3, "      | |                        ");
                frame.write(leftPosition, y - 2, "      | | __ _ _ __   __ _ _ __  ");
                frame.write(leftPosition, y - 1, "  _   | |/ _` | '_ \\ / _` | '_ \\ ");
                frame.write(leftPosition, y    , " | |__| | (_| | |_) | (_| | | | |");
                frame.setRed();
                frame.write(leftPosition, y + 1, "  \\____/ \\__,_| .__/ \\__,_|_| |_|");
                frame.setWhite();
                frame.write(leftPosition, y + 2, "              | |                ");
                frame.write(leftPosition, y + 3, "              |_|                ");
            } else {
                frame.setGreen();
                frame.write(rightPosition, y - 3, "  __  __           _           ");
                frame.write(rightPosition, y - 2, " |  \\/  |         (_)          ");
                frame.write(rightPosition, y - 1, " | \\  / | _____  ___  ___ ___  ");
                frame.setWhite();
                frame.write(rightPosition, y    , " | |\\/| |/ _ \\ \\/ / |/ __/ _ \\ ");
                frame.setRed();
                frame.write(rightPosition, y + 1, " | |  | |  __/>  <| | (_| (_) |");
                frame.write(rightPosition, y + 2, " |_|  |_|\\___/_/\\_\\_|\\___\\___/ ");
                frame.write(rightPosition, y + 3, "                               ");
            }

            frame.finish(0.45);
        }
    }

    public static void sushiBurrito(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 15;
        int rightPosition = 2 * width / 4;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();

            // Write a word.
            if (i % 2 == 0) {
                frame.setWhite();
                frame.write(leftPosition, y - 2, "  /¯____|         |¯|   (_)");
                frame.write(leftPosition, y - 1, " | (___  _   _ ___| |__  _ ");
                frame.setRed();
                frame.write(leftPosition, y    , "  \\___ \\| | | / __| '_ \\| |");
                frame.setWhite();
                frame.write(leftPosition, y + 1, "  ____) | |_| \\__ \\ | | | |");
                frame.write(leftPosition, y + 2, " |_____/ \\__,_|___/_| |_|_|");
            } else {
                frame.setGreen();
                frame.write(rightPosition, y - 2, " |¯¯_¯\\                (_) |       ");
                frame.write(rightPosition, y - 1, " | |_) |_   _ _ __ _ __ _| |_ ___  ");
                frame.setWhite();
                frame.write(rightPosition, y    , " |  _ <| | | | '__| '__| | __/ _ \\ ");
                frame.setRed();
                frame.write(rightPosition, y + 1, " | |_) | |_| | |  | |  | | || (_) |");
                frame.write(rightPosition, y + 2, " |____/ \\__,_|_|  |_|  |_|\\__\\___/ ");
            }

            frame.finish(0.45);
        }
    }

    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {
            ribbonScene(signBoard, 48);
            scrollTextRightToLeft(signBoard, "H A V E  Y O U  H E A R D");
            scrollTextRightToLeft(signBoard, "A B O U T  T H I S  Y E A R ' S");
            scrollTextRightToLeft(signBoard, "H O T T E S T  C O U P L E ?");
            scrollTextRightToLeft(signBoard, "H I N T :");
            scrollTextRightToLeft(signBoard, "I T ' S  N O T  R I H A N N A  A N D  D R A K E . . .");
            heartGrow(signBoard, 4);
            mexicoJapan(signBoard, 8);
            sushiBurrito(signBoard, 8);
            ribbonScene(signBoard, 48);
        }
    }
}