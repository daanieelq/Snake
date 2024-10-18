import javax.swing.*;
import java.awt.*;
import java.awt.desktop.AppForegroundListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;


class Snake extends JComponent implements KeyListener {
    private int snakeSize = 20;
    int directionX;
    int directionY;
    private int speed = 60;
    Tile snakeHead;
    Tile snakeTail;
    int key;


    private class Tile {
        int x;
        int y;

        Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public Snake() {
        Apple placeApple = new Apple();
        setOpaque(false);
        setBounds(0,0,400,600);
        snakeHead = new Tile(190, 290);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        setFocusTraversalKeysEnabled(true);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (snakeHead.y > 600 && snakeHead.x > 400) {
                    snakeHead.y += directionY;
                    snakeHead.x += directionX;
                    repaint();
                }
            }
        },0, speed);

        if (snakeHead.x == Apple.applePosX && snakeHead.y == Apple.applePosY) {
            placeApple.placeApple();
        }

    }


    public void paint(Graphics gSnake) {
        super.paintComponent(gSnake);
        Graphics2D g2Snake = (Graphics2D) gSnake;
        g2Snake.setColor(Color.WHITE);
        g2Snake.fillRect(snakeHead.x, snakeHead.y, snakeSize, snakeSize);
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();

         if (key == 87 || key == 38) {
             System.out.println("Up");
             directionY -= 5;
             directionX = 0;
        } else if (key == 65 || key == 37) {
             System.out.println("Left");
             directionX -= 5;
             directionY = 0;
        } else if (key == 83 || key == 40) {
             System.out.println("Down");
            directionY += 5;
            directionX = 0;
        } else if (key == 68 || key == 39) {
             System.out.println("Right");
            directionX += 5;
            directionY = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}





