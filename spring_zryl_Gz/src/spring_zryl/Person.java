package spring_zryl;

public class Person { 
	  private String name;//名字 
	  private int age;//年龄 
	  private Car car;//他的车 
	    
	  public Person(String name, int age, Car car) { 
	    super(); 
	    this.name = name; 
	    this.age = age; 
	    this.car = car; 
	  } 
	  public Person() { 
	    super(); 
	    // TODO Auto-generated constructor stub 
	  } 
	  @Override
	  public String toString() { 
	    return "Person [name=" + name + ", age=" + age + ", car=" + car + "]"; 
	  } 
	    
	} 