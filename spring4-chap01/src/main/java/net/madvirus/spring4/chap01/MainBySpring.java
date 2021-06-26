package net.madvirus.spring4.chap01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainBySpring {

	public static void main(String[] args) {
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(configLocation);
		JgkimProject project = ctx.getBean("sampleJgkimProject", JgkimProject.class);
		project.build();
		ctx.close();
	}
}
