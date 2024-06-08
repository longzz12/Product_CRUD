package minigames;

import javax.swing.JFrame;

public class RockPaperScissor extends JFrame {
    JFrame frame;
    RockPaperScissor(){
        frame = new JFrame();
        frame.setTitle("Rock Paper Scissor");
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 270);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
