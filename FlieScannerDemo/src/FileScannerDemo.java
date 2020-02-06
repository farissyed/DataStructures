import java.io.File;
import java.util.Scanner;

public class FileScannerDemo {

    public static void main( String[] args ) {
    	
    	Scanner scan = null;
    	
    	try {
    		File f = new File ("./src/Foods.txt");
    		
    	} catch ( Exception e ) {
    		System.out.println( e );
    	} finally {
    		if (scan != null) {
    			scan.close();
    		}
    	}
    }

}
