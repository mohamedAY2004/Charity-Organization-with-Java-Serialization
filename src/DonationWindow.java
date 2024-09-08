import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DonationWindow implements ActionListener {
    JFrame frame;
    JButton AddDonation;
    JButton DisplayDonations;
    JButton Back;
    JTextArea ff;

    DonationWindow() {
        frame = new JFrame("Donations Window");
        ff = new JTextArea();
        ff.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(ff);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        AddDonation = new JButton("Add Donations");
        AddDonation.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        AddDonation.addActionListener(this);
        AddDonation.setFocusable(false);

        DisplayDonations = new JButton("Display Donations");
        DisplayDonations.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        DisplayDonations.addActionListener(this);
        DisplayDonations.setFocusable(false);

        Back = new JButton("Back");
        Back.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        Back.addActionListener(this);
        Back.setFocusable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 500); // Adjust frame size
        frame.setLayout(new BorderLayout()); // Use BorderLayout for better control over component positioning

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // Create panel for buttons
        buttonPanel.add(AddDonation);
        buttonPanel.add(DisplayDonations);
        buttonPanel.add(Back);

        frame.add(buttonPanel, BorderLayout.WEST); // Add buttons to the left side of the frame
        frame.add(scrollPane, BorderLayout.CENTER); // Add scroll pane to the center

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== this.AddDonation)
        {
            frame.dispose();
            new DonationInsertionWindow();
        } else if (e.getSource()== this.DisplayDonations)
        {
            DisplayDonations.setEnabled(false);
            Organiztion tmp=new Organiztion("tmp","tmp");
            try {
                Main.loadDonors(tmp);
                Main.loadDonations(tmp);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            ff.append(tmp.getDonations().toString()+"Total Collected Donations: "+Donation.TotalDonation);
        } else if (e.getSource()== this.Back)
        {
            frame.dispose();
            new LaunchPage();
        }
    }
}
