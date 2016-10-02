package I.O;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class WritingObject {
	private String a = "1";
	private String b = "2";
	private String c = "3";
	private String d = "4";
	public static void main(String[] args) throws IOException {
		File f = new File("/Users/ishankk/Documents/holy.txt");
		f.delete();
		if(!f.exists())
		{
			f.createNewFile();
		}
		Writer out = new PrintWriter(f);
		WritingObject o = new WritingObject();
		o.writeObject(out);
		out.flush();
	}
	public void writeObject(Writer out) throws IOException
	{
		out.write(a + "|" + b+ "|" + c+ "|" + d);
	}

}
