package App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTracker extends JFrame{
    private JTextField textField1;
    private JButton addNewEventButton;
    private JButton editEventButton;
    private JList list1;
    private JButton backButton;
    private JPanel Maine;
    private JTextField nameText;
    private JTextField incomeText;
    private JTextField descriptionText;
    private JButton fileOptionsMenuButton;
    private JButton searchButton;
    private JButton loadFromFileButton;
    private JButton saveToFileButton;
    private JButton saveAsTransactionButton;
    private JButton saveNewEventButton;
    private JButton clearValuesButton;
    private JButton updateEventButton;
    private JPanel fileMenu;

    public EventTracker() {
        this.setContentPane(this.Maine);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage screen = new homePage();
                screen.setSize(750, 500);
                screen.setVisible(true);
                CloseScreen();
            }
        });

    }

    public void CloseScreen(){
        this.setVisible(false);
    }
}
