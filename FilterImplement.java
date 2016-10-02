package I.O;

import java.io.File;
import java.io.FileFilter;
/*
 * 
 */

public class FilterImplement implements FileFilter {

	/*
	 * (non-Javadoc)
	 * @see java.io.FileFilter#accept(java.io.File)
	 * needed to be defined by the implementing class
	 */
	public boolean accept(File pathname) {
		
		//return pathname.isDirectory();//Only displays the directories when we run the FileListing class
		//return pathname.getName().toLowerCase().endsWith(".txt");//Only displays the text files
		//return pathname.isFile();//Only displays the files & not the directories
		return pathname.isFile() && pathname.getName().endsWith(".jpg");
	}

}
