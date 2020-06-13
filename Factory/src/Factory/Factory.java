package Factory;

public class Factory {
	 public static Product newInstance() {
	  return new ConcreteProduct();
	 }
	}
	public abstract Product {
	}
	public class ConcreteProduct extends Product {
	 public ConcreteProduct() {}
	}
	