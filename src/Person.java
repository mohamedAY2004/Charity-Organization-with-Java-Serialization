import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
public abstract class Person implements Serializable,Cloneable
{
    //Fields
    private Date birthDate;
    private  String name;
    private String phone;
    private String email1;
    private String email2;
    private String nationality;

    //Constructor
    // No-argument constructor for the deserialization process
    public  Person()
    {
    }
    public Person(Date birthDate, String name, String phone, String email1, String email2, String nationality)
    {
        this.birthDate = birthDate;
        this.name = name;
        this.phone = phone;
        this.email1 = email1;
        this.email2 = email2;
        this.nationality = nationality;
    }

    //Getters
    public Date getBirthDate() {
        return (Date)birthDate.clone();
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail1() {
        return email1;
    }
    public String getEmail2() {
        return email2;
    }
    public String getNationality() {
        return nationality;
    }

    //Setters
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail1(String email1) {
        this.email1 = email1;
    }
    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    //Override toString, equals, hashCode
    @Override
    public String toString() {
        return "Person{" +
                "birthDate=" + birthDate +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.hashCode()==person.hashCode();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getBirthDate(), getName(), getPhone(), getEmail1(), getEmail2(), getNationality());
    }
}
