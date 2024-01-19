package exercises;

import exercises.data.DataObject1;
import exercises.data.DataObject2;
import serialization.SerializationManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestApplication {

	public static void main(String[] args) {
		try {
			simpleSerializationTest();
			System.out.println("Serialization and deserialization completed successfully!");
		} catch (IOException e) {
			System.err.println("IOException occurred: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException occurred: " + e.getMessage());
		}
	}

	static void simpleSerializationTest() throws IOException, ClassNotFoundException {
		try {
			// Step 1: Create an instance of SerializationManagement
			SerializationManagement sm = new SerializationManagement();
			List<DataObject1> dataObjects = new ArrayList<>();

			// Step 2: Create and populate DataObject1 and DataObject2 instances
			for (int x = 0; x < 100; x++) {
				DataObject1 do1 = new DataObject1();
				dataObjects.add(do1);

				// Set properties for DataObject1
				do1.setProperty1(String.valueOf(x));
				do1.setProperty2(x);

				// Create and set properties for DataObject2
				DataObject2 do2 = new DataObject2();
				do1.setComplexTypeProperty(do2);

				do2.setSourceIdentifier("Serialized");
				do2.setProperty1(String.valueOf(x));
				do2.setProperty2(x);
			}

			// Step 3: Serialize DataObject1 instances
			sm.serialize("TestData", dataObjects);
			System.out.println("DataObjects serialized successfully!");

			// Step 4: Deserialize DataObject1 instances
			dataObjects = (List<DataObject1>) sm.deserialize("TestData");
			System.out.println("DataObjects deserialized successfully!");

			// Print the deserialized dataObjects in a readable format
			for (DataObject1 do1 : dataObjects) {
				System.out.println("Property1: " + do1.getProperty1());
				System.out.println("Property2: " + do1.getProperty2());

				DataObject2 do2 = do1.getComplexTypeProperty();
				System.out.println("ComplexTypeProperty - SourceIdentifier: " + do2.getSourceIdentifier());
				System.out.println("ComplexTypeProperty - Property1: " + do2.getProperty1());
				System.out.println("ComplexTypeProperty - Property2: " + do2.getProperty2());
				System.out.println("-----"); // Separator between objects
			}


			// Step 5: Validate the deserialized data
			for (int x = 0; x < 100; x++) {
				DataObject1 do1 = dataObjects.get(x);

				// Validate properties of DataObject1
				assert do1.getProperty1().equals(String.valueOf(x));
				assert do1.getProperty2() == x;

				// Validate properties of DataObject2 within DataObject1
				DataObject2 do2 = do1.getComplexTypeProperty();
				assert do2.getSourceIdentifier().equals("Serialized");
				assert do2.getProperty1().equals(String.valueOf(x));
				assert do2.getProperty2() == x;

				// Additional condition: SourceIdentifier should be "Serialized"
				assert do2.getSourceIdentifier().equals("Serialized");
			}
	    } catch (Exception e) {
			// Step 6: Handle exceptions during serialization/deserialization
			System.err.println("Error during serialization/deserialization: " + e.getMessage());
		}
		
	}

}
