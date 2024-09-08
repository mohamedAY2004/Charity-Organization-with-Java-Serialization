import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener
{
    JFrame frame;
    JButton Donation;
    JButton Donor;
    JButton Program;
    JButton Staff;
    JButton Volunteer;
    JButton Volunteering;
    LaunchPage()
    {
        frame=new JFrame("Main Page");
        Donation =new JButton("Donation");
        Donation.setPreferredSize(new Dimension(510,110));
        Donation.setFocusable(false);
        Donation.addActionListener(this);
        Donor =new JButton("Donor");
        Donor.setPreferredSize(new Dimension(510,110));
        Donor.setFocusable(false);
        Donor.addActionListener(this);
        Program =new JButton("Program");
        Program.setPreferredSize(new Dimension(510,110));
        Program.setFocusable(false);
        Program.addActionListener(this);
        Staff =new JButton("Staff");
        Staff.setPreferredSize(new Dimension(510,110));
        Staff.setFocusable(false);
        Staff.addActionListener(this);
        Volunteer =new JButton("Volunteer");
        Volunteer.setPreferredSize(new Dimension(510,110));
        Volunteer.setFocusable(false);
        Volunteer.addActionListener(this);
        Volunteering =new JButton("Volunteering");
        Volunteering.setPreferredSize(new Dimension(510,110));
        Volunteering.setFocusable(false);
        Volunteering.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1400,600);
        frame.setLayout(new FlowLayout());
        frame.add(Donation);
        frame.add(Donor);
        frame.add(Program);
        frame.add(Staff);
        frame.add(Volunteer);
        frame.add(Volunteering);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.Donation)
        {
            frame.dispose();
            new DonationWindow();
        } else if (e.getSource()== this.Donor)
        {
            frame.dispose();
            new DonorWindow();
        } else if (e.getSource()== this.Program)
        {
            frame.dispose();
            new ProgramWindow();
        } else if (e.getSource()== this.Staff)
        {
         frame.dispose();
            new StaffWindow();
        } else if (e.getSource()== this.Volunteer)
        {
            frame.dispose();
            new VolunteerWindow();
        }else if(e.getSource()== this.Volunteering)
        {
            frame.dispose();
            new VolunteeringWindow();
        }
    }
}
