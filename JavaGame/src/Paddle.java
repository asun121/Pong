import java.awt.*;

public class Paddle implements Runnable
{
    int x, y;
    public int accel;
    Rectangle myPaddle;
    private final int P1_POS = 50, P2_POS = 450;

    public Paddle(int player)
    {
        y= 250;
        if(player == 1)
            x = P1_POS;
        else
            x = P2_POS;
        myPaddle = new Rectangle(x, y, 15, 70);
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(myPaddle.x, myPaddle.y, 15, 70);
    }

    public void reset()
    {
        myPaddle.y = 250;
    }

    public void move()
    {
        myPaddle.y += accel;
        if(myPaddle.y >= 450)
            myPaddle.y = 450;
        if(myPaddle.y <= 10)
            myPaddle.y = 10;

    }
    @Override
    public void run()
    {
        try {
            while (true)
            {
                move();
                Thread.sleep(10);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("sry error");
        }

    }
}
