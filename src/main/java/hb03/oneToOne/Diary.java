package hb03.oneToOne;

import javax.persistence.*;

@Entity
@Table(name="t_diary")
public class Diary {
    @Id
    private int id;

    private String name;

    @OneToOne // student_id

    @JoinColumn(name="std_id") // this means if you want to change "student_id" in your database
    private Student03 student; // this allows access to students class through Diary class... but not vice versa
    // we would need to do this same code for student03 if we want to be able to get diary through student03
    // private Diary diary; with the annotations... in the student03 class
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

    public Student03 getStudent03() {
        return student;
    }

    public void setStudent03(Student03 student03) {
        this.student = student03;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student03=" + student +
                '}';
    }
}
