import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

public class DonorInsertionWindow extends JFrame {

    private JComboBox<Integer> dayComboBox;
    private JComboBox<Integer> monthComboBox;
    private JComboBox<Integer> yearComboBox;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField email1Field;
    private JTextField email2Field;
    private JTextField nationalityField;;
    public DonorInsertionWindow() {
        setTitle("Donor Insertion Window");
        setSize(1400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel birthDateLabel = new JLabel("Birth Date:");
        panel.add(birthDateLabel, gbc);

        gbc.gridy++;
        dayComboBox = new JComboBox<>(getDays());
        monthComboBox = new JComboBox<>(getMonths());
        yearComboBox = new JComboBox<>(getYears());
        JPanel birthDatePanel = new JPanel();
        birthDatePanel.add(dayComboBox);
        birthDatePanel.add(new JLabel("/"));
        birthDatePanel.add(monthComboBox);
        birthDatePanel.add(new JLabel("/"));
        birthDatePanel.add(yearComboBox);
        panel.add(birthDatePanel, gbc);

        gbc.gridy++;
        JLabel nameLabel = new JLabel("Name:");
        panel.add(nameLabel, gbc);

        gbc.gridy++;
        nameField = new JTextField(20);
        panel.add(nameField, gbc);

        gbc.gridy++;
        JLabel phoneLabel = new JLabel("Phone:");
        panel.add(phoneLabel, gbc);

        gbc.gridy++;
        phoneField = new JTextField(20);
        panel.add(phoneField, gbc);

        gbc.gridy++;
        JLabel email1Label = new JLabel("Email 1:");
        panel.add(email1Label, gbc);

        gbc.gridy++;
        email1Field = new JTextField(20);
        panel.add(email1Field, gbc);

        gbc.gridy++;
        JLabel email2Label = new JLabel("Email 2:");
        panel.add(email2Label, gbc);

        gbc.gridy++;
        email2Field = new JTextField(20);
        panel.add(email2Field, gbc);

        gbc.gridy++;
        JLabel nationalityLabel = new JLabel("Nationality:");
        panel.add(nationalityLabel, gbc);

        gbc.gridy++;
        nationalityField = new JTextField(20);
        panel.add(nationalityField, gbc);

        gbc.gridy++;
        JButton submitButton = new JButton("Submit");
        submitButton.setFocusable(false);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle submission here
                int day = (int) dayComboBox.getSelectedItem();
                int month = (int) monthComboBox.getSelectedItem();
                int year = (int) yearComboBox.getSelectedItem();
                String name = nameField.getText();
                String phone = phoneField.getText();
                String email1 = email1Field.getText();
                email1=(email1.equals("")?null:email1);
                String email2 = email2Field.getText();
                email2=(email2.equals("")?null:email2);
                String nationality = nationalityField.getText();
                nameField.setText("");
                phoneField.setText("");
                email1Field.setText("");
                email2Field.setText("");
                nationalityField.setText("");

                // Create a new Staff object using the provided data and add it to the file using dummy organization objects
                Organiztion dummy=new Organiztion(null,null);
                try {
                    Main.loadDonors(dummy);
                    Main.loadDonations(dummy);
                    Donor newDonor = new Donor(new Date(year-1900 , month-1, day), name, phone, email1, email2, nationality);
                    dummy.addDonor(newDonor);
                    Main.WriteDonors(dummy);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel.add(new JLabel());
        panel.add(submitButton);

        gbc.gridy++;
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                new DonorWindow(); // Open the staff window
            }
        });
        panel.add(backButton, gbc);


        add(panel);
        setVisible(true);
    }

    private Integer[] getDays() {
        Integer[] days = new Integer[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = i;
        }
        return days;
    }

    private Integer[] getMonths() {
        Integer[] months = new Integer[12];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = i;
        }
        return months;
    }

    private Integer[] getYears() {
        Integer[] years = new Integer[100];
        int currentYear = java.time.Year.now().getValue();
        for (int i = 0; i < 100; i++) {
            years[i] = currentYear - i;
        }
        return years;
    }

}
