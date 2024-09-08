import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
//Beware of static members at deserialization process
/*
 * Cloneable interface is for later use to send a copy of Program object not the object itself
 * Serializable interface is for storing objects as byte code in files after the program closes
 */
public class Volunteer extends Person
{
    //Static Fields,Methods
     static int VolunteerCount=0;
    public static int getCount() {
        return Volunteer.VolunteerCount;
    }
    public static void setCount(int n) {
         Volunteer.VolunteerCount=n;
    }


    //Fields
    private int VolunnterID;//Starting from 1
    private int VolCount;

    //Constructor
    // No-argument constructor for the deserialization process
    public  Volunteer()
    {
    }
    public Volunteer(Date birthDate, String name, String phone, String email1, String email2, String nationality) {
        super(birthDate, name, phone, email1, email2, nationality);
        VolunnterID=++Volunteer.VolunteerCount;
    }


    //Getters
    public int getVolunnterID() {
        return VolunnterID;
    }
    public int getVolCount() {
        return VolCount;
    }

    //Setters
    public void setVolunnterID(int volunnterID) {
        VolunnterID = volunnterID;
    }
    public void incrementVolCount() {
        VolCount++;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Volunteer{" +
                "VolunnterID=" + VolunnterID +
                '}'+
                "Volunteering Count= "+
                getVolCount()+'\n';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Volunteer volunteer = (Volunteer) o;
        return VolunnterID == volunteer.VolunnterID;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + VolunnterID;
        return result;
    }

    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        in.defaultReadObject();
        Volunteer.VolunteerCount++;
        this.VolCount=0;
    }
}
