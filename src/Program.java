import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.lang.Cloneable;
import java.util.Objects;
//Beware of static members at deserialization process
/*
* Cloneable interface is for later use to send a copy of Program object not the object itself
* Serializable interface is for storing objects as byte code in files after the program closes
*/
public class Program implements Serializable,Cloneable
{
    //Static Fields,Methods
     static int ProgramCount=0;
    public static int getCount() {
        return Program.ProgramCount;
    }
    public static void setCount(int n) {
         Program.ProgramCount=n;
    }


    //Fields
    private int programID;//Starting from 1
    private String name;
    private String description;
    private Date start_Date;
    private Date end_Date;
    private float budget;
    private int VolCount;

    //Constructor
    // No-argument constructor for the deserialization process
    public Program()
    {
    }
    public Program(String name, String description, Date start_Date, Date end_Date, Number budget) {
        this.programID = ++Program.ProgramCount;
        this.name = name;
        this.description = description;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
        this.budget = budget.floatValue();
    }


    //Getters
    public int getProgramID() {
        return programID;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Date getStart_Date() {
        return (Date)start_Date.clone() ;
    }
    public Date getEnd_Date() {
        return (Date)end_Date.clone();
    }
    public float getBudget() {
        return budget;
    }
    public int getVolCount() {
        return VolCount;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }
    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }
    public void setBudget(Number budget) {
        this.budget = (float)budget;
    }
    public void incrementVolCount() {
        VolCount++;
    }

    //Override toString, equals, hashCode

    @Override
    public String toString() {
        return "Program{" +
                "programID=" + programID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start_Date=" + start_Date +
                ", end_Date=" + end_Date +
                ", budget=" + budget +
                ", VolCount=" + VolCount +
                '}'+'\n';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Program program = (Program) o;
        return getProgramID() == program.getProgramID() && Float.compare(getBudget(), program.getBudget()) == 0 && getVolCount() == program.getVolCount() && Objects.equals(getName(), program.getName()) && Objects.equals(getDescription(), program.getDescription()) && Objects.equals(getStart_Date(), program.getStart_Date()) && Objects.equals(getEnd_Date(), program.getEnd_Date());
    }
    @Override
    public int hashCode() {
        int result = getProgramID();
        result = 31 * result + Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getDescription());
        result = 31 * result + Objects.hashCode(getStart_Date());
        result = 31 * result + Objects.hashCode(getEnd_Date());
        result = 31 * result + Float.hashCode(getBudget());
        result = 31 * result + getVolCount();
        return result;
    }

    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        in.defaultReadObject();
        Program.ProgramCount++;
        this.VolCount=0;
    }
}
