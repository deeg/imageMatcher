import java.awt.*;

/**
 * Compares a pattern image to a source image
 */
public abstract class ImageComparator {

	/**
	 * Kicks off the pattern and source image comparison
	 */
	public static void compare(ImageHandler patternHandler, ImageHandler sourceHandler) {
        char[][] sourceImage = sourceHandler.getImage();
        char[][] patternImage = patternHandler.getImage();

        /**
         * Loop over all pixels in the image
         *  EXCEPT except when you would go out of bounds searching for the size of the picture.
         *
         *  Determine how many pixes are hits with our pattern image.
         */
        for(int i = 0; i < sourceImage.length - patternImage.length + 1; i++){
            for(int j = 0; j < sourceImage[0].length - patternImage[0].length + 1; j++){
                char[][] subImage = sourceHandler.getSubImage(i, j, patternImage.length, patternImage[0].length);
                int hits = patternHandler.getNumberOfHits(subImage);
                int percent = (int)((hits * 100.0f) / patternHandler.getTotalPixels());
                if(percent > 70){
                    Match match = new Match(patternHandler, subImage, new Point(j, i), hits);
                    match.printMatch();
                }
            }
        }
	}
}