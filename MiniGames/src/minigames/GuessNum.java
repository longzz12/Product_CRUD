package minigames;

import javax.swing.JFrame;

public class GuessNum extends JFrame{
    JFrame frame;
    GuessNum(){
        frame = new JFrame();
        frame.setTitle("Guessing Number");
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 270);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
