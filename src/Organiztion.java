import java.util.ArrayList;
import java.util.Objects;

public class Organiztion
{
    //Fields
    private String name;
    private String location;
    private ArrayList<Program> programs;
    private ArrayList<Donor> donors;
    private ArrayList<Staff> staff;
    private ArrayList<Volunteer> volunteers;
    private ArrayList<Volunteering> volunteerings;
    private ArrayList<Donation> donations;


    //Constructor
    // No-argument constructor for the deserialization process
    public Organiztion(String name,String location)
    {
        this.name=name;
        this.location=location;
        programs=new ArrayList<Program>();
        staff=new ArrayList<Staff>();
        donors=new ArrayList<Donor>();
        volunteers=new ArrayList<Volunteer>();
        donations=new ArrayList<Donation>();
        volunteerings=new ArrayList<Volunteering>();
    }



    //Methods
    public boolean addProgram(Program p)
    {
        return programs.add(p);
    }
    public boolean addStaff(Staff s)
    {
        return staff.add(s);
    }
    public boolean addDonor(Donor d)
    {
        return donors.add(d);
    }
    public boolean addVolunteer(Volunteer v)
    {
        return volunteers.add(v);
    }
    public boolean addDonation(Donation d) {
        donors.get(d.getDonorID()-1).addTotalDonation(d.getAmmount());
        Donation.addToTotalDonation(d.getAmmount());
        return donations.add(d);
    }
    public boolean addVolunteering(Volunteering v) {
        volunteers.get(v.getVolunteerID()-1).incrementVolCount();
        programs.get(v.getProgramID()-1).incrementVolCount();
        return volunteerings.add(v);
    }



    //Getters
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public ArrayList<Program> getPrograms() {
        return programs;
    }
    public ArrayList<Donor> getDonors() {
        return donors;
    }
    public ArrayList<Staff> getStaff() {
        return staff;
    }
    public ArrayList<Volunteer> getVolunteers() {
        return volunteers;
    }
    public ArrayList<Donation> getDonations() {
        return donations;
    }
    public ArrayList<Volunteering> getVolunteerings() {
        return volunteerings;
    }


    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Organiztion{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", programs=" + programs +
                ", donors=" + donors +
                ", staff=" + staff +
                ", volunteers=" + volunteers +
                ", volunteerings=" + volunteerings +
                ", donations=" + donations +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organiztion that = (Organiztion) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getLocation(), that.getLocation()) && Objects.equals(getPrograms(), that.getPrograms()) && Objects.equals(getDonors(), that.getDonors()) && Objects.equals(getStaff(), that.getStaff()) && Objects.equals(getVolunteers(), that.getVolunteers()) && Objects.equals(volunteerings, that.volunteerings) && Objects.equals(getDonations(), that.getDonations());
    }
    @Override
    public int hashCode() {
        int result = Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getLocation());
        result = 31 * result + Objects.hashCode(getPrograms());
        result = 31 * result + Objects.hashCode(getDonors());
        result = 31 * result + Objects.hashCode(getStaff());
        result = 31 * result + Objects.hashCode(getVolunteers());
        result = 31 * result + Objects.hashCode(volunteerings);
        result = 31 * result + Objects.hashCode(getDonations());
        return result;
    }
}
