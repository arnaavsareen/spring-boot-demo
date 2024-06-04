package demo.application.hobby;

import jakarta.persistence.*;

@Entity
@Table(name = "hobbies")
public class Hobby {

    @Id
    @SequenceGenerator(
            name = "hobby_sequence",
            sequenceName = "hobby_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hobby_sequence"
    )
    private Long id;
    private String name;

    public Hobby() {
    }

    public Hobby(String name) {
        this.name = name;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Overriding toString to provide a string representation of the Hobby object
    @Override
    public String toString() {
        return "Hobby{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
