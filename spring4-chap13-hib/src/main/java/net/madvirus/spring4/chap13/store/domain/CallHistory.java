package net.madvirus.spring4.chap13.store.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CALL_HISTORY")
public class CallHistory {
    @Id
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CALL_DATE")
    private LocalDate callDate;

    public CallHistory() {

    }

    public CallHistory(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.callDate = LocalDate.now();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCallDate() {
        return callDate;
    }

    public void setCallDate(LocalDate callDate) {
        this.callDate = callDate;
    }
}
