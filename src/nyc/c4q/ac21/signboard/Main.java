

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
                    frame.write(x, y, "@");
                }
                if (0 < x + 1 && x + 1 < width) {
                    frame.setGreen();
                    frame.write(x + 1, y, "&");
                }
                if (x + 2 < width) {
                    frame.setRed();
                    frame.write(x + 2, y, "%");
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
    public static void scrollTextScene(SignBoard board, String text) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();
            if (x >= width)
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
            frame.finish(0.02);
        }
    }
    /**
     * Draws a scene which flashes the words "FRESH" and "HOT".
     * @param board
     *   The board on which to draw.
     * @param cycles
     *   The number of cycles to draw for.
     */
    public static void pickledIceCream(SignBoard board, int cycles) {
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
            if (i % 2 == 0) {
//

                frame.write(leftPosition, y - 4, "                                                                  .-~`'~-.  ");
                frame.write(leftPosition, y - 3, "IIIIIII  CCCCC  EEEEE       CCCCC RRRRR  EEEEE  AAAAA  MMMMMMMM  /        } ");
                frame.write(leftPosition, y - 2, "  III   CC      E          CC     R   R  E      A   A  MM MM MM  |        | ");
                frame.write(leftPosition, y - 1, "  III   CC      EEEEE  ~~~ CC     RRRRR  EEEEE  AAAAA  MM MM MM (_.--._.-._)");
                frame.write(leftPosition, y    , "  III   CC      E          CC     R  R   E      A   A  MM    MM   {=-=-=-/  ");
                frame.write(leftPosition, y + 1, "IIIIIII  CCCCC  EEEEE       CCCCC R   R  EEEEE  A   A  MM    MM    {=-=-/   ");
                frame.write(leftPosition, y + 2, "                                                                    {=-/    ");
                frame.write(leftPosition, y + 3, "                                                                     {/     ");



            }
            else {
//

                //frame.write(leftPosition, y - 4, "            88            88        88           ");
                frame.write(leftPosition, y - 4, "                          88        88           ");
                frame.write(leftPosition, y - 3, "8b,dPPYba,  88  ,adPPYba, 88   ,d8  88  ,adPPYba,");
                frame.write(leftPosition, y - 2, "88P'     8a 88 a8         88 ,a8    88 a8P_____88");
                frame.write(leftPosition, y - 1, "88       d8 88 8b         8888[     88 8PP~~~~~~~");
                frame.write(leftPosition, y    , "88b,   ,a8  88  8a,   ,aa 88` Yba,  88  8b,   ,aa");
                frame.write(leftPosition, y + 1, "88`YbbdP '  88  ` Ybbd8 ' 88   `Y8a 88  ` Ybbd8 '");
                frame.write(leftPosition, y + 2, "88                                               ");
                frame.write(leftPosition, y + 3, "88                                               ");


            }
            frame.finish(0.2);
        }
    }
    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);
        // Run the sign board forever.
        while (true) {
            ribbonScene(signBoard, 48);
            scrollTextScene(signBoard, "****  PICKLED ~ PICKLED* ICE CREAM  ****");
            ribbonScene(signBoard, 48);
            pickledIceCream(signBoard, 8);
        }
    }
}