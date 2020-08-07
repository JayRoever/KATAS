package root_insurance.root_kata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.After;
import org.junit.Assert;

import root_insurance.root_kata.dao.FileIO;
import root_insurance.root_kata.model.Driver;

public class FileIOTest {

	FileIO fileIO;
	
	@Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Before
    public void testUsingTempFolder() throws IOException {
    	try {
    		FileWriter fileWriter = new FileWriter("testInput.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("Driver Dan\n" + 
            		"Driver Lauren\n" + 
            		"Driver Kumi\n" + 
            		"Trip Dan 07:15 07:45 17.3\n" + 
            		"Trip Dan 06:12 06:32 21.8\n" + 
            		"Trip Lauren 12:01 13:16 42.0");
            printWriter.close();
            fileIO = new FileIO("testInput.txt");
    	} catch(IOException e) {
    		System.out.println("Error loading Data");
    	}
    
    }
    
    @After
    public void fileDelete() {
    	File f= new File("testInput.txt");
    	f.delete();
    }
    
    @Test
    public void testLoadData() {
    	try {
	    	Assert.assertEquals(3, fileIO.loadData().size());
	    	Assert.assertEquals(true, arrayContrainsDriver(fileIO.loadData(), "Dan"));
	    	Assert.assertEquals(39, getDriver(fileIO.loadData(), "Dan").getMilesDriven());
	    	Assert.assertEquals(0, getDriver(fileIO.loadData(), "Kumi").getMilesDriven());
    	} catch(IOException e) {
    		System.out.println("Error loading Data");
    	}
    }
	
    private boolean arrayContrainsDriver(ArrayList<Driver> drivers, String nameToFind) {
    	Boolean contrainsDriver = false;
    	for(Driver driver : drivers) {
    		if(driver.getName().equalsIgnoreCase(nameToFind)) return true;
    	}
    	return contrainsDriver;
    }
    
    private Driver getDriver(ArrayList<Driver> drivers, String nameToFind) {
    	for(Driver driver : drivers) {
    		if(driver.getName().equalsIgnoreCase(nameToFind)) return driver;
    	}
    	return null;
    }
}
