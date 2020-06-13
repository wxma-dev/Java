package spring_zryl;



import org.junit.Test;
import org.springframework.context.ApplicationContext; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 


public class SpringTest{ 
    @Test
    public void toGetPerson(){ 
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
      Person person = (Person) context.getBean("person"); 
      System.out.println(person); 
    } 
    @Test
    public void toGetCar(){ 
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
      Car car = (Car) context.getBean("car"); 
      System.out.println(car); 
    } 
} 