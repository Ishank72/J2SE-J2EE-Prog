package I.O;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
/*
 * Writer is the super class of PrintWriter & BufferedWriter
 */
public class BufferedWriterDemo {

	public static void main(String[] args) throws IOException {
		//FileInputStream fis = new FileInputStream("/Users/ishankk/Desktop/words.txt");
		//Writer w = new PrintWriter("/Users/ishankk/Documents/words.txt");
		//BufferedWriter bw = new BufferedWriter(w);
		/*
		 * OutputStream is an abstract class like Reader & Writer classes implemented by FOS
		 */
		OutputStream fos = new FileOutputStream("/Users/ishankk/Documents/holy.txt", true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(fos);
		BufferedWriter bw = new BufferedWriter(pw);//works
		//byte [] b = new byte[fis.available()];
		//fis.read(b);
		//String str = new String(b, "Default");
		//bw.write(str);
		String str = null;
		while(!(str = br.readLine()).equals("END")){
			//bw.write(str);
			bw.append(str);
			bw.newLine();
		}
		bw.close();
		//fis.close();
		System.out.println("file copied successfully");
	}
}