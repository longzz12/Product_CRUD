package minigames;

import javax.swing.JFrame;

public class Hangman extends JFrame {
    JFrame frame;
    Hangman(){
        frame = new JFrame();
        frame.setTitle("Hangman");
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 270);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
