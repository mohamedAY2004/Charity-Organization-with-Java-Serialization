import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
public class Volunteering implements Serializable
{
    //Static Fields Methods
     static int volunteeringCount=0;
    public static int getVolunteeringCount()
    {
        return Volunteering.volunteeringCount;
    }
    public static void setVolunteeringCount(int n)
    {
         Volunteering.volunteeringCount=n;
    }


    //Fields
    private int volunteeringID;//Starting from 1
    private String activity;
    private int hours;
    private Date date;
    private int volunteerID;
    private int ProgramID;

    //Constructor
    // No-argument constructor for the deserialization process
    public Volunteering()
    {

    }
    public Volunteering(String activity, int hours, Date date,int volunteerID,int ProgramID) {
        this.activity = activity;
        this.hours = hours;
        this.date = date;
        this.volunteeringID=++Volunteering.volunteeringCount;
        this.volunteerID=volunteerID;
        this.ProgramID=ProgramID;
    }


    //Getters
    public int getVolunteeringID() {
        return this.volunteeringID;
    }
    public String getActivity() {
        return this.activity;
    }
    public int getHours() {
        return this.hours;
    }
    public Date getDate() {
        return (Date)this.date.clone();
    }
    public int getVolunteerID() {
        return volunteerID;
    }
    public int getProgramID() {
        return ProgramID;
    }

    //Setters
    public void setActivity(String activity) {
        this.activity = activity;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setVolunteerID(int volunteerID) {
        this.volunteerID = volunteerID;
    }
    public void setProgramID(int programID) {
        ProgramID = programID;
    }


    //Override toString, equals, hashCode
    @Override
    public String toString() {
        return "Volunteering{" +
                "volunteeringID=" + volunteeringID +
                ", activity='" + activity + '\'' +
                ", hours=" + hours +
                ", date=" + date +
                ", volunteerID=" + volunteerID +
                ", ProgramID=" + ProgramID +
                '}'+'\n';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Volunteering that = (Volunteering) o;
        return getVolunteeringID() == that.getVolunteeringID() && getHours() == that.getHours() && getVolunteerID() == that.getVolunteerID() && getProgramID() == that.getProgramID() && Objects.equals(getActivity(), that.getActivity()) && Objects.equals(getDate(), that.getDate());
    }
    @Override
    public int hashCode() {
        int result = getVolunteeringID();
        result = 31 * result + Objects.hashCode(getActivity());
        result = 31 * result + getHours();
        result = 31 * result + Objects.hashCode(getDate());
        result = 31 * result + getVolunteerID();
        result = 31 * result + getProgramID();
        return result;
    }
    //Deserizalization Method
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        in.defaultReadObject();
        Volunteering.volunteeringCount++;
    }
}
