import java.awt.Point;

/**
 * Represents a match of the pattern image within the source image
 */
public class Match {

    public ImageHandler patterHandler;
	public char[][] subImage; // Pattern Handler
	public Point location;              // Match Location
	public int numberOfHits;              // PHashed Hamming difference

    public Match(ImageHandler patterHandler, char[][] subImage, Point location, int numberOfHits) {
        this.patterHandler = patterHandler;
        this.subImage = subImage;
        this.location = location;
        this.numberOfHits = numberOfHits;
    }

    public void printMatch(){
        System.out.println(this.patterHandler.getName() + " Match!");
        System.out.println("Location ((0,0) Top Left): (" + this.location.x + "," + this.location.y + ")");
        System.out.println("Number of Hits (Matching Pixels): " + this.numberOfHits + " out of " + this.patterHandler.getTotalPixels());
        int percent = (int)((this.numberOfHits * 100.0f) / this.patterHandler.getTotalPixels());
        System.out.println("Match percentage: " + percent);
        System.out.println("Sub Image:");
        ImageHandler.printImage(subImage);
        System.out.println("");
    }
}