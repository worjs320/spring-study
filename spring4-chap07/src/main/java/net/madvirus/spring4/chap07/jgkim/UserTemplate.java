package net.madvirus.spring4.chap07.jgkim;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
public class UserTemplate {
    @NotEmpty(message = "ID 발악 그만")
    private String id;

    @NotEmpty
    private String password;

    @NotEmpty(message = "NAME 발악 그만")
    private String name;

    @Email
    @NotEmpty
    private String email;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private Integer age;

    @Pattern(regexp = "(?i)jgkim")
    private String jgkim;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date date;
}
