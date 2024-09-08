import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class DonorWindow implements ActionListener {
    JFrame frame;
    JButton AddDonor;
    JButton DisplayDonor;
    JButton Back;
    JTextArea ff;

    DonorWindow() {
        frame = new JFrame("Donor Window");
        ff = new JTextArea();
        ff.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(ff);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        AddDonor = new JButton("Add Donor");
        AddDonor.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        AddDonor.addActionListener(this);
        AddDonor.setFocusable(false);

        DisplayDonor = new JButton("Display Donors");
        DisplayDonor.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        DisplayDonor.addActionListener(this);
        DisplayDonor.setFocusable(false);

        Back = new JButton("Back");
        Back.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        Back.addActionListener(this);
        Back.setFocusable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 500); // Adjust frame size
        frame.setLayout(new BorderLayout()); // Use BorderLayout for better control over component positioning

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // Create panel for buttons
        buttonPanel.add(AddDonor);
        buttonPanel.add(DisplayDonor);
        buttonPanel.add(Back);

        frame.add(buttonPanel, BorderLayout.WEST); // Add buttons to the left side of the frame
        frame.add(scrollPane, BorderLayout.CENTER); // Add scroll pane to the center

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== this.AddDonor)
        {
            frame.dispose();
            new DonorInsertionWindow();

        } else if (e.getSource()== this.DisplayDonor)
        {
            DisplayDonor.setEnabled(false);
            Organiztion tmp=new Organiztion("tmp","tmp");
            try {
                Main.loadDonors(tmp);
                Main.loadDonations(tmp);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            ff.append(tmp.getDonors().toString());
        } else if (e.getSource()== this.Back)
        {
            frame.dispose();
            new LaunchPage();
        }
    }
}
