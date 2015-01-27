import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Senior Project Image Matching Software
 */
public class Bliffoscope {
	
	public static void main(String[] args) throws IOException, InterruptedException {

        Process p = Runtime.getRuntime().exec("java -jar ImageMatcher.jar");
        BufferedInputStream bis = new BufferedInputStream(p.getInputStream());
        synchronized (p) {
            p.waitFor();
        }

        int b;
        while((b=bis.read()) >0){
            System.out.print((char)b);
        }
    }
}