import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Handles File to 2d char array transformation
 *
 */
public class ImageHandler {
	
	private char[][] image;     // Handled Image
	private String name = "";	// Image Name

	/**
	 * Constructor
	 *
	 * Handles File Validation/Initializes 2D Char Array
	 *
	 * @param imageFile - Image File
	 */
	public ImageHandler(File imageFile) {
		try {
            //List to store strings representing a line of the file
            ArrayList<String> imageList = new ArrayList<String>();
            //Create the buffered reader to read the file
            BufferedReader br = new BufferedReader(new FileReader(imageFile));
            //Store the string for the given line
            String str;
            //Loop over all lines of the file
            while ((str = br.readLine()) != null) {
                //Add the line to the list of lines
                imageList.add(str);
            }
            //Close the reader since we have read the entire file
            br.close();
            //Init the 2d Char array with the correct size.
            image = new char[imageList.size()][0];
            int i=0;
            //Loop through each line and fill in the 2D char array
            for(String s:imageList){
                image[i]=s.toCharArray();
                i++;
            }
            //Set the name to be the name of the file
            name = imageFile.getName();


		} catch (FileNotFoundException e) {
            //Cannot read a file which does not exist
			System.err.println("Unable to find file @ " + imageFile.getAbsolutePath());
			System.exit(1);
		} catch (IOException e) {
            //Error with the reading of a file which does exist.
			System.err.println("Error reading file @ " + imageFile.getAbsolutePath());
			System.exit(1);
		}
	}

	public char[][] getImage() {
		return image;
	}

	public void setImage(char[][] image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    /**
     * Print an image to the console
     * @param image - The image you want to print
     */
    public static void printImage(char[][] image) {
        for (char[] arr : image) {
            StringBuilder builder = new StringBuilder();
            for (char value : arr) {
                builder.append(value);
            }
            String text = builder.toString();
            System.out.println(text);
        }
    }

    /**
     * Get a sub image from the entire image.
     * @param y - Y offset to start at starting from top left
     * @param x - X offset to start at starting from top left
     * @param h - The height of the sub image you want to get
     * @param w - The width of the sub image you want to get
     * @return - A 2d char array which represents the sub image
     */
    public char[][] getSubImage(int y, int x, int h, int w){
        //The highest y you want to iterate to. Does not let you go out of bounds of the larger image
        int yIter = y + h < this.image.length ? y + h : this.image.length;
        //The highest x you want to iterate to. Does not let you go out of bounds of the larger image
        int xIter = x + w < this.image[0].length ? x + w : this.image[0].length;

        char[][] subImage = new char[yIter - y][xIter - x];
        //Starting at the offset, loop over the rows to get the sub-image
        for (int i = y, j = 0; i < yIter; i++, j++) {
            subImage[j] = Arrays.copyOfRange(this.image[i], x, xIter);
        }

        return subImage;
    }

    /**
     * Get the total number of pixels in the image
     * @return - Total number of pixels in the image
     */
    public int getTotalPixels(){
        return this.image.length * this.image[0].length;
    }

    /**
     * Get the number of pixes which match the given subImage
     * @param subImage - The given sub image to check a match against.
     * @return int - the number of pixels which match in the two images.
     */
    public int getNumberOfHits(char[][] subImage){
        int matches = 0;
        for (int i =0; i < this.image.length; i++){
            for (int j = 0; j < this.image[i].length; j++){
                char current = this.image[i][j];
                char subImageCurrent = subImage[i][j];
                if(current == subImageCurrent){
                    matches++;
                }
            }
        }

        return matches;
    }
}