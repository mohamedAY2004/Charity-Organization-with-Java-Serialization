import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

//Beware of static members at deserialization process
/*
 * Cloneable interface is for later use to send a copy of Program object not the object itself
 * Serializable interface is for storing objects as byte code in files after the program closes
 */
public class Donation implements Serializable,Cloneable
{
    //Static Field,Methods
     static int DonationsCount=0;//Used to assign Id for the donations
     static int TotalDonation=0;// All the income from donations
    public static int getCount() {
        return Donation.DonationsCount;
    }
    public static  int getTotalDonation() {
        return Donation.TotalDonation;
    }
    public static void addToTotalDonation(Number n) {
        Donation.TotalDonation+=n.intValue();
        DonationsCount++;
    }


    //Fields
    private int donationID;//Starting from 1
    private float ammount;
    private Date donationDate;
    private int donorID;

    //Constructor
    public Donation(Number ammount,Date donationDate,int donorID)
    {
        this.ammount = ammount.floatValue();
        this.donationDate=donationDate;
        this.donationID=++Donation.DonationsCount;
        this.donorID=donorID;
    }
    //Getters
    public int getDonationID() {
        return donationID;
    }
    public float getAmmount() {
        return ammount;
    }
    private Date getDonationDate()
    {
        if(donationDate==null) return null;
        return (Date)this.donationDate.clone();
    }
    public int getDonorID() {
        return donorID;
    }

    //Setters
    public void setAmmount(Number ammount) {
        this.ammount = ammount.floatValue();
    }
    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }



    //Override toString, equals, hashCode
    @Override
    public String toString() {
        return "Donation{" +
                "donationID=" + donationID +
                ", ammount=" + ammount +
                ", donationDate=" + donationDate +
                ", donorID=" + donorID +
                '}'+'\n';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Donation donation = (Donation) o;
        return getDonationID() == donation.getDonationID() && Float.compare(getAmmount(), donation.getAmmount()) == 0 && Objects.equals(getDonationDate(), donation.getDonationDate());
    }
    @Override
    public int hashCode() {
        int result = getDonationID();
        result = 31 * result + Float.hashCode(getAmmount());
        result = 31 * result + Objects.hashCode(getDonationDate());
        return result;
    }
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        in.defaultReadObject();
    }
}
