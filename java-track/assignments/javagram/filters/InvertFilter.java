package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class InvertFilter implements Filter {

	public Picture process(Picture original) {

		Picture processed = new Picture(original.width(), original.height());

		// get each pixel one by one
		for (int i = 0; i < original.width(); i++) {
			for (int j = 0; j < original.height(); j++) {

				Color c = original.get(i, j);

				// invert color components from each pixel
				int r = 255 - c.getRed();
				int g = 255 - c.getGreen();
				int b = 255 - c.getBlue();

				processed.set(i, j, new Color(r, g, b));
			}
		}
		
		return processed;
	}
}
