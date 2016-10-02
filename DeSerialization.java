package I.O;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialization{
	public static void display(Serialization s)
	{	System.out.println(s.a);
		System.out.println(s.b);
		System.out.println(s.c);
		System.out.println(s.d);// as d is transient its value was not written to the file & the default value is printed here 
		System.out.println(s.e);
		System.out.println(s.str);// as str is transient its value was not written to the file & the default value is printed here
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		/*
		 * creates .ser file automatically if it doesn't exist
		 */
		FileInputStream fis = new FileInputStream("/Users/ishankk/Desktop/workspace/programs/i/o/Integer.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Serialization s = null;
		try{
		s = (Serialization) ois.readObject();//cannot convert from Object to Serialization
		}catch(Exception e){
			
		}
		/*
		 * fis.close();
		 * Input Stream can not be closed before the reading of the object
		 */
		/*
		 * we get java.io.NotSerializableException
		 * if the class does not implement the the Serializable interface
		 * Serializable is implemented to tell JVM that the class is serializable
		 */
		display(s);
		fis.close();
	}
}