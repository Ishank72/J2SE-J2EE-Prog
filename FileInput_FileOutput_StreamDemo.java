/*
 * IO -> Input/Output
 * Devices:
 * keyboard
 * mouse
 * printers
 * scanners
 * Data can be communicated between
 * Files
 * Network Streams
 * java.io is the package
 * Two major components are:
 * Streams -> reads/writes data from source to destination & vice versa (in bytes)
 * Writer/Reader -> Reader to read(input) & Writer to write (output) (as text)
 * Components of Stream:
 * Output Stream & Input Stream (classes)
 * BufferedWriter & BufferedReader -> advanced classes
 * Using IO package we can read our internal file system as well
 * File System:
 * Input -> reading data into your java program (getting data into your program by reading it from a file)
 * Output -> writing data from your java program (sending the output to a desired location (a file/console))
 * InputSreamReader -> earlier we used System.in to read data from the keyboard 
 * System.out -> PrintWriter class
 * Image files & all the applications files are considered as binary files & the java files kind of files as text files
 * In the InputStream category InputStream is a super class of all classes (bytes)
 * FileInputStream -> read data
 * In the OutputStream category OutputStream is a super class of all classes (bytes)
 * FileOutputStream -> write data
 * Exceptions:
 * IOException
 * FileNotFoundException
 * InterruptedIOException
 * ObjectStreamException etc
 * readers & writers are not suitable when working with binary files
 * they are good to be used with a text file kind of file
 * reader & writer depend on the streams to communicate with the source & the destination
 * FileChannel is an abstract class that can be used to do multiple file operations at the same time
 * as compared to FIS or FOS which are doing single operation at a time
 * e.x. reading/writing a file all together
 * java.nio.channels.FileChannel
 */
package I.O;
import java.io.*;

public class FileInput_FileOutput_StreamDemo{
	private int vartest;
	private static final int BUFFER_SIZE = 1024;
	static long startTime;
	static long endTime;
	static int fileSize;
	public static void main(String[] args) throws IOException {
		double l =1.82233445;
		System.out.printf("%.5f %f ", l , Math.floor(l));
		System.out.printf("%.2f ", Math.ceil(l));
		
		FileInput_FileOutput_StreamDemo ios = new FileInput_FileOutput_StreamDemo();
		ios.vartest = 0;
		System.out.println("vartest: " + ios.vartest);
		/*
		 * InputStream is an interface extended by FileInputStream
		 * OutputStream is an interface extended by FileOutputStream
		 */
		InputStream fis = null;
		/*
		 * read() -> char
		 * read(bytes[]) -> returns integer value & reads the bytes in the byte array 
		 */
		File f = new File("/Users/ishankk/Desktop/words.txt");
		startTime = new java.util.Date().getTime();
		try{
			fis = new FileInputStream(f);
			fileSize = fis.available(); // returns number of bytes
			System.out.println("size of the file in KB -> " + fileSize/1024);
			int index = 0;
			while(index < fileSize)
			{
				fis.read();
				index++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		endTime = new java.util.Date().getTime();//returns time in millis
		System.out.println("START TIME -> " + (startTime/1000) + " secs");
		System.out.println("END TIME -> " + (endTime/1000)+ " secs");
		System.out.println("Total time taken while reading the file char by char -> " + (endTime-startTime) + " secs");
		/*
		 * Reading chunks instead of reading it character by character
		 * FIS object is needed to be reinitialized before reuse 
		 */
		startTime = new java.util.Date().getTime();
		fis = new FileInputStream("/Users/ishankk/Desktop/words.txt");
		byte[] bytes_array1 = new byte[fileSize];
		fis.read(bytes_array1);//reads all the bytes into the byte array
		String str = new String(bytes_array1, "Default");//Default has been used to specify the default char-set
		//System.out.println("Displaying the file data -> " + str);
		fis.close();
		endTime = new java.util.Date().getTime();
		System.out.println("START TIME -> " + startTime);
		System.out.println("END TIME -> " + endTime);
		System.out.println("Total time taken to read the whole file in a go -> " + (endTime-startTime) + " milli seconds");
		startTime = new java.util.Date().getTime();
		fis = new FileInputStream("/Users/ishankk/Desktop/words.txt");
		byte[] bytes_array2 = new byte[BUFFER_SIZE];
		int number_iterations = 0;
		while(fis.read(bytes_array2) > 0)
		{	number_iterations++;
			String str1 = new String(bytes_array2, "Default");//Default is for the char-set
			//System.out.println("Displaying " + BUFFER_SIZE +  " bytes -> " + str1);
			int size = fileSize>(BUFFER_SIZE*(number_iterations)) ? BUFFER_SIZE : fileSize - (BUFFER_SIZE*number_iterations);
			if(size > 0)
				bytes_array2 = new byte[size];
		}
		System.out.println("Total number of iterations required -> " + number_iterations);
		fis.close();
		endTime = new java.util.Date().getTime();
		System.out.println("START TIME -> " + startTime);
		System.out.println("END TIME -> " + endTime);
		System.out.println("Total time taken to read " + BUFFER_SIZE + " at a time -> " + (endTime-startTime) + " milli seconds");
		System.out.println();
		/*
		 * OUTPUTSTREAMS
		 * flushing cleans the data stuck in the pipeline by sending it to its destination
		 */
		System.out.println("Writing data into another file..");
		/*
		 * true is to specify the append mode
		 * to append means whenever we re run the program & try to insert new data in the file
		 * it shouldn't erase the old data from it 
		 */
		FileOutputStream fos = new FileOutputStream("/Users/ishankk/Documents/holy.txt", true);
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Message1: ");
		String str2 = " ";
		while(!str2.equals("END"))
		{
			System.out.println("Enter the message to inserted into the file: ");
			str2 = read.readLine();
			int string_size = str2.length();
			for(int j = 0; j < string_size; j++)
			{
				fos.write(str2.charAt(j));
			}
		}
		System.out.println("Out of the loop ");
		/*
		 * variable has been declared to prevent calling of length method again & again
		 */
		/*
		 * reading complete string
		 * & storing in a byte array
		 */
		str2 = read.readLine();
		byte[] bytes_array3 = str2.getBytes();
		fos.write(bytes_array3);
		//fos.flush();
		fos.close();
	}
	/*
	 * Both FIS & FOS do not implement Flushable
	 */
}