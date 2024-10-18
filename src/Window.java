import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    public Window() {
        super("Snake");
        setSize(400,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel layeredPanel = new JPanel();
        layeredPanel.setLayout(new OverlayLayout(layeredPanel));
        Snake snake = new Snake();
        Apple apple = new Apple();
        layeredPanel.add(snake);
        layeredPanel.add(apple);
        layeredPanel.setBackground(Color.BLACK);
        getContentPane().add(layeredPanel);
     }
}
