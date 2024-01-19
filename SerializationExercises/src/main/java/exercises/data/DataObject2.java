package exercises.data;

import java.io.Serializable;

/**
 * DataObject2 represents a serializable data object with properties:
 * - sourceIdentifier: transient field, not included in serialization
 * - property1: a String property
 * - property2: an int property
 *
 * This class implements the Serializable interface for object serialization.
 */
public class DataObject2 implements Serializable {

	private static final long serialVersionUID = 1L;

	// 'transient' keyword indicates that this field won't be included in serialization
	private transient String sourceIdentifier;

	private String property1;
	private int property2;

	/**
	 * Default constructor for DataObject2.
	 */
	public DataObject2() {
	}

	/**
	 * Parameterized constructor for DataObject2.
	 *
	 * @param property1 The value for property1
	 * @param property2 The value for property2
	 */
	public DataObject2(String property1, int property2) {
		this.property1 = property1;
		this.property2 = property2;
	}

	/**
	 * Getter method for sourceIdentifier.
	 *
	 * @return The source identifier
	 */
	public String getSourceIdentifier() {
		return sourceIdentifier;
	}

	/**
	 * Setter method for sourceIdentifier.
	 *
	 * @param sourceIdentifier The source identifier to set
	 */
	public void setSourceIdentifier(String sourceIdentifier) {
		this.sourceIdentifier = sourceIdentifier;
	}

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
}
