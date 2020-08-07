package root_insurance.root_kata.controller;

import java.io.IOException;
import java.util.ArrayList;

import root_insurance.root_kata.dao.FileIO;
import root_insurance.root_kata.dao.InputDAO;
import root_insurance.root_kata.model.DistanceSorter;
import root_insurance.root_kata.model.Driver;

public class Controller {

	private InputDAO dataDAO;
	private ArrayList<Driver> drivers;
	
	public Controller(String filePath) throws IOException {
		loadData(filePath);
	}
	
	private void loadData(String filePath) throws IOException {
		dataDAO = new FileIO(filePath);
		drivers = dataDAO.loadData();
		drivers.sort(new DistanceSorter());
	}
	
	public ArrayList<Driver> getDrivers(){
		return drivers;
	}
}
