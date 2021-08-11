package net.madvirus.spring4.chap09.jgkim;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Data
public class JsonPersonTemplate {
	private final List<PersonTemplate> personList;
}
