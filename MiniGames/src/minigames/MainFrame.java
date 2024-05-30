package minigames;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
// import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
    // ImageIcon icon = new ImageIcon("video-game-gamepad-icon.png");
    // JLabel lblIcon = new JLabel(icon);
    JLabel lblTitle = new JLabel("Welcome to our Homepage!");
    JLabel lblSubtitle = new JLabel("Many fun games await!!!");
    JLabel lblLogin = new JLabel("Log in to start your journey!");
    JLabel lblUser = new JLabel("Username: ");
    JLabel lblPw = new JLabel("Password: ");

    JTextField TextUser = new JTextField("");
    JPasswordField TextPw = new JPasswordField();

    JButton btnLogin = new JButton("Log in");
    JButton btnQuit = new JButton("Quit");

    JPanel pnlHello = new JPanel(new GridLayout(2,1));
    JPanel pnlLogin = new JPanel(new BorderLayout());
    JPanel pnlLogin1 = new JPanel(new GridLayout(3,2));

    public MainFrame(){
        setLayout(new BorderLayout());
        lblTitle.setFont(new Font("cursive",Font.BOLD,25));
        //add(lblIcon);
        pnlHello.add(lblTitle);
        pnlHello.add(lblSubtitle);

        pnlLogin.add(lblLogin,BorderLayout.NORTH);
        pnlLogin1.add(lblUser);        pnlLogin1.add(TextUser);
        pnlLogin1.add(lblPw);          pnlLogin1.add(TextPw);
        pnlLogin1.add(btnLogin);       pnlLogin1.add(btnQuit);  
        pnlLogin.add(pnlLogin1, BorderLayout.CENTER);

        add(pnlHello,BorderLayout.NORTH);
        add(pnlLogin,BorderLayout.CENTER);

        TextUser.setFocusable(true);

        setTitle("Mini Games");
        setSize(450,450);
        
        setResizable(true);
        setLocationRelativeTo(null);
        setBackground(new Color(255, 204, 102));setVisible(true);
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}
