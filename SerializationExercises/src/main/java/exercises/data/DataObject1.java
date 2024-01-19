package exercises.data;

import java.io.Serializable;

/**
 * DataObject1 represents a serializable data object with properties:
 * - property1: a String property
 * - property2: an int property
 * - complexTypeProperty: an instance of DataObject2 serving as a complex type
 *
 * This class implements the Serializable interface for object serialization.
 */
public class DataObject1 implements Serializable {

	private static final long serialVersionUID = 1L;

	private String property1;
	private int property2;
	private DataObject2 complexTypeProperty;

	/**
	 * Getter method for property1.
	 *
	 * @return The value of property1
	 */
	public String getProperty1() {
		return property1;
	}

	/**
	 * Setter method for property1.
	 *
	 * @param property1 The value to set for property1
	 */
	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	/**
	 * Getter method for property2.
	 *
	 * @return The value of property2
	 */
	public int getProperty2() {
		return property2;
	}

	/**
	 * Setter method for property2.
	 *
	 * @param property2 The value to set for property2
	 */
	public void setProperty2(int property2) {
		this.property2 = property2;
	}

	/**
	 * Getter method for complexTypeProperty.
	 *
	 * @return The complex type property (an instance of DataObject2)
	 */
	public DataObject2 getComplexTypeProperty() {
		return complexTypeProperty;
	}

	/**
	 * Setter method for complexTypeProperty.
	 *
	 * @param complexTypeProperty The value to set for complexTypeProperty
	 */
	public void setComplexTypeProperty(DataObject2 complexTypeProperty) {
		this.complexTypeProperty = complexTypeProperty;
	}
}