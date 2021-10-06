package net.madvirus.spring4.chap14.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PERSON")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {
    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "PERSON_ID")
    private List<Phone> phone;

    @NonNull
    @Column(name = "NAME")
    private String name;

    @NonNull
    @Column(name = "GENDER")
    private String gender;

    @NonNull
    @Column(name = "EMAIL")
    private String email;

    @NonNull
    @Column(name = "BIRTHDAY")
    private Date BIRTHDAY;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", phone=" + phone +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", BIRTHDAY=" + BIRTHDAY +
                '}';
    }
}
