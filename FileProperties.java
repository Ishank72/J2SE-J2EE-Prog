/*
 * File class represents the files in our system
 */
package I.O;

import java.io.File;
import java.io.IOException;

public class FileProperties {

	public static void main(String[] args) throws IOException {
		File[] roots = File.listRoots(); //static method, gives list of directories
		for(File f: roots)
		{	/*
			* we get / in case of MAC
			* In WINDOWS we get drive names & the external drives as well
			*/
			System.out.println("Root Absolute Path:" + f.getAbsolutePath()); 
		}
		File f = new File("/Users/ishankk/Desktop/HOLY.txt");
		File dir = new File("/Users/ishankk/Desktop/a/b/c/d");
		System.out.println("Do the directories mentioned above exist?? -> " + dir.exists());
		if(!dir.exists())
			dir.mkdirs();// in this situation mkdirs & not mkdir will work because we have multiple directories not existing  
		System.out.println(f.exists());
		if(!f.exists()){
			f.createNewFile();
			f.mkdir(); //to create single directory if it doesn't exist
		}
		f.renameTo(new File("/Users/ishankk/Desktop/holy.txt"));
		System.out.println();
		System.out.println("File Properties: ");
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());
		System.out.println(f.canWrite());
		System.out.println(f.canRead());
		System.out.println(f.isHidden());
		System.out.println(new java.util.Date(f.lastModified()));
		System.out.println(f.getName());
		System.out.println(f.getCanonicalPath());//system dependent path, IOException, acts like if we have called getAbsolutePath()
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getAbsoluteFile());
		System.out.println(f.getPath());
		System.out.println(f.getParent());
		System.out.println(f.length());
		System.out.println(f.canExecute());
		System.out.println();
		System.out.println("Space Description");
		System.out.println("Total Space -> " + f.getTotalSpace()/1024/1024/1024);//gives total available space of the internal hard disk in GB
		System.out.println("Free Space -> " + f.getFreeSpace()/1024/1024/1024);//gives free space available in the internal hard disk in GB
		System.out.println("Usable Space -> " + f.getUsableSpace()/1024/1024/1024);//gives available usable space of the internal hard disk in GB
		System.out.println();
		System.out.println("Listing files & folders");
		f.deleteOnExit();
		dir.deleteOnExit();
	}
	public static void iterate(File folder)
	{
		File[] files1 = folder.listFiles();
		for(File file: files1)
		{	System.out.println(file.getParent() + " -> " + file.getName());
			if(file.isDirectory())
				iterate(file);
		}
	}
}