package I.O;
/*
 * Only output streams have got the flushing parameters
 * why it is not feasible to use readers and writers with binary files?
 * because they change bytes to chars while reading/writing, we get the char data instead of the byte data
 * this is not true in case of streams, they work in bytes
 * In version 1.7, the package java.nio has some additional classes to make reading & writing of data easy
 * PATH
 * FILES
 * why can't all the methods in all the packages be static?
 * then the JVM will not function, all the static members get the memory allocated in JVM so we need a huge RAM for that
 * in case of files we do not require to create multiple objects
 * 
 * delete -> delete action performed by the user before JVM
 * deleted on Exit -> by the JVM
 * A folder cannot be deleted if it has contents
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class copyingFile2 {

	public static void main(String[] args) throws IOException {
		FileInputStream  fis = null;
		FileOutputStream  fos = null;
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter source: ");
		String str = read.readLine(); 
		File f = new File(str);
		String str1 = f.getCanonicalPath();
		System.out.println(str1);
		fis = new FileInputStream(f);
		fos = new FileOutputStream("/Users/ishankk/Documents/Rocky.jpg");
		byte[] bytes_array4 = new byte[fis.available()];
		fis.read(bytes_array4);
		fos.write(bytes_array4);
		fos.flush();
		fis.close();
		fos.close();
	}
}