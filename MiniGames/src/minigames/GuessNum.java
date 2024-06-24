package minigames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GuessNum extends JFrame implements ActionListener{
    JFrame frame;
    //Game 
    Random random = new Random();
    int x, tries;

    //Design
    JLabel lblHeader = new JLabel("Guessing Game", JLabel.CENTER);
    JLabel lblInstruction = new JLabel("Enter your guess below (1-100): ", JLabel.CENTER);

    JLabel lblGuess = new JLabel("Guess: ");
    JTextField txtGuess = new JTextField(15);
    JLabel lblWarning = new JLabel("Invalid input! Input a number between 1-100!", JLabel.CENTER);
    
    JButton btnGuess = new JButton("Guess");
    JButton btnRestart= new JButton("Restart");
    JButton btnQuit = new JButton("Quit");

    List txtRecord = new List(5,false);
    String header = "N of tries         Guess           Comment";

    JPanel pnlHeader = new JPanel(new GridLayout(2,1,5,5));
    JPanel pnlGuess = new JPanel(new FlowLayout());
    JPanel pnlGuess1 = new JPanel(new GridLayout(2,1, 5,5));

    JPanel pnlbtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,5));
    JPanel pnlcontent = new JPanel(new BorderLayout());
    JPanel pnlFull = new JPanel(new BorderLayout());

    GuessNum(){
        frame = new JFrame();
        frame.add(pnlFull);
        frame.setTitle("Guessing Number");
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 350);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblHeader.setFont(new Font("Helvetica", Font.BOLD, 23));
        pnlHeader.setBackground(Color.LIGHT_GRAY);
        pnlHeader.add(lblHeader);
        pnlHeader.add(lblInstruction);
        pnlFull.add(pnlHeader, BorderLayout.NORTH);

        pnlGuess.add(lblGuess); pnlGuess.add(txtGuess); 

        pnlGuess1.add(pnlGuess);
        pnlGuess1.add(pnlbtn);

        pnlbtn.add(btnGuess); pnlbtn.add(btnRestart);pnlbtn.add(btnQuit);
        txtRecord.add(header);

        pnlcontent.add(pnlGuess1, BorderLayout.NORTH);
        pnlcontent.add(txtRecord,BorderLayout.CENTER);
        pnlFull.add(pnlcontent,BorderLayout.CENTER);
        
        btnGuess.addActionListener(this);
        btnRestart.addActionListener(this);
        btnQuit.addActionListener(this);

        x = random.nextInt(100)+1;
        tries = 0;     
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== btnGuess){
            String record ="";
            String tooHigh = "Your guess is too high!";
            String tooLow = "Your guess is too low!";
            String correct = "Your guess is correct!";
            tries ++;
            if( x > Integer.parseInt(txtGuess.getText())){
                record = "          "+ tries + "                  " + txtGuess.getText()+ "           " + tooLow;
                txtRecord.add(record);
            }
            else if( x < Integer.parseInt(txtGuess.getText())){
                record = "          "+tries + "                  " + txtGuess.getText()+ "           " +tooHigh ;
                txtRecord.add(record);
            }
            else{
                record = "          "+tries + "                  " + txtGuess.getText()+ "           " +correct ;
                txtRecord.add(record);
                JOptionPane.showMessageDialog(null, record());
            }
            txtGuess.setText("");
            txtGuess.requestFocus();
        }
        if(ae.getSource()== btnQuit){
            System.exit(0);
        }
        if(ae.getSource()== btnRestart){
            txtRecord.removeAll();
            txtRecord.add(header);
            txtGuess.setText("");
            txtGuess.setFocusable(true);
            x = random.nextInt(100)+1;
            tries = 0;
        }
    }
    public String record(){
        String msg = "";
        msg = "Congratulations!\n";
        msg += "Correct guess: " + String.valueOf(x);
        msg += "\nNumber of tries: "+ String.valueOf(tries);
        return msg;
    }
}