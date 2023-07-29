package hb02.embeddable;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//or
import javax.persistence.*;

@Entity
@Table(name = "t_student02")
public class Student02 {
    @Id
    private int id;
    @Column(name="student_name",length = 100, unique = false, nullable = false)
    private String name;

    private int grade;

    @Embedded // in the student class you want to use @Embedded we want to be able to use the class Address in this Table
    // so we use embedded in this class we are creating the table with.
    // We are going to use @Embeddable in the Address class because that annotation makes the class embeddable.
    // Embedded is where you are going to embed the class in the table.
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +
                '}';
    }
}
