package com.tamco.serialization;

import java.io.*;
import java.util.*;

/**
 * Created by tam-co on 16/03/2017.
 */
public class SerializationOperation {

	public static void main(String[] args) {
		// Serialization example
		Date birthDate = new Date(633978000000L);
		Employee employee = new Employee("Tam", "Co", birthDate, 123);

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./serializable.out"));
			oos.writeObject(employee);
			oos.close();

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./serializable.out"));
			Employee deserializedEmployee = (Employee) ois.readObject();
			ois.close();

			System.out.println("\nDeserialized object: " + deserializedEmployee.toString());

		} catch (IOException e) {
			System.out.println("IO exception: " + e.getMessage());

		} catch (ClassNotFoundException e) {
			System.out.print("ClassNotFound exception: " + e.getMessage());
		}
	}
}
