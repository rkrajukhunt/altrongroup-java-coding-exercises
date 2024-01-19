package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;

/**
 * SerializationManagement provides methods for object serialization and deserialization.
 * It includes methods to serialize an object and deserialize an object from/to a file.
 */
public class SerializationManagement {

    /**
     * Serializes the given data object to a file with the specified data identifier.
     *
     * @param dataIdentifier The identifier for the serialized data (used in the file name)
     * @param dataObject     The object to be serialized
     */
    public void serialize(String dataIdentifier, Object dataObject) {
        try {
            // Determine the file separator based on the operating system
            String fileSeparator = FileSystems.getDefault().getSeparator();

            // Specify the directory path
            String directoryPath = "." + fileSeparator + "Serialized" + fileSeparator;
            System.out.println("this is directory of file :- " + directoryPath);

            // Create the directory if it doesn't exist
            File directory = new File(directoryPath);
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create the directory: " + directory.getAbsolutePath());
            }

            // Create the file path using the directory and data identifier
            String filePath = directoryPath + String.format("%s.ser", dataIdentifier);

            // Serialize the object to the file
            try (FileOutputStream file = new FileOutputStream(filePath);
                 ObjectOutputStream out = new ObjectOutputStream(file)) {
                out.writeObject(dataObject);
            }

            System.out.println("Serialization completed successfully.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    /**
     * Deserializes an object from a file with the specified data identifier.
     *
     * @param dataIdentifier The identifier for the serialized data (used in the file name)
     * @return The deserialized object, or null if deserialization fails
     */
    public Object deserialize(String dataIdentifier) {
        try {
            // Determine the file separator based on the operating system
            String fileSeparator = FileSystems.getDefault().getSeparator();

            // Create the file path using the directory and data identifier
            String filePath = "." + fileSeparator + "Serialized" + fileSeparator + String.format("%s.ser", dataIdentifier);

            // Deserialize the object from the file
            try (FileInputStream file = new FileInputStream(filePath);
                 ObjectInputStream in = new ObjectInputStream(file)) {
                return in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
            return null;
        }
    }
}