package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import principal.GamePanel;

public class PlayerInputs implements KeyListener {

    GamePanel gamepanel;

    public PlayerInputs(GamePanel gp){
        this.gamepanel = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            gamepanel.passaro.pular();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
