package net.madvirus.spring4.chap14.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PERSON")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BIRTHDAY")
    private Date BIRTHDAY;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", BIRTHDAY=" + BIRTHDAY +
                '}';
    }
}
