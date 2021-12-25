package guide.helloworld;

import org.springframework.beans.factory.annotation.Required;

public class HelloWorldServiceImpl implements HelloWorldService {

	private String name;
	
	@Required
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hello, " + name + "!!";
	}
}
