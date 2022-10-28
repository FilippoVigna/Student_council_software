package App;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import java.util.List;

import static App.Loginscreen.thisUser;

public class FinanceTracker extends JFrame {
    private JList<String> transactionList;
    private JPanel Maine;
    private JButton addNewEventButton;
    private JButton updateEventButton;
    private JTextField searchBar;
    private JTextField nameText;
    private JTextField incomeText;
    private JTextField descriptionText;
    private JLabel incomeLabel;
    private JButton backButton;
    private JButton clearTransactionButton;
    private JButton loadFromFileButton;
    private JButton saveToFileButton;
    private JPanel filePanel;
    private JButton fileOptionsMenuButton;
    private JButton searchButton;
    private JLabel errorLabel;
    private final ArrayList<Transaction> transactions;
    private final DefaultListModel<String> listtransactionsModel;
    private double revenue = 0;
    private int temp = 0;

    public FinanceTracker() {
        this.setContentPane(this.Maine);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        transactions = new ArrayList<Transaction>();
        listtransactionsModel = new DefaultListModel<String>();
        transactionList.setModel(listtransactionsModel);
        filePanel.setVisible(false);

        updateEventButton.setEnabled(false);
        clearTransactionButton.setEnabled(false);
        nameText.setText(" ");
        descriptionText.setText(" ");


       // if (thisUser.isComms())
          //  addNewEventButton.setEnabled(false);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage screen = new homePage();
                screen.setSize(750, 500);
                screen.setVisible(true);
                CloseScreen();
            }
        });

        addNewEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction(nameText.getText(), incomeText.getText(), descriptionText.getText());
                refreshList();
                clearTexts();
            }
        });

        fileOptionsMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = temp + 1;
                filePanel.setVisible(temp % 2 != 0);
            }
        });

        clearTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    clearTexts();
            }
        });

        updateEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int transNum = transactionList.getSelectedIndex();
                if (transNum >= 0) {
                    Transaction t = transactions.get(transNum);
                    revenue = revenue - t.getRevenue();
                    t.setName(nameText.getText());
                    t.setRevenue(Double.parseDouble(incomeText.getText()));
                    t.setDescription(descriptionText.getText());
                    revenue = revenue + t.getRevenue();
                    refreshList();
                }
            }
        });

        transactionList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int transNum = transactionList.getSelectedIndex();
                if (transNum >= 0) {
                    Transaction t = transactions.get(transNum);
                    nameText.setText(t.getName());
                    incomeText.setText(Double.toString(t.getRevenue()));
                    descriptionText.setText(t.getDescription());

                    updateEventButton.setEnabled(true);
                    clearTransactionButton.setEnabled(true);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String temp = searchBar.getText();
                for (Transaction t : transactions)
                    if(t.getName().equals(temp)) {
                        nameText.setText(t.getName());
                        incomeText.setText(Double.toString(t.getRevenue()));
                        descriptionText.setText(t.getDescription());
                    }
            }
        });

        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transaction[] a = new Transaction[transactions.size()];
                transactions.toArray(a);
                writeinfile(a);
            }
        });

        loadFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    split(readFile());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                refreshList();
            }
        });
    }

    public void refreshList() {
        listtransactionsModel.removeAllElements();
        for (Transaction p : transactions) {
            listtransactionsModel.addElement(p.getName());
        }
    }

    public void addTransaction(String Name, String Revenue, String Description) {
        Transaction g = new Transaction(Name, Double.parseDouble(Revenue), Description);
        this.revenue = revenue + g.getRevenue();
        incomeLabel.setText(Double.toString(revenue));
        transactions.add(g);
    }

    public void clearTexts() {
        nameText.setText(" ");
        incomeText.setText("");
        descriptionText.setText(" ");
    }

    public static Transaction[] transacSort (Transaction[] arr) {
        int Temp = 0;
        Transaction Temp2;
        for (int i = 0; i < arr.length - 1 ; i++ ){
            Temp = i;
            for ( int j = i+1; j< arr.length; j++){
                if (arr[j].getName().compareTo(arr[Temp].getName()) < 0 )
                    Temp = j;
            }
            Temp2 = arr[Temp];
            arr[Temp] = arr[i];
            arr[i] = Temp2;
        }
        return arr;
    }

    public int searchTransaction(Transaction[] a, String key) {

        int left = 0;
        int right = a.length;
        int result = -1;

        while( left <= right){
            int midpoint = (left + right)/2;
            if (a[midpoint].getName().equals(key))
                result = midpoint;
            else if (a[midpoint].getName().compareTo(key) <0)
                left = midpoint +1;
            else
                right = midpoint -1;
        }
        return result;
    }

    public void writeinfile(Transaction[] a) {

        FileWriter fw = null;
        try {
            fw = new FileWriter("TransactionLog.txt", true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            for (Transaction transaction : a)
                if (fw != null) {
                    fw.write(transaction.getName() + "," + Double.toString(transaction.getRevenue()) + "," + transaction.getDescription());
                }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            if (fw != null) {
                fw.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String[] readFile() throws IOException {

        List<String> transList
                = new ArrayList<String>();

        BufferedReader bf = new BufferedReader(
                new FileReader("TransactionLog.txt"));

        String line = bf.readLine();

        while (line != null) {
            transList.add(line);
            line = bf.readLine();
        }

        bf.close();
      return transList.toArray(new String[0]);
    }

    public void split(String[] students) {
        String line;
        int i;
        for ( i = 0; i < students.length; i++) {
            line = students[i];
            String[] myList = line.split(",");
            addTransaction(myList[0], myList[1], " ");
        }
    }

    public void CloseScreen () {
        this.setVisible(false);
    }
}