package minigames;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Homepage extends JFrame implements ActionListener{
    Label lblHello = new Label("Welcome!");
    Label lblChoice = new Label("Choose a game below to play!");

    Button btnGame1 = new Button ("Guessing Number");
    Button btnGame2 = new Button ("Hangman");
    Button btnGame3 = new Button ("Rock-Paper-Scissor");

    Panel pnlGreet = new Panel(new FlowLayout(1, 0, 10));
    Panel pnlChoice = new Panel(new FlowLayout(1, 10, 10));

    Homepage(){
        setTitle("Mini Games");
        setSize(450,450);
        setLayout(new BorderLayout());
        setResizable(true);
        setLocationRelativeTo(null);
        setBackground(new Color(255, 204, 102));
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btnGame1)
            return;
        if (ae.getSource()==btnGame2)
            return;
        if(ae.getSource()==btnGame3)
            return;
    }
}
