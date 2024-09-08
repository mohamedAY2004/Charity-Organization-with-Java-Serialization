import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProgramWindow implements ActionListener {
    JFrame frame;
    JButton AddProgram;
    JButton DisplayPrograms;
    JButton Back;
    JTextArea ff;

    ProgramWindow() {
        frame = new JFrame("Programs Window");
        ff = new JTextArea();
        ff.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(ff);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        AddProgram = new JButton("Add Program");
        AddProgram.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        AddProgram.addActionListener(this);
        AddProgram.setFocusable(false);

        DisplayPrograms = new JButton("Display Programs");
        DisplayPrograms.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        DisplayPrograms.addActionListener(this);
        DisplayPrograms.setFocusable(false);

        Back = new JButton("Back");
        Back.setPreferredSize(new Dimension(175, 50)); // Adjust button size
        Back.addActionListener(this);
        Back.setFocusable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 500); // Adjust frame size
        frame.setLayout(new BorderLayout()); // Use BorderLayout for better control over component positioning

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // Create panel for buttons
        buttonPanel.add(AddProgram);
        buttonPanel.add(DisplayPrograms);
        buttonPanel.add(Back);

        frame.add(buttonPanel, BorderLayout.WEST); // Add buttons to the left side of the frame
        frame.add(scrollPane, BorderLayout.CENTER); // Add scroll pane to the center

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== this.AddProgram)
        {

        } else if (e.getSource()== this.DisplayPrograms)
        {
            DisplayPrograms.setEnabled(false);
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
           ff.append(tmp.getPrograms().toString());
        } else if (e.getSource()== this.Back)
        {
            frame.dispose();
            new LaunchPage();
        }
    }
}
