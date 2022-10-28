package App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loginscreen extends JFrame{
    private JPanel Maine;
    private JPasswordField passwordText;
    private JButton logInButton;
    private JButton signUpButton;
    private JButton exitButton;
    private JLabel errorLabel;
    private JTextField textField1;
    private ArrayList<User> userArrayList;
    protected static User thisUser;

    public Loginscreen() {
        this.setContentPane(this.Maine);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        userArrayList = new ArrayList<User>();

        try {
            split(readFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        User[] userArray = new User[userArrayList.size()];
        userArrayList.toArray(userArray);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignupClass screen = new SignupClass();
                screen.setSize(750, 500);
                screen.setVisible(true);
                CloseScreen();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CloseScreen();
            }
        });

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkConds(textField1.getText(), passwordText.getText())) {
                    selectUser(textField1.getText());
                    homePage screen = new homePage();
                    screen.setSize(750, 500);
                    screen.setVisible(true);
                    CloseScreen();
                }
            }
        });
    }

    public boolean checkConds (String user, String pass){
        boolean conds = false;
        User[] userArray = new User[userArrayList.size()];
        userArrayList.toArray(userArray);

        for ( int  i = 0; i < userArray.length; i ++){
            if (user.equals(userArray[i].getNickname())){
                if (pass.equals(userArray[i].getPassword()))
                    conds = true;
            }
        }
        return conds;
    }


    public void split(String[] students) {
        String line;
        int i;

        for ( i = 0; i < students.length; i++) {
            line = students[i];
            String[] myList = line.split(",");
            User newUser = new User(myList[0], myList[1], myList[2]);
            userArrayList.add(newUser);
        }
    }

    public void selectUser (String Username){
        int def = -1;
        User[] userArray = new User[userArrayList.size()];
        userArrayList.toArray(userArray);

        for ( int  i = 0; i < userArray.length; i ++){
           if (userArray[i].getNickname().equals(Username))
               def = i;
        }
        if( def >=0 )
            thisUser =  userArray[def];
    }
    public String[] readFile() throws IOException {

                List<String> userList
                        = new ArrayList<String>();

                BufferedReader bf = new BufferedReader(
                        new FileReader("UserData.txt"));

                String line = bf.readLine();

                while (line != null) {
                    userList.add(line);
                    line = bf.readLine();
                }

                bf.close();
                String[] array = userList.toArray(new String[0]);
                return  array;
            }

    public void CloseScreen(){
        this.setVisible(false);
    }
}