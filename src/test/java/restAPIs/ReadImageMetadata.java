package restAPIs;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import android.provider.MediaStore.Files;

public class ReadImageMetadata 
{
    public static void main(String[] args)
    {	
		File file =new File("/Users/eamon.myles/Desktop/verizon_suite/DareDevil.png");
		
		if(file.exists()){
			
			long bytes = file.length();
			String name = file.getName();
			String ext = name.substring(name.lastIndexOf('.') + 1);
			double kilobytes = (bytes / 1024);
			double megabytes = (kilobytes / 1024);

			
			System.out.println("bytes : " + bytes);
			System.out.println("kilobytes : " + kilobytes);
			System.out.println("name : " + name);
			System.out.println("ext : " + ext);

		}else{
			 System.out.println("File does not exists!");
		}
    }
}

