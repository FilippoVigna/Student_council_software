package App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class SignupClass extends JFrame{
    private JButton signUpButton;
    private JButton backButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JRadioButton treasurerRadioButton;
    private JRadioButton communicationsRadioButton;
    private JRadioButton presidentRadioButton;
    private JPanel Maine;
    private JPasswordField passwordField2;
    private JLabel errorLabel;
    protected static int linecount =0 ;


    public SignupClass() {
        this.setContentPane(this.Maine);
        this.pack();
        errorLabel.setText("");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loginscreen screen = null;
                screen = new Loginscreen();
                screen.setSize(750,500);
                screen.setVisible(true);
                CloseScreen();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkConditions()) {
                    createUser();
                    Loginscreen screen = null;
                    screen = new Loginscreen();
                    screen.setSize(750, 500);
                    screen.setVisible(true);
                    CloseScreen();
                }
            }
        });

        treasurerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presidentRadioButton.setSelected(false);
                communicationsRadioButton.setSelected(false);
            }
        });


        presidentRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                treasurerRadioButton.setSelected(false);
                communicationsRadioButton.setSelected(false);
            }
        });

        communicationsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                treasurerRadioButton.setSelected(false);
                presidentRadioButton.setSelected(false);
            }
        });
    }

    public boolean checkConditions(){;
        String a = passwordField1.getText();
        String b = passwordField2.getText();
        if (textField1.getText().length() < 3)
            errorLabel.setText("Error: nickname must be longer than 3 letters");
        else if (passwordField1.getText().length() < 5)
            errorLabel.setText("Error: password must be longer than 3 letters");
        else return a.equals(b);
        return false;
    }

    public void createUser(){

            FileWriter fw = null;
            try {
                fw = new FileWriter("UserData.txt", true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                String treasurer = "Tres";
                String communications = "Comms";
                String president = "Pres";
                if (presidentRadioButton.isSelected())
                    fw.write(textField1.getText() + "," +  passwordField1.getText() + "," + president);
                else if (communicationsRadioButton.isSelected())
                    fw.write(textField1.getText() + "," + passwordField1.getText() + "," + communications);
                else
                    fw.write(textField1.getText() + "," + passwordField1.getText() + "," + treasurer);
                linecount = linecount +1;

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }

    public void CloseScreen(){
        this.setVisible(false);
    }
}
