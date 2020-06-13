package spring_zryl;


public class Car { 
	private String name;//车名 
	private String color;//颜色 
	private String clas;//等级 

	public String getName() { 
		return name; 
	} 
		
	public void setName(String name) { 
		this.name = name; 
	} 
	public String getColor() { 
		return color; 
	} 
	public void setColor(String color) { 
		this.color = color; 
	} 
	public String getClas() { 
		return clas; 
	} 
	public void setClas(String clas) { 
		this.clas = clas; 
	} 
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
		return "Car [name=" + name + ", color=" + color + ", clas=" + clas + "]"; 
	} 
}