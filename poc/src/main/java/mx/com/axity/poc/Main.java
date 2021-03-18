package mx.com.axity.poc;

import mx.com.axity.poc.controller.Controller;
import mx.com.axity.poc.to.Data;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		Data data = new Data();
		data.setName("Guillermo");
		data.setLastname("Segura");
		controller.save (data);
	}

}
