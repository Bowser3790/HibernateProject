package hb03.oneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_student03")
public class Student03 {
    @Id
    private int id;

    @Column(name="student_name",length = 100,unique = false, nullable = false)
    private String name;

    private int grade;

    //@OneToOne(mappedBy = "student")// this will not create table it will allow diary class to pull column from Student03 Class.
    // this means in my Diary Table a new column to be added with default name "student_id"
    // @OneToOne(mappedBy="student") ==> mappedBy will not create any column in dairy class
    // instead, it will use the column from diary class which is named a s "student"
    // note that mappedBy is a OneToOne Bi-Directional ***** mapping ****
    // "student" will not be column name this will show on the query when you sys.out.print()...

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

    @Override
    public String toString() {
        return "Student03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
