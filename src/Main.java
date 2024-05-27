import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            Start.startGame();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}