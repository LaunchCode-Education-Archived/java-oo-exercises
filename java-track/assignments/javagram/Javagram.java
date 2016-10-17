package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Javagram {

	private static final HashMap<Integer, Filter> filters = getFilterMap();

	public static void main(String[] args) {

		// Create the base path for images
		String[] baseParts = { System.getProperty("user.dir"), "images" };
		String dir = String.join(File.separator, baseParts);
		String relPath;
		String imagePath;
		Picture picture = null;
		Filter filter = null;
		Scanner in = new Scanner(System.in);

		// prompt user for image to filter and validate input
		do {

			imagePath = "path not set";

			// try to open the file
			try {

				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();

				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));

				picture = new Picture(imagePath);

			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
		} while (picture == null);

		
		// Prompt user for filter and validate input
		do {
			Integer filterID = displayFilterMenu(in);

			// Pass filter ID int to getFilter, and get an instance of Filter back
			try {
				filter = getFilter(filterID);
				
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid entry. Make another selection.");
			}
		} while (filter == null);

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();

		System.out.println("Image successfully filtered");

		// save image, if desired

		while (true) {
			// prompt user for filename to save filtered picture as
			System.out.println("Save image to (relative to " + dir + ") (enter 'exit' to quit w/o saving):");
			String fileName = in.next();
			String absFileName = dir + File.separator + fileName;
			boolean saveImage = true;

			// over-writing the original image
			if (absFileName.equals(imagePath)) {

				while (true) {
					System.out.println("Are you sure you want to save over the original image?");
					System.out.println("Enter 'yes' or 'no':");
					String saveOverImage = in.next();

					if (saveOverImage.equals("yes")) {
						break;
					} else if (saveOverImage.equals("no")) {
						saveImage = false;
						break;
					} else {
						System.out.println("Invalid input. Enter 'yes' or 'no':\n");
						in.nextLine();
					}
				}
			}

			if (fileName.equals("exit")) {
				System.out.println("Image not saved");
				break;

			} else {
				if (saveImage) {
					processed.save(absFileName);
					System.out.println("Image saved to " + absFileName);
					break;
				} else {
					saveImage = true;
				}
			}
		}
		// close input scanner
		in.close();
	}

	private static Filter getFilter(Integer id) {

		if (filters.containsKey(id)) {
			return filters.get(id);
		} else {
			throw new IllegalArgumentException("Filter not found");
		}
	}

	private static int displayFilterMenu(Scanner in) {
		
		int filterID;
		while (true) {
			System.out.println();
			System.out.println("Select filter:");
			System.out.println("1: Blue");
			System.out.println("2: Invert");
			System.out.println("3: Brighten");
			System.out.println("4: Grayscale");

			try {
				filterID = in.nextInt();
				break;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Invalid input. Make an integer selection.");
				in.nextLine();
			}
		}
		return filterID;
	}

	private static HashMap<Integer, Filter> getFilterMap() {

		HashMap<Integer, Filter> filters = new HashMap<Integer, Filter>();
		filters.put(1, new BlueFilter());
		filters.put(2, new InvertFilter());
		filters.put(3, new BrightnessFilter());
		filters.put(4, new GrayscaleFilter());

		return filters;
	}

}