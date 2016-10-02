package I.O;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*
 * Serialization is just a concept & not a class in any of the JAVA packages
 * It can be used as the name of our class
 * reading & writing an object to & from file
 * In general we loose object data if we do not store it
 * Two classes that're used to do serialization
 * ObjectInputStream -> serialization - to read the object
 * ObjectOutputStream -> de-serialization, needs FOS to communicate with the file system, 
 * flush not required because writeObject does that job for us - to write the object
 * we get error when we close FIS before OIS
 * to make class a serializable class needs to implement Serializable 
 * Serializable -> it's a marker interface in java.io to tell JVM that our class is serializable
 * Transient -> can only be applied to data members
 * Transient data members values do not get saved in file during Serialization
 * object serialization can be used to share data between two JVMs 
 */
public class Serialization implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  int a;
	protected int b;
	public int c;
	transient public int d;
	public int e;
	transient public String str;
	public Serialization(){
		System.out.println("in base");
	}
	/*
	 * If we make the constructor private then it becomes invisible to other classes
	 * If we make the constructor protected then it will not be visible to its extending & 
	 * non-extending classes in different packages
	 * No relation is required between the classes to access the public members
	 */
	protected Serialization(int a, int b, int c, int d, int e){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.str = "JAVA";
	}
	protected void read(){
		
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream("/Users/ishankk/Desktop/workspace/programs/i/o/Integer.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Serialization s = new Serialization(24,48,72,96,120);
		/*
		 * Output Stream can not be closed before the writing of the object
		 * fos.close();
		 */
		/*
		 * We get java.io.NotSerializableException
		 * if the class does not implement the Serializable interface
		 */
		oos.writeObject(s);
		fos.close();
	}
	public String toString(){
		return str + a + b + c + d + e;
	}
}
