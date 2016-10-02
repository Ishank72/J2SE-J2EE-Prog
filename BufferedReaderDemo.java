package I.O;
/*
 * Abstract classes:
 * IS
 * OS
 * READER
 * WRITER
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		InputStream f = new FileInputStream("/Users/ishankk/Desktop/words.txt");
		Reader isr = new InputStreamReader(f);//we can not directly provide the file location as an argument to an ISR constructor 
		BufferedReader br = new BufferedReader(isr);
		PrintWriter pw = new PrintWriter("/Users/ishankk/Documents/words.txt");
		BufferedWriter bw = new BufferedWriter(pw);//works
		String str = null;
		while((str = br.readLine()) != null)
		{
			bw.write(str);
		}
		System.out.println("file copied successfully");
		br.close();
		bw.close();
	}
}