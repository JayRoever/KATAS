package root_insurance.root_kata.dao;

import java.io.IOException;
import java.util.ArrayList;

import root_insurance.root_kata.model.Driver;

public interface InputDAO {

	public ArrayList<Driver> loadData() throws IOException;
}
