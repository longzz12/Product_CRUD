package minigames;
import java.awt.Color;
import java.awt.Frame;

public class MainFrame extends Frame {
    public MainFrame(){
        super("Mini Games");
        setSize(450,450);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(new Color(255, 204, 102));
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}
