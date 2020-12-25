import java.awt.*;
import javax.swing.*;

public class Main extends JFrame
{
    private int fWidth = 500, fHeight = 500;
    private Graphics graphics;
    private Image img;


    public static Ball ball = new Ball();
    KeyControl kc = new KeyControl();

    public Main()
    {
        this.setSize(fWidth, fHeight);
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.addKeyListener(kc);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        Main mn = new Main();
        Thread ballProcess = new Thread(ball);
        ballProcess.start();
        Thread player1 = new Thread(ball.player1); player1.start();
        Thread player2 = new Thread(ball.player2); player2.start();
    }
    public void paint(Graphics g)
    {
        img = createImage(getWidth(), getHeight());
        graphics = img.getGraphics();
        draw(graphics);
        g.drawImage(img, 0, 0, this);
    }
    public void draw(Graphics g)
    {
        ball.draw(g);
        ball.player2.draw(g);
        ball.player1.draw(g);
        repaint();

        g.drawString(String.valueOf(ball.score1), 20, 50);
        g.drawString(String.valueOf(ball.score2), 480, 50);
    }

}
