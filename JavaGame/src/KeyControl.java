import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyControl extends KeyAdapter
{

        @Override
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_DOWN) { Main.ball.player1.accel = 2; }
            if(e.getKeyCode() == KeyEvent.VK_UP) { Main.ball.player1.accel = -2; }

            if(e.getKeyCode() == KeyEvent.VK_S) { Main.ball.player2.accel = 2; }
            if(e.getKeyCode() == KeyEvent.VK_W) { Main.ball.player2.accel = -2; }

        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_DOWN) { Main.ball.player1.accel = 0; }
            if(e.getKeyCode() == KeyEvent.VK_UP) { Main.ball.player1.accel = 0; }

            if(e.getKeyCode() == KeyEvent.VK_S) { Main.ball.player2.accel = 0; }
            if(e.getKeyCode() == KeyEvent.VK_W) { Main.ball.player2.accel = 0; }
        }
}
