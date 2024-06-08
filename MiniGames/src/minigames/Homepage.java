package minigames;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Homepage extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JLabel lblWelcome = new JLabel("Welcome!");
    JLabel lblChoice = new JLabel("Choose a game below to play.");

    // ImageIcon image1 = new ImageIcon("");
    // ImageIcon image2 = new ImageIcon("");
    // ImageIcon image3 = new ImageIcon("");

    JButton btnGame1 = new JButton("Guessing Number");
    JButton btnGame2 = new JButton("Hangman");
    JButton btnGame3 = new JButton("Rock-Paper-Scissor");

    JPanel pnlHeading = new JPanel(new GridLayout(2, 1));
    JPanel pnlChoice = new JPanel(new GridLayout(1, 3, 20, 10));
    JPanel pnlContent = new JPanel(new BorderLayout(10, 10));

    Homepage(){
        lblWelcome.setHorizontalAlignment(JLabel.CENTER);
        lblWelcome.setFont(new Font("Calibri", Font.BOLD, 23));
        lblWelcome.setHorizontalAlignment(JLabel.CENTER);
        lblWelcome.setFont(new Font("Calibri", Font.ITALIC, 18));
        
        pnlHeading.add(lblWelcome);
        pnlHeading.add(lblChoice);

        // btnGame1.setSize(50, 10);
        // btnGame2.setSize(50,10);
        // btnGame3.setSize(50,10);

        pnlChoice.add(btnGame1);
        pnlChoice.add(btnGame2);
        pnlChoice.add(btnGame3);

        pnlContent.add(pnlHeading, BorderLayout.NORTH);
        pnlContent.add(pnlChoice, BorderLayout.CENTER);
        frame.add(pnlContent);

        btnGame1.addActionListener(this);
        btnGame2.addActionListener(this);
        btnGame3.addActionListener(this);

        frame.setTitle("Mini games");
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 270);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btnGame1){
            frame.setVisible(false);
            new GuessNum();
        }
        if(ae.getSource()==btnGame2){
            frame.setVisible(false);
            new Hangman();
        }
        if(ae.getSource()==btnGame3){
            frame.setVisible(false);
            new RockPaperScissor();
        }
    }
}
