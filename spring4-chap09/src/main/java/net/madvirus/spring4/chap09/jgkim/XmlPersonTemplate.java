package net.madvirus.spring4.chap09.jgkim;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "person-list")
public class XmlPersonTemplate {

    @XmlElement(name = "persons")
    private List<PersonTemplate> persons;
}
