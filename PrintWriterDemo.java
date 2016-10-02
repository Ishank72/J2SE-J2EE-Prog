package I.O;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
/*
 * we cannot instantiate Writer as it is an abstract class
 * Flushable, Appendable, Closeable & AutoCloseable are the Interfaces
 * The fact that PrintWriter's method is called append() doesn't mean that it changes mode of the file being opened.
 */
public class PrintWriterDemo {

	public static void main(String[] args) throws IOException {
		//FileInputStream fis = new FileInputStream(f);
		//Reader r = new InputStreamReader(fis);
		//BufferedReader br = new BufferedReader(r);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File f = new File("/Users/ishankk/Documents/holy.txt");
		if(!f.exists())
		{
			f.createNewFile();
		}
		//FileOutputStream fos = new FileOutputStream("/Users/ishankk/Documents/words.txt");
		//PrintWriter pw = new PrintWriter("/Users/ishankk/Documents/words.txt");
		//PrintWriter pw = new PrintWriter(f);
		//PrintWriter pw = new PrintWriter(fos, true);
		Writer w = new PrintWriter(f);
		/*
		 * here true is for auto flush
		 */
		PrintWriter pw = new PrintWriter(w, true);//any argument would do in case of PrintWriter like FOS, PRINTWRITER, FILE 
		//byte [] b = new byte[fis.available()];
		//fis.read(b);
		//String str = new String(b, "Default");
		//w.write(str);
		//fis.close();
		String str = null;
		/*
		 * the strings we enter get automatically appended
		 */
		while(!(str = br.readLine()).equals("END")){
			//pw.write(str);
			pw.append(str);
			pw.println();
		}
		br.close();
		w.close();
		System.out.println("file copied successfully");
	}
}