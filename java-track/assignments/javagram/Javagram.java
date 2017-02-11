package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import javagram.Picture;

public class Javagram {


	protected ArrayList<Filter> filter;
	protected Scanner s;

	public Javagram(){

		this.s = new Scanner(System.in);
		this.filter = new ArrayList<Filter>();

	}

	private static int displayFilterMenu(Scanner in){
		System.out.println("Select filter by choosing corresponding number");
		System.out.println("1. BlueFilter");
		System.out.println("2. InvertFilter");
		System.out.println("3. BrightnessFilter");

		int selectedInt = in.nextInt();
		return selectedInt;
	}

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath = null;
		Picture picture = null;
		Scanner in = new Scanner(System.in);






		// prompt user for image to filter and validate input

		do {

			String imagePath = "path not set";

			// try to open the file
			try {

				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();

				imagePath = dir + File.separator + relPath;

				picture = new Picture(imagePath);

			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}

		} while(picture == null);

		// TODO - prompt user for filter and validate input



		int x = 0;
		Javagram fm = new Javagram();

		do {

			try{
				x = Javagram.displayFilterMenu(in);
				if(x < 0 || x > 3){
					System.out.println("Please enter valid interger");
				}
			}catch (InputMismatchException e) {
				System.out.println("Input number not an interger");

				//fm.processInput(x);
			}

		} while (x < 0 || x > 3);


		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
		Filter filter = getFilter(x);			

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();

		System.out.println("Image successfully filtered");

		// save image, if desired
		boolean invalidFilename = true;
		do  {
			System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
			System.out.println(relPath);
			String fileName = in.next();
			String fileNameHolder = fileName;


			if(fileName.equals("yes")|| fileName.equals("Yes")|| fileName.equals("y") || fileName.equals("Y")){
				System.out.println("Enter file name:");

				if(!fileName.equals(relPath)){
					fileName = in.next();
					String absFileName = dir + File.separator + fileName;
					processed.save(absFileName);
					System.out.println("Image saved to " + absFileName);
					invalidFilename = false;
				}
			}
			// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original


			if (fileName.equals("exit")) {
				System.out.println("Image not saved");
				invalidFilename = false;
				in.close();
				System.exit(0);
			}


			do {

				if (fileName.equals(relPath)){
					System.out.println("Do you want to overwrite the original picture? (type 'yes' to overwrite original file or no to save with different file name)");
					fileName = in.next();

					if(fileName.equals("yes")|| fileName.equals("Yes")|| fileName.equals("y") || fileName.equals("Y")) {
						String absFileName = dir + File.separator + fileNameHolder;
						processed.save(absFileName);
						System.out.println("Image saved to " + absFileName);
						invalidFilename = false;
						in.close();
						System.exit(0);
					} 

					else if (fileName.equals("no")|| fileName.equals("No")|| fileName.equals("n") || fileName.equals("N")){
						System.out.println("Please enter a different name to save picture");
						fileName = in.next();
						if (fileName.equals(relPath)){
							System.out.println("Could not save picture please try again");
							invalidFilename = false;

						} else {

							String absFileName = dir + File.separator + fileNameHolder;
							processed.save(absFileName);
							System.out.println("Image saved to " + absFileName);
							invalidFilename = false;
							in.close();
							System.exit(0);
						}
					}
				}
			} while (!fileName.equals("Yes") || !fileName.equals("yes") || !fileName.equals("Y") || !fileName.equals("y") || !fileName.equals("No") || 
					!fileName.equals("no") || !fileName.equals("n") || !fileName.equals("N"));




		} while (invalidFilename);

		// close input scanner
		in.close();

	}


	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	private static Filter getFilter(int x) {



		// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
		if(x < 0 || x > 3) {
			throw new IllegalArgumentException();
		}


		// TODO - create some more filters, and add logic to return the appropriate one
		if(x == 1){
			return new BlueFilter();
		}

		else if (x == 2) {
			return new InvertFilter();
		}
		
		else if (x == 3) {
			return new BrightnessFilter();
		}
		
		else return new BlueFilter();
	}
}