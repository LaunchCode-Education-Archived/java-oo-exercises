package javagram;

import javagram.filters.*;

import java.awt.Color;
import java.io.File;
import java.util.Arrays;

public class Javagram {

	public static void main(String[] args) {

		// Get image path
		String dir = System.getProperty("user.dir");
		String relPath = "assignments/javagram/images/mentorcenter.jpg";
		String[] relPathParts = relPath.split("/");
		String imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts)); 
		
		//System.out.println("image path = " + imagePath);

		Picture picture = new Picture(imagePath);

		//Filter filter = new MonochromeFilter(new Color(0, 128, 128));
		Filter filter = new InvertColorFilter();

		Picture processed = filter.process(picture);

		processed.show();
	}

}