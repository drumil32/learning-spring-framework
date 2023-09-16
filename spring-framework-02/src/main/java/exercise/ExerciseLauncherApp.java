package exercise;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ExerciseLauncherApp {
	public static void main(String args[]) {
		try(var context = new AnnotationConfigApplicationContext(ExerciseLauncherApp.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(bean->System.out.println(bean));
			BusinessCalculationService obj =  context.getBean(BusinessCalculationService.class);
			System.out.println(obj.findMax());
			
		}
		
	}
}
