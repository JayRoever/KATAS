package root_insurance.root_kata;

import java.io.IOException;

import root_insurance.root_kata.controller.Controller;
import root_insurance.root_kata.view.View;

public class App 
{
	private Controller controller;
	private View view;
	
    public static void main( String[] args ) {
    	if(args.length > 0) {
    		App app = new App(args[0]);
    		app.run();
    	} else {
    		System.out.println("No Input Args. Please Run Program With File Path");
    	}
    }

    public App(String filePath) {
    	try {
    		this.controller = new Controller(filePath);
    		this.view = new View();
    	} catch (IOException e) {
			System.out.println("File Not Found");
		}
    }
    
	private void run() {
		try {
			view.printDrivers(controller.getDrivers());
		} catch(NullPointerException e) {
			
		}
	}
}
