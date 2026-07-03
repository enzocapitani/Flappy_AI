package principal;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(){
        GamePanel gamePanel = new GamePanel();

        setTitle("Flappy IA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(gamePanel);
        setSize(Global.screenSize);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);

        gamePanel.requestFocus(true);
    }

    public static void main(String[] args) {
        new GameWindow();
    }

}
