import java.util.Timer;

public class Main extends Snake {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new Window());
        new Snake();
        new Apple();
    }
}