package I.O;
import java.io.File;

public class FileListing {
	public static void main(String[]args)
	{
		File directory  = new File("/Users/ishankk/Desktop");
		String[] contents = directory.list();
		//System.out.println("All sub directories & files:");
		for(String file: contents)
		{
			//System.out.println(file);
		}
		/*
		 * other way to do it is
		 */
		//System.out.println("Other way to list all sub directories & files:");
		//iterate1(directory);
		iterate2(directory);
	}
	public static void iterate1(File f)
	{
		File[] files = f.listFiles(); //can be used for further iteration
		for(File file: files)
		{
			System.out.println(file.getParent() + " -> " + file.getName());
			/*
			 * it iterates for every child directory & expands it
			 */
			if(file.isDirectory())
				iterate1(file);
		}
	}
	public static void iterate2(File f)
	{
		File [] files  = f.listFiles(new FilterImplement());
		for(File file: files)
		{
			System.out.println(file.getParent() + " -> " + file.getName());
			/*
			 * it iterates for every child directory & expands it
			 */
/*			if(file.isDirectory())
				iterate2(file);
	*/	}
	}
}