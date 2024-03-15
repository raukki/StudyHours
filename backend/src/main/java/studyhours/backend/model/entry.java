package studyhours.backend.model;

import java.util.Locale.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class entry {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String entrydate, course;
    private double hours;

    //person who records hours as separate class
    @ManyToOne
    @JoinColumn(name="personId")
    private Category person;

    public entry(){}

    public entry(String entrydate, String course, double hours) {
        this.entrydate = entrydate;
        this.course = course;
        this.hours = hours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(String entrydate) {
        this.entrydate = entrydate;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public Category getPerson() {
        return person;
    }

    public void setPerson(Category person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "entry [entrydate=" + entrydate + ", course=" + course + ", hours=" + hours + ", person=" + this.Getperson() + "]";
    }
}




