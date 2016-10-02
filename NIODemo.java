package I.O;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;;

public class NIODemo {
	public static void main(String[] args) throws IOException
	{
		FileOutputStream fos = new FileOutputStream("/Users/ishankk/Documents/word.txt");
		Path p = new File("/Users/ishankk/Desktop/words.txt").toPath();
		Files.copy(p, fos);
		fos.flush();
		fos.close();
	}
}
