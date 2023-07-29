package hb01.annotation;




import javax.persistence.*;

@Entity // This class will be mapped to a table -> we want to see this in the table
@Table(name="t_student01") // to customize table name
public class Student01 { // default name of table will be "Student01"
    @Id // the field under @Id will be a Primary Key
    private int id;

    @Column(name="std_name", length = 100, nullable = false, unique = false)// by default column will be column_name, to save money and space you can set length of column, by default it is 255 char.
    // unique = if someones name is the same it will not give error-> vice versa for true. -> false is default
    // nullable = will not give error if field is null vice versa -> false is default
    private String name;
    // @transient // this field will not be added to the table.
    private int grade;

    // @embeddable means that we want to be able to use the information from this data but we do not want to create a table from it.
    // can be use the information as a column in the existing dataBase but we do not want to create a separate table.

    // @Lob // large object
    //private byte [] image;


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
}
