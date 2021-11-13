package net.madvirus.spring4.chap15.member.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class YNToBooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String yn) {
        return "Y".equalsIgnoreCase(yn);
    }

}
