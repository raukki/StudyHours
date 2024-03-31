package studyhours.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

//generate class to database with entity
@Entity
public class person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<entry> entries;

    public person(Long personId, String name, List<entry> entries) {
        this.personId = personId;
        this.name = name;
        this.entries = entries;
    }

    public person() {}

    public person(String name) {
        super();
        this.name = name;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<entry> getEntries() {
        return entries;
    }

    public void setEntries(List<entry> entries) {
        this.entries = entries;
    }


}
