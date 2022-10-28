package App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskBoard extends JFrame{
    private JList list1;
    private JList list2;
    private JButton editTaskButton;
    private JButton createTaskButton;
    private JButton completeButton;
    private JButton backButton;

    public TaskBoard() {
        createTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskCreate screen = new TaskCreate();
                screen.setSize(750,500);
                screen.setVisible(true);
                CloseScreen();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage screen = new homePage();
                screen.setSize(750,500);
                screen.setVisible(true);
                CloseScreen();
            }
        });

        editTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskCreate screen = new TaskCreate();
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
