package minigames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    JTextField txtUser = new JTextField();
    JPasswordField txtPw = new JPasswordField();

    JButton btnLogin = new JButton("Log in");
    JButton btnStart = new JButton("Start");
    JButton btnExit = new JButton("Exit");

    JPanel pnlcontent = new JPanel(new BorderLayout(5, 5));
    JPanel pnlWelcome = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
    JPanel pnllogInfo = new JPanel(new GridLayout(2,2));
    JPanel pnlBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20 ,5));

    Login(){

        setLayout(new BorderLayout());
        
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 23));
        
        //lblTitle.setIcon(icon);

        pnlWelcome.add(lblTitle);
        //pnlWelcome.add(lblsubTitle);

        // lblUser.setSize(50, 20);
        // txtUser.setSize(50, 20);
        // lblPw.setSize(50, 20);
        // txtPw.setSize(50, 20);

        pnllogInfo.add(lblUser);
        pnllogInfo.add(txtUser);
        pnllogInfo.add(lblPw);
        pnllogInfo.add(txtPw);

        // pnlBtn.setPreferredSize(new Dimension(200,100));
        btnStart.setVisible(false);
        pnlBtn.add(btnStart);
        pnlBtn.add(btnLogin);
        pnlBtn.add(btnExit);
        
        pnlcontent.add(pnlWelcome, BorderLayout.NORTH);
        pnlcontent.add(pnllogInfo, BorderLayout.CENTER);
        pnlcontent.add(pnlBtn, BorderLayout.SOUTH);

        frame.add(pnlcontent);

        btnLogin.addActionListener(this);
        btnExit.addActionListener(this);
        btnStart.addActionListener(this);

        txtUser.setFocusable(true);
        txtPw.setEchoChar('*');

        frame.setTitle("Mini games");
        //frame.setBackground(new Color(255, 204, 102));

        frame.setLocationRelativeTo(null);
        frame.setSize(500, 270);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== btnLogin){
            if(txtUser.getText().compareTo("user")==0 && String.valueOf(txtPw.getPassword()).compareTo("123456")==0){
                JOptionPane.showMessageDialog(null,"You're logged in!");
                btnLogin.setVisible(false);
                btnStart.setVisible(true);
                }
            else{
                if(error<=2){
                    error+=1;
                    JOptionPane.showMessageDialog(null,"Incorrect username or password! Please try again.");
                }
                else{
                    txtPw.setEnabled(false);
                    txtUser.setEnabled(false);
                    btnLogin.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Max attempt reached!");
                }
            }
        }
        if(ae.getSource()== btnExit){
            System.exit(0);
        }
        if(ae.getSource()==btnStart){
            frame.setVisible(false);
            new Homepage();
        }
    }
}
