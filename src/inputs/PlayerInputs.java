package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import principal.managers.GameManager;

public class PlayerInputs implements KeyListener {

    GameManager gameManager;

    public PlayerInputs(GameManager gm){
        this.gameManager = gm;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE -> gameManager.passaroP  .pular();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
