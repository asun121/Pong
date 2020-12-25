import java.awt.*;

public class Ball implements Runnable
{
    private int xAccel, yAccel;
    private final int X_START = 250;
    private final int Y_START = 250;
    private final int BALL_SIZE = 20;
    Rectangle ball;

    private int collisionCnt;
    Paddle player2 = new Paddle(2);
    Paddle player1 = new Paddle(1);

    public static int score1, score2;

    public Ball()
    {
        ball = new Rectangle(X_START, Y_START,BALL_SIZE, BALL_SIZE);
        collisionCnt = 0;

        score1 = 0;
        score2 = 0;
    }

    public void interaction()
    {
        if(ball.intersects(player1.myPaddle)) { xAccel = 1; collisionCnt ++; randY(); }
        if(ball.intersects(player2.myPaddle)) { xAccel = -1; collisionCnt ++; randY(); }

        if(ball.y >= 500)
            yAccel = -2;
        if(ball.y <= 0)
            yAccel = 2;
    }
    public void randY()
    {
        if(Math.random() >= .5)
        {
            yAccel = 2;
        }
        else
            yAccel = -2;
    }
    public void move()
    {
        interaction();
        ball.x += xAccel;
        ball.y += yAccel;
        if(collisionCnt == 0)
        {
            xAccel = 2;
        }

        if(ball.x <= 0 || ball.x >= 500)
        {
            if(ball.x <= 0) { score2 ++; }
            else { score1 ++; }
            collisionCnt = 0;
            reset();
            player2.reset();
            player1.reset();
        }
    }

    public void reset()
    {
        xAccel = 0;
        yAccel = 0;
        ball.x = X_START;
        ball.y = Y_START;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(ball.x, ball.y, BALL_SIZE, BALL_SIZE);
    }
    @Override
    public void run()
    {
        try {
            while (true)
            {
                Thread.sleep(10);
                move();
            }
        }
        catch(Exception e)
        {
            System.out.println("sry");
        }
    }
}
