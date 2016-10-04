package javagram.filters;

import java.awt.Color;
import javagram.Picture;

public class MonochromeFilter implements Filter {

	Color color;
	
	public MonochromeFilter(Color color){
		this.color = color;
	}
	
	@Override
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

				int value = (r + g + b) / 3;
				float valuePct = (float) value / (float) 255;
				
				int r2 = (int) (this.color.getRed() * valuePct);
				int g2 = (int) (this.color.getGreen() * valuePct);
				int b2 = (int) (this.color.getBlue() * valuePct);

				processed.set(i, j, new Color(r2, g2, b2));

			}
		}

		return processed;
	}

}
