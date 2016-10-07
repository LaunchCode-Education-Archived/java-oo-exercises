package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class BlueFilter {

	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          int newBlue = (r + g + b) / 3;
	          
	          processed.set(i, j, new Color(0, 0, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}

}
