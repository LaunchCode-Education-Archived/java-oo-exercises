package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class BrightnessFilter implements Filter {

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



				
				if(r < 230 && r > 10){
					r = r + 25;
				}
				if(g < 230 && g > 10 ){
					g = g + 25;
				}
				if(b < 230 && b > 10){
					b =  b + 25;
				}
			
				processed.set(i, j, new Color(r, g, b));

			}
		}

		return processed;
	}
}
