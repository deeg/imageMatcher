import java.util.ArrayList;

/**
 * Contains constants used throughout the classes
 */
public class Constants {

	// Set number of comparison threads to number of cores
	public static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();
	
	// Valid handled pattern parameter flags
	@SuppressWarnings("serial")
	public static final ArrayList<String> VALID_PATTERN_FLAGS = new ArrayList<String>() {{
		add("-p");
		add("-pdir");
		add("--pdir");
	}};

	// Valid handled source parameter flags
	@SuppressWarnings("serial")
	public static final ArrayList<String> VALID_SOURCE_FLAGS = new ArrayList<String>() {{
		add("-s");
		add("-sdir");
		add("--sdir");
	}};
}
