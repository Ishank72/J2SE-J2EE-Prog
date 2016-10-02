package I.O;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyingFile {

	public static void main(String[] args) throws IOException {
		FileInputStream  fis = null;
		FileOutputStream  fos = null;
		fis = new FileInputStream("/Users/ishankk/Desktop/13606847_1132719796749866_705404482009889945_n.jpg");
		fos = new FileOutputStream("/Users/ishankk/Documents/Rocky.jpg");
		int size = fis.available();
		byte[] bytes_array4 = new byte[size];
		fis.read(bytes_array4);
		fos.write(bytes_array4);
		fos.flush();
		fis.close();
		fos.close();
	}

}
