import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VolunteeringWindow implements ActionListener {
    JFrame frame;
    JButton AddVolunteering;
    JButton DisplayVolunteering;
    JButton Back;
    JTextArea ff;

    VolunteeringWindow() {
        frame = new JFrame("Volunteering Window");
        ff = new JTextArea();
        ff.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(ff);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        AddVolunteering = new JButton("Add Volunteering");
        AddVolunteering.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        AddVolunteering.addActionListener(this);
        AddVolunteering.setFocusable(false);

        DisplayVolunteering = new JButton("Display Volunteering");
        DisplayVolunteering.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        DisplayVolunteering.addActionListener(this);
        DisplayVolunteering.setFocusable(false);

        Back = new JButton("Back");
        Back.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        Back.addActionListener(this);
        Back.setFocusable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 500); // Adjust frame size
        frame.setLayout(new BorderLayout()); // Use BorderLayout for better control over component positioning

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // Create panel for buttons
        buttonPanel.add(AddVolunteering);
        buttonPanel.add(DisplayVolunteering);
        buttonPanel.add(Back);

        frame.add(buttonPanel, BorderLayout.WEST); // Add buttons to the left side of the frame
        frame.add(scrollPane, BorderLayout.CENTER); // Add scroll pane to the center

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== this.AddVolunteering)
        {

        } else if (e.getSource()== this.DisplayVolunteering)
        {
            DisplayVolunteering.setEnabled(false);
            Organiztion tmp=new Organiztion("tmp","tmp");
            try {
                Main.loadVolunteers(tmp);
                Main.loadPrograms(tmp);
                Main.loadVolunteerings(tmp);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            ff.append(tmp.getVolunteerings().toString());
        } else if (e.getSource()== this.Back)
        {
            frame.dispose();
            new LaunchPage();
        }
    }
}
