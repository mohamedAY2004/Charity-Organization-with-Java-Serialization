import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        IDandPasswords info=new IDandPasswords();
        new LoginPage(info.getloginInfo());
//
//          new LaunchPage();
//        Organiztion org=new Organiztion("AAST Chairity","Sheraton");90;
//        loadAll(org);
//        Writeall(org);
//        System.out.println("All Info Saved Congrats");
    }
    //Start methods
    public static void loadAll(Organiztion o) throws IOException, ClassNotFoundException {
        loadPrograms(o);
        loadDonors(o);
        loadDonations(o);
        loadVolunteers(o);
        loadStaff(o);
        loadVolunteerings(o);
        System.out.println("EveryThing Loaded Successfully");
    }
    public  static void loadDonors(Organiztion org) throws IOException, ClassNotFoundException {
       Donor.DonorCount=0;
        FileInputStream filein=new FileInputStream("donor.ser");
        ObjectInputStream in = new ObjectInputStream(filein);
        while (true){
            try{
                org.addDonor((Donor) in.readObject());
            }catch (EOFException e)
            {
                break;
            }
        }
        filein.close();
        in.close();
    }
    public  static void loadStaff(Organiztion org) throws IOException, ClassNotFoundException {
        Staff.StaffCount=0;
        FileInputStream filein=new FileInputStream("staff.ser");
        ObjectInputStream in = new ObjectInputStream(filein);
        while (true){
            try{
                org.addStaff((Staff) in.readObject());
            }catch (EOFException e)
            {
                break;
            }
        }
        filein.close();
        in.close();
    }
    public  static void loadVolunteers(Organiztion org) throws IOException, ClassNotFoundException {
        Volunteer.VolunteerCount=0;
        FileInputStream filein=new FileInputStream("volunteer.ser");
        ObjectInputStream in = new ObjectInputStream(filein);
        while (true){
            try{
                org.addVolunteer((Volunteer) in.readObject());
            }catch (EOFException e)
            {
                break;
            }
        }
        filein.close();
        in.close();
    }
    public  static void loadPrograms(Organiztion org) throws IOException, ClassNotFoundException {
        Program.ProgramCount=0;
        FileInputStream filein=new FileInputStream("Program.ser");
        ObjectInputStream in = new ObjectInputStream(filein);
        while (true){
            try{
                org.addProgram((Program) in.readObject());
            }catch (EOFException e)
            {
                break;
            }
        }
        filein.close();
        in.close();
    }
    public  static void loadDonations(Organiztion org) throws IOException, ClassNotFoundException {
        Donation.DonationsCount=0;
        Donation.TotalDonation=0;
        FileInputStream filein=new FileInputStream("donations.ser");
        ObjectInputStream in = new ObjectInputStream(filein);
        while (true){
            try{
                org.addDonation((Donation) in.readObject());
            }catch (EOFException e)
            {
                break;
            }
        }
        filein.close();
        in.close();
    }
    public  static void loadVolunteerings(Organiztion org) throws IOException, ClassNotFoundException {
        Volunteering.volunteeringCount=0;
        FileInputStream filein=new FileInputStream("volunteerings.ser");
        ObjectInputStream in = new ObjectInputStream(filein);
        while (true){
            try{
                org.addVolunteering((Volunteering) in.readObject());
            }catch (EOFException e)
            {
                break;
            }
        }
        filein.close();
        in.close();
    }


    
    //End method
    public static void Writeall(Organiztion o) throws IOException {
        WritePrograms(o);
        WriteStaff(o);
        WriteDonors(o);
        WriteVolunteers(o);
        WriteDonations(o);
        WriteVolunteerings(o);
    }
    public static void WriteDonors(Organiztion o) throws IOException {
        FileOutputStream fout=new FileOutputStream("donor.ser");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        o.getDonors().forEach((x)-> {
            try {
                 out.writeObject(x);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        fout.close();
        out.close();
    }
    public static void WriteStaff(Organiztion o) throws IOException {
        FileOutputStream fout=new FileOutputStream("staff.ser");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        o.getStaff().forEach((x)-> {
            try {
                out.writeObject(x);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        fout.close();
        out.close();
    }
    public static void WriteVolunteers(Organiztion o) throws IOException {
        FileOutputStream fout=new FileOutputStream("volunteer.ser");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        o.getVolunteers().forEach((x)-> {
            try {
                out.writeObject(x);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        fout.close();
        out.close();
    }
    public static void WritePrograms(Organiztion o) throws IOException {
        FileOutputStream fout=new FileOutputStream("Program.ser");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        o.getPrograms().forEach((x)-> {
            try {
                out.writeObject(x);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        fout.close();
        out.close();
    }
    public static void WriteDonations(Organiztion o) throws IOException {
        FileOutputStream fout=new FileOutputStream("donations.ser");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        o.getDonations().forEach((x)-> {
            try {
                    out.writeObject(x);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        fout.close();
        out.close();
    }
    public static void WriteVolunteerings(Organiztion o) throws IOException {
        FileOutputStream fout=new FileOutputStream("volunteerings.ser");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        o.getVolunteerings().forEach((x)-> {
            try {
                out.writeObject(x);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        fout.close();
        out.close();
    }


    //used mostly methods
    public static int parseID(String ID)
    {
        int end=0;
        for (int i=0;i<ID.length();i++)
        {
            if(!Character.isDigit((ID.charAt(i))))
            {
                end=i;
                break;
            }

        }
        return Integer.parseInt(ID.substring(0,end));
    }

}
//Used at the beginning of the program
//Program p=new Program("Help Palastinians","Deliver Food for hungry children at Ghaza",new Date(124,5,25),null,125000);
//Volunteer v1=new Volunteer(new Date(104,9,3),"Mohamed Younes","+201112273329","mido.yones1@gmail.com",null,"Egyptian");
//Volunteer v2=new Volunteer(new Date(108,9,3),"Ahmed Fouad","+201112345329","AhemdFou123.yones1@gmail.com",null,"Egyptian");
//Volunteer v3=new Volunteer(new Date(102,9,3),"Galal Elsayed","+201112343429","Galal.yones1@gmail.com","Gallllooool@gmail.com","American");
//Volunteer v4=new Volunteer(new Date(73,9,3),"Yahia Elhawy","+201113452349","Yaya73@gmail.com",null,"Egyptian");
//Volunteering vv1=new Volunteering("Food Distribution",9,new Date(),1,1);
//Volunteering vv2=new Volunteering("Transportation",5,new Date(),2,1);
//Volunteering vv3=new Volunteering("Mangerial",15,new Date(),3,1);
//Volunteering vv4=new Volunteering("Mangerial",15,new Date(),4,1);
//Donor   donor1=new Donor(new Date(90,5,21),"Fahima Maghrabi","+20101010101","Fahima@Gmail.com",null,"Egyptian");
//Donor   donor2=new Donor(new Date(100,5,21),"Hossam Zaki","+201045343401","Hossam@Gmail.com",null,"Egyptian");
//Donor   donor3=new Donor(new Date(76,6,21),"Ahmed Younes","+202323345463","Ahmed123@Gmail.com",null,"Egyptian");
//Donor   donor4=new Donor(new Date(97,1,29),"Jana Ehab","+2011212121212","Jana@Gmail.com",null,"Syrian");
//Donor   donor5=new Donor(new Date(100,5,21),"Mahmoud Talaat","+2012121212434","Tallooot04@Gmail.com",null,"Qenawy");
//Donor   donor6=new Donor(new Date(76,6,21),"Seif Moustafa","+201223813823","Moustafa@Gmail.com",null,"Egyptian");
//Donation dona1=new Donation(57000,new Date(),1);
//Donation dona2=new Donation(128000,new Date(124,4,3),2);
//Donation dona3=new Donation(57000,new Date(),1);
//Donation dona4=new Donation(128000,new Date(124,4,3),3);
//Donation dona5=new Donation(57000,new Date(),1);
//Donation dona6=new Donation(128000,new Date(124,4,3),1);
//        Staff s1 =new Staff(new Date(100,3,14),"Abdelrahman Ehab","+2011223343545","Abdooo23@yahoo.com",null,"Egyptian","Team Leader");
//        Staff s2 =new Staff(new Date(97,4,25),"Moustafa Helmy","+2011234456545","Sasa56@outlook.com",null,"Egyptian","Organizer");
//        Staff s3 =new Staff(new Date(103,7,22),"Ahmed Ezzeldin","+2011223343545","Ezzeldin03@outlook.com",null,"Egyptian","Organizer");
//        Staff s4 =new Staff(new Date(99,5,12),"Mark Zuckerburg","+1943422345432","MarkZuck04@yahoo.com",null,"Canadian","Organizer");
//        Staff s5 =new Staff(new Date(96,5,12),"Mohamed Salah","+19439456432","Hamathalah4@Liverpool.com",null,"Masry","RW");
//        Staff s6 =new Staff(new Date(103,5,12),"Cristiano Ronaldo","+19431923232","Eldon7Suiii@Elnasr.com",null,"Portugal","LW");
//        Staff s7 =new Staff(new Date(103,5,12),"Lionel Messi","+96683434534","MessiElbaba@EssamElshawaly.com",null,"Argentina","CAM");
//Program p2=new Program("Help Senai","Deliver Food for hungry Palestinean at Sena",new Date(124,10,1),null,125000);
//Program p3=new Program("Clean Cairo ","Clean Streets and spread awareness throw advertisement",new Date(124,0,1),null,25000);
//Program p4=new Program("Warm Them","Deliver Blankets to the poor in the Winter",new Date(124,10,25),null,175000);
//Program p5=new Program("Saeed Clean Water","Deliver Clean water to Saeed Vilages",new Date(124,1,25),null,570000);
//        org.addVolunteer(v1);
//        org.addVolunteer(v2);
//        org.addVolunteer(v3);
//        org.addVolunteer(v4);
//        org.addProgram(p);
//        org.addDonor(donor1);
//        org.addDonor(donor2);
//        org.addDonor(donor3);
//        org.addDonor(donor4);
//        org.addDonor(donor5);
//        org.addDonor(donor6);
//        org.addDonation(dona1);
//        org.addDonation(dona2);
//        org.addDonation(dona3);
//        org.addDonation(dona4);
//        org.addDonation(dona5);
//        org.addDonation(dona6);
//        org.addVolunteering(vv1);
//        org.addVolunteering(vv2);
//        org.addVolunteering(vv3);
//        org.addVolunteering(vv4);
//        org.addStaff(s1);
//        org.addStaff(s2);
//        org.addStaff(s3);
//        org.addStaff(s4);
//        org.addStaff(s5);
//        org.addStaff(s6);
//        org.addStaff(s7);
//        org.addProgram(p2);
//        org.addProgram(p3);
//        org.addProgram(p4);
//        org.addProgram(p5);


