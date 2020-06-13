package Factory;

public class FactoryTest {  
	  
    public static void main(String[] args) {  
        // 简单工厂模式测试  
        SimpleFactory simpleFactory = new SimpleFactory();  
        Broom broom = (Broom) simpleFactory.create(Broom.class);  
        broom.run();  
    }  
}  s