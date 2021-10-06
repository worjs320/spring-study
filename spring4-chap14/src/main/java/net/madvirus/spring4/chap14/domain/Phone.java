package net.madvirus.spring4.chap14.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PHONE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    @Id
    @Column(name = "PERSON_ID")
    private String personId;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Override
    public String toString() {
        return "Phone{" +
                "personId='" + personId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
