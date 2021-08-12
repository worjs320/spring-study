package net.madvirus.spring4.chap09.jgkim;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Data
public class JsonPersonTemplate {
	@JsonProperty("annotationPersonList")
	private final List<PersonTemplate> personList;
}
