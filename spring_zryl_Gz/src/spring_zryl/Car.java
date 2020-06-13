package spring_zryl;


public class Car { 
	  private String name;//车名 
	  private String color;//颜色 
	  private String clas;//等级 
	    
	  public Car(String name, String color, String clas) { 
	    super(); 
	    this.name = name; 
	    this.color = color; 
	    this.clas = clas; 
	  }
	  
	  public Car() { 
	    super(); 
	    // TODO Auto-generated constructor stub 
	  } 
	  @Override
	  public String toString() { 
	    return "Car [name=" + name + ", color=" + color + ", clas=" + clas 
	        + "]"; 
	  } 
	    
	} 