import java.io.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Objects;

//Beware of static members at deserialization process
/*
 * Cloneable interface is for later use to send a copy of Program object not the object itself
 * Serializable interface is for storing objects as byte code in files after the program closes
 */
public class Donor extends Person
{
    //Static Field,Methods
    static int DonorCount=0;
    public static int getCount() {
        return Donor.DonorCount;
    }

    //Fields
     private int donorID;
     private float donortotalDonation =0;

    //Constructor
    // No-argument constructor for the deserialization process
    public Donor()
    {

    }
    public Donor(Date birthDate , String name, String phone, String email1, String email2, String nationality) {
        super(birthDate, name, phone, email1, email2, nationality);
        this.donorID=++Donor.DonorCount;

    }

    //Methods
    public void addTotalDonation(Number n)
    {
        donortotalDonation+=n.floatValue();
    }

    //Getters
    public int getDonorID() {
        return donorID;
    }
    public float getDonortotalDonation() {
        return donortotalDonation;
    }


    //Setters No setters for donor fields only the person inherited fields


    //Override toString, equals, hashCode


    @Override
    public String toString() {
        return super.toString()+
                "Donor{" +
                "donorID=" + donorID +
                '}'+
                "TotalDonation= "+
                getDonortotalDonation()+
                '\n';
    }
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        in.defaultReadObject();
        Donor.DonorCount++;
        this.donortotalDonation=0;
    }
}
