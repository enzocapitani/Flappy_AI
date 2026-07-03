package principal;

import objetos.*;

import javax.swing.JPanel;

import inputs.PlayerInputs;

import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private Thread gameThread;
    private final int FPS = 60;

    public Passaro passaro = new Passaro();
    public Cano cano = new Cano();

    public GamePanel() {
        super();
        setPreferredSize(Global.screenSize);
        setBackground(Color.BLACK);
        addKeyListener(new PlayerInputs(this));
        setFocusable(true);

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double frameTime = 1_000_000_000.0 / FPS;
        long lastTime = System.nanoTime();
        double delta = 0;

        while (gameThread != null) {
            long now = System.nanoTime();
            delta += (now - lastTime) / frameTime;
            lastTime = now;

            if (delta >= 1) {

                passaro.update();

                repaint();

                delta--;

            } else {
                Thread.yield();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        passaro.desenharPassaro(g2d);
        cano.desenharCano(g2d);

    }

}
