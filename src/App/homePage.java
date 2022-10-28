package App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static App.Loginscreen.thisUser;

public class homePage extends JFrame{
    private JButton financeButton;
    private JButton electionsButton;
    private JButton taskButton;
    private JButton logoutButton;
    private JButton eventButton;
    private JPanel Maine;
    private JLabel welcomeLabel;

    public homePage() {
        this.setContentPane(this.Maine);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        welcomeLabel.setText("Welcome, " + thisUser.getNickname());


        taskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskBoard screen = new TaskBoard();
                screen.setSize(750, 500);
                screen.setVisible(true);
                CloseScreen();
            }
        });

        financeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FinanceTracker screen = new FinanceTracker();
                screen.setSize(750, 500);
                screen.setVisible(true);
                CloseScreen();
            }
        });
        eventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventTracker screen = new EventTracker();
                screen.setSize(750, 500);
                screen.setVisible(true);
                CloseScreen();
            }
        });

        electionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pollsTracker screen = new pollsTracker();
                screen.setSize(750, 500);
                screen.setVisible(true);
                CloseScreen();
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loginscreen screen = new Loginscreen();
                screen.setSize(750, 500);
                screen.setVisible(true);
                CloseScreen();
            }
        });
        taskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskBoard screen = new TaskBoard();
                screen.setSize(750,500);
                screen.setVisible(true);
                CloseScreen();
            }
        });
    }

    public void CloseScreen(){
        this.setVisible(false);
    }
}
