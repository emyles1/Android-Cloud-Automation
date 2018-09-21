package restAPIs;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

import android.provider.MediaStore.Files;

public class UploadMedia {
	
	public static void main(String[] args) {
	System.out.println("Test main method");
	
	Dimension path = getImageDim("/Users/eamon.myles/Desktop/verizon_suite/DareDevil-1.png");
	System.out.println(path);
	
	

	
	
	}
	
	private static Dimension getImageDim(final String path) {
		
		System.out.println("DimensionMethod" +path);
	    Dimension result = null;
	    //String suffix = this.getFileSuffix(path);
	    String suffix = getFileSuffix(path);
	    Iterator<ImageReader> iter = ImageIO.getImageReadersBySuffix(suffix);
	    if (iter.hasNext()) {
	        ImageReader reader = iter.next();
	        try {
	            ImageInputStream stream = new FileImageInputStream(new File(path));
	            reader.setInput(stream);
	            

	            
	            int width = reader.getWidth(reader.getMinIndex());
	            int height = reader.getHeight(reader.getMinIndex());
	            result = new Dimension(width, height);
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            reader.dispose();
	        }
	    } else {
	        //log("No reader found for given format: " + suffix));
	        System.out.println("No reader found for given format: " + suffix);
	    }
	    System.out.println("Printing result from second method" + result);
	    return result;
	}
	
	public static String getFileSuffix(final String path) {
		System.out.println("getFileSuffix method");
	    String result = null;
	    if (path != null) {
	        result = "";
	        if (path.lastIndexOf('.') != -1) {
	            result = path.substring(path.lastIndexOf('.'));
	            if (result.startsWith(".")) {
	                result = result.substring(1);
	            }
	        }
	    }
	    return result;
	}

}

