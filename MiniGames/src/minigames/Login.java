package minigames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener{
    JFrame frame = new JFrame();
    int error = 0;

    //ImageIcon icon = new ImageIcon(new ImageIcon("D:/CS201-202/JAVA/JavaMinigames/Minigames/video-game-gamepad-icon (1).png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
    JLabel lblTitle = new JLabel("Welcome to FunHaus!");
    JLabel lblsubTitle = new JLabel("Many fun awaits!");
    JLabel lblUser = new JLabel("username: ");
    JLabel lblPw = new JLabel("password: ");

    JTextField txtUser = new JTextField(20);
    JPasswordField txtPw = new JPasswordField(20);

    JButton btnLogin = new JButton("Log in");
    JButton btnStart = new JButton("Start");
    JButton btnExit = new JButton("Exit");

    JPanel pnlcontent = new JPanel();
    JPanel pnlWelcome = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
    JPanel pnllogInfo1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
    JPanel pnllogInfo2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
    JPanel pnllogInfo = new JPanel();
    JPanel pnlBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20 ,5));

    Login(){
        pnlcontent.setLayout(new BoxLayout(pnlcontent, BoxLayout.Y_AXIS));
        setLayout(new BorderLayout());
        
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 23));
        
        pnlWelcome.add(lblTitle);
        pnlWelcome.setBackground(Color.LIGHT_GRAY);
        pnllogInfo1.add(lblUser);  pnllogInfo1.add(txtUser);
        pnllogInfo2.add(lblPw);    pnllogInfo2.add(txtPw);
        pnllogInfo.setLayout(new BoxLayout(pnllogInfo, BoxLayout.Y_AXIS));
        pnllogInfo.add(pnllogInfo1);
        pnllogInfo.add(pnllogInfo2);

        btnStart.setVisible(false);
        pnlBtn.add(btnStart);
        pnlBtn.add(btnLogin);
        pnlBtn.add(btnExit);
        
        pnlcontent.add(pnlWelcome);
        pnlcontent.add(pnllogInfo);
        pnlcontent.add(pnlBtn);

        frame.add(pnlcontent, BorderLayout.NORTH);

        btnLogin.addActionListener(this);
        btnExit.addActionListener(this);
        btnStart.addActionListener(this);

        txtUser.setFocusable(true);
        txtPw.setEchoChar('*');

        txtUser.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode()== KeyEvent.VK_ENTER)
                    txtPw.requestFocus();
            }
        });
        txtPw.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode()== KeyEvent.VK_ENTER)
                    loggingIn();}
        });
        
        frame.setTitle("Mini games");
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 230);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== btnLogin){
            loggingIn();
        }
        if(ae.getSource()== btnExit){
            System.exit(0);
        }
        if(ae.getSource()==btnStart){
            frame.setVisible(false);
            new Homepage();
        } 
    }
    public void loggingIn(){
        if(txtUser.getText().compareTo("user")==0 && String.valueOf(txtPw.getPassword()).compareTo("123456")==0){
            JOptionPane.showMessageDialog(null,"You're logged in!");
            btnLogin.setVisible(false);
            btnStart.setVisible(true);
            }
        else{
            if(error<=2){
                error+=1;
                JOptionPane.showMessageDialog(null,"Incorrect username or password! \nPlease try again.");
            }
            else{
                txtPw.setEnabled(false);
                txtUser.setEnabled(false);
                btnLogin.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Max attempt reached!");
            }
        }
    }
}
