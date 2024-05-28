import java.io.IOException;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        try {
            Start.startGame();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}