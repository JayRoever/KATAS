#Root-Kata Readme

## Running the Program

To run the program open up the terminal and cd into the directory containing the root-kata.jar file.

Then use the java -jar command followed by the path of the file you are trying to parse.

`java -jar root-kata.jar path-of-file.txt`

# Design
## Program Design
Even though the kata was relatively simple I made the decision to follow the Model-View-Controller design with the program to showcase my understanding of the pattern.

The program is broken up into the 3 main parts following the MVC pattern:

### Model Objects
- Driver
- Trip
- FileIO
- DistanceSorter

### View Objects
- View

### Controller Objects
- App
- Controller

## Object Design

### Trip.java
The trip object represents a single trip loaded from the data. It contains 3 variables:

- startTime: String representing the start time of the trip on a 24-hour clock.
- endTime: String representing the end time of the trip on a 24-hour clock.
- distance: String representing the total distance in miles driven during the trip.

And 2 public methods:

- getDistanceTraveled: parses the distance and returns it as a double.
- getTripTimeInMinuets: returns the elapsed time of the trip in minuets.

I made the decision to store the variables as strings straight from the data parsed from the input file to simplify the DAO and then turned into more useful primatives when the data is requested through the methods.

### Driver.java
The driver object represents a single driver loaded from the data and contains all the trips associated with that driver.  It contains 2 variables:

- name: String representing the drivers name
- trips: ArrayList containing all the trip object associated with the driver.

And 4 public methods:

- getName: returns the drivers name.
- addTrips: adds a trip to the driver. Only adds the trip if the speed of the trip is within 5-100 miles per hour inclusive.
- getMilesDriven: returns the total miles driven rounded up or down to the nearest whole mile.
- getAverageSpeed: returns the average speed the driver has driven across all trips rounded to the nearest mile per hour.

I decided to hold lists in an ArrayList to make it easy to add trips as an ArrayList is dynamic in size. The requirements requested distance and speed to be rounded to the nearest whole mile or mph and I made the decision to round the numbers after being sumed up in order to keep accuracy as high as possible. If trips were rounded, small differences in rounding could add to to make the data less accurate.

### FileIO.java
The fileIo object loads the file from the path given to the program and build driver objects and populates those drivers with trips. It has 2 variables:

- filePath: the path input into the program of the file to parse data from.
- drivers: a Hashmap containing the drivers with keys being driver names.

And 1 public method:

- loadData: loads the data from the file and creates new drivers and assigns trips to drivers. The method splits data on lines by spaces between items and creates a driver when the first word of line the is "Driver" and creates a trip if the first word is "Trip".

I chose to store the drivers within the method as a map for easy access to the drivers as a trip and driver both contained the name of the driver and is was easier and more intuitive to recall a driver via their name in the map's keys in order to add a trip. When the loadData method is called by the controller it is returned as an ArrayList for easier iteration by the view.

The FileIO object implements an InputDAO interface in order to decouple the actual retrevial of data from the data source. While unnecessary for this project, I chose to include this to show my knowledge in the use of interfaces and why they are used.

### DistanceSorter.java
The distance sorter object is an extremely simple Comparator object the exists for the controller to use in order to sort the drivers in descending order.

### View.java
The view object for this project is very simple but was included in order to completely implement the view aspect of the MVC design. It includes 1 method:

- printDrivers: takes in an ArrayList of drivers, already sorted by th controller, and prints them to the terminal and formated to the requirements.

There isn't much to say about this object as its fairly simple and its only job is to print out the result of the program. In a more complex progam this would be where I would put most, if not all, outputs to the user.

### Controller.java
The controller object in the main controller for the model objects it takes the file path from the input on creation to pass to the fileIO object which also loads all data on creation. It contain 2 variables:

- dataDAO: an InputDAO implemented by fileIO
- drivers: the ArrayList of drivers populated with trips retrieved by the DAO

And 1 public method:
- getDrivers: retrieves the driver data.

The controler for this program is again, fairly simple, but the decision was made to hold the driver data within the controler for the main App object to call on so that this controller may act as the controller for the model objects.

### App.java
The App object acts as the main program and also as a controller that takes data from the model controller (Controller.java) and passes it to the View for presentation to the user. It contains no public methods other than its constructor and the main method that runs on startup.

This method doesn't do much in this program but is where all error propogation gets caught. If the program is run without input, or with a path to a file that doesnt exist then the App with notify the user.

## Testing
Junit tests were made providing coverage over the entire model part of the program. Coverage was not extended to the App or View objects as they exist primarily to pass and display data which was visually tested by running the program by hand.

