package net.madvirus.spring4.chap04;

import java.io.IOException;
import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForMessage {

	public static void main(String[] args) throws IOException {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:message-config.xml");

		System.out.println(ctx.getMessage("hello", null, Locale.getDefault()));
		System.out.println(ctx.getMessage("welcome", new String[] { "최범균" }, Locale.getDefault()));

		System.out.println(ctx.getMessage("hello", null, Locale.ENGLISH));
		System.out.println(ctx.getMessage("welcome", new String[] { "madvirus" }, Locale.ENGLISH));

		System.out.println(ctx.getMessage("jgkim", null, Locale.ENGLISH));
		System.out.println(ctx.getMessage("jgkimArgs", new String[] { "barak", "stop" }, Locale.ENGLISH));

		System.out.println(ctx.getMessage("jgkim", null, Locale.getDefault()));
		System.out.println(ctx.getMessage("jgkimArgs", new String[] { "jgkim", "발악", "그만" }, Locale.getDefault()));

		ctx.close();
	}
}
