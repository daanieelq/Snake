import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class Apple extends JComponent {
public static int applePosX;
public static int applePosY;

public Apple() {
    placeApple();
    setOpaque(false);
    setBounds(0,0,400,600);
}

    public void paint (Graphics gApple) {
        super.paintComponent(gApple);
        Graphics2D g2Apple = (Graphics2D) gApple;
        g2Apple.setColor(Color.RED);
        g2Apple.fillRect(applePosX, applePosY, 20, 20);
    }


    public void placeApple() {
    Random random = new Random();
        applePosX = random.nextInt(400);
        applePosY = random.nextInt(600);
    }
}
