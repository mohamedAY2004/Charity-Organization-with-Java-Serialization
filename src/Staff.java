import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
/*
 * Cloneable interface is for later use to send a copy of Program object not the object itself
 * Serializable interface is for storing objects as byte code in files after the program closes
 */
public class Staff extends Person
{
    //Static Fields,Methods
     static int StaffCount=0;
    public static int getCount() {
        return Staff.StaffCount;
    }
    public static void setCount(int n) {
         Staff.StaffCount=n;
    }


    //Fields
    private int staffID;//Starting from 1
    private String position;


    //Constructor
    public Staff(Date birthDate, String name, String phone, String email1, String email2, String nationality,String position)
    {
        super(birthDate, name, phone, email1, email2, nationality);
        this.position=position;
        staffID=++Staff.StaffCount;
    }


    //Getters
    public int getStaffID() {
        return staffID;
    }
    public String getPosition() {
        return position;
    }


    //Setters
    public void setPosition(String position) {
        this.position = position;
    }


    //Override toString, equals, hashCode
    @Override
    public String toString() {
        return super.toString()+
                "Staff{" +
                "staffID=" + staffID +
                ", position='" + position + '\'' +
                '}'+'\n';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Staff staff = (Staff) o;
        return this.hashCode()==staff.hashCode();
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getStaffID();
        result = 31 * result + getPosition().hashCode();
        return result;
    }
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        in.defaultReadObject();
        Staff.StaffCount++;
    }
}
