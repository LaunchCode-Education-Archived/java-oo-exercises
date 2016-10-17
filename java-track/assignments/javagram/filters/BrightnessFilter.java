package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class BrightnessFilter implements Filter {
	
	private final int brightnessFactor = 75;

	public Picture process(Picture original) {

		Picture processed = new Picture(original.width(), original.height());

		// get each pixel one by one
		for (int i = 0; i < original.width(); i++) {
			for (int j = 0; j < original.height(); j++) {

				Color c = original.get(i, j);
				
				// get r, g, b values
				int[] RGB = { c.getRed(), c.getGreen(), c.getBlue() };
				
				// add fixed-value or set max value of 255 for each color-component
				for (int cc = 0; cc < 3; cc++) {
					RGB[cc] += brightnessFactor;
					if (RGB[cc] > 255) RGB[cc] = 255;
				}
				
				processed.set(i, j, new Color(RGB[0], RGB[1], RGB[2]));
			}
		}
		
		return processed;
	}

}
