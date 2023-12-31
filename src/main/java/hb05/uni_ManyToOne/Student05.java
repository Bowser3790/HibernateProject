package hb05.uni_ManyToOne;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="t_student05")
public class Student05 {
    @Id
    private int id;

    @Column(name = "student_name", length = 100, unique = false)
    private String name;

     private int grade;

     private LocalDateTime createdDate;

     @ManyToOne // there are many students to one university
     @JoinColumn(name = "univ_id")
     private University university;

     @PrePersist // when you save this object to DB this method will work // session.save()
    public void prePersist(){
         createdDate = LocalDateTime.now();

     }

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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createdDate=" + createdDate +
                ", university=" + university +
                '}';
    }
}
