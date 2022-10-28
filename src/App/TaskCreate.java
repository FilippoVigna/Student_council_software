package App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskCreate extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton saveButton;
    private JButton backButton;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JPanel Maine;

    public TaskCreate() {
        this.setContentPane(this.Maine);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskBoard screen = new TaskBoard();
                screen.setSize(750, 500);
                screen.setVisible(true);
                CloseScreen();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskBoard screen = new TaskBoard();
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
