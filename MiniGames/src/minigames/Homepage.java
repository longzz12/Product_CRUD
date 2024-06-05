package minigames;

import javax.swing.JFrame;

public class Homepage extends JFrame {
    Homepage(){
        setTitle("Mini games");
        setLocationRelativeTo(null);
        setSize(500, 270);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
