package root_insurance.root_kata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import root_insurance.root_kata.controller.Controller;
import root_insurance.root_kata.model.Driver;

public class ControllerTest
{
	private Controller controller;
	ArrayList<Driver> drivers;
	
	@Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Before
    public void testUsingTempFolder() throws IOException {
            @SuppressWarnings("unused")
			File createdFile = folder.newFile("testInput.txt");
            FileWriter fileWriter = new FileWriter("testInput.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("Driver Dan\n" + 
            		"Driver Lauren\n" + 
            		"Driver Kumi\n" + 
            		"Trip Dan 07:15 07:45 17.3\n" + 
            		"Trip Dan 06:12 06:32 21.8\n" + 
            		"Trip Lauren 12:01 13:16 42.0");
            printWriter.close();
    }
    
    @Before
    public void setUp() {
    	try {
			controller = new Controller("testInput.txt");
			drivers = controller.getDrivers();
		} catch (IOException e) {
			System.out.println("Error Loading Data");
		}
    }
    
    @After
    public void fileDelete() {
    	File f= new File("testInput.txt");
    	f.delete();
    }
    
    @Test
    public void testDriverOrder() {
    	Assert.assertEquals("Lauren", drivers.get(0).getName());
    	Assert.assertEquals("Dan", drivers.get(1).getName());
    	Assert.assertEquals("Kumi", drivers.get(2).getName());
    }
}
