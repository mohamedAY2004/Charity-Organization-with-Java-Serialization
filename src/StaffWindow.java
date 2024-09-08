import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StaffWindow implements ActionListener {
    JFrame frame;
    JButton AddStaff;
    JButton DisplayStaff;
    JButton Back;
    JTextArea ff;

    StaffWindow() {
        frame = new JFrame("Staff Window");
        ff = new JTextArea();
        ff.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(ff);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        AddStaff = new JButton("Add Staff");
        AddStaff.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        AddStaff.addActionListener(this);
        AddStaff.setFocusable(false);

        DisplayStaff = new JButton("Display Staff");
        DisplayStaff.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        DisplayStaff.addActionListener(this);
        DisplayStaff.setFocusable(false);

        Back = new JButton("Back");
        Back.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        Back.addActionListener(this);
        Back.setFocusable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 500); // Adjust frame size
        frame.setLayout(new BorderLayout()); // Use BorderLayout for better control over component positioning

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // Create panel for buttons
        buttonPanel.add(AddStaff);
        buttonPanel.add(DisplayStaff);
        buttonPanel.add(Back);

        frame.add(buttonPanel, BorderLayout.WEST); // Add buttons to the left side of the frame
        frame.add(scrollPane, BorderLayout.CENTER); // Add scroll pane to the center

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== this.AddStaff)
        {
            frame.dispose();
            new StaffInsertionWindow();

        } else if (e.getSource()== this.DisplayStaff)
        {
            DisplayStaff.setEnabled(false);
            Organiztion tmp=new Organiztion("tmp","tmp");
            try {
               Main.loadStaff(tmp);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            ff.append(tmp.getStaff().toString());
        } else if (e.getSource()== this.Back)
        {
            frame.dispose();
            new LaunchPage();
        }
    }
}
