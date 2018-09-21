package restAPIs;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.testng.Assert;

import objectrepository.Strings;

public class RunBash {

public static void main(String[] args) throws InterruptedException, IOException {
    
	String[] cmdScript = new String[]{"/bin/bash", "/Users/eamon.myles/Desktop/verizon_suite/upload_files.sh"}; 
	Process procScript = Runtime.getRuntime().exec(cmdScript);

	
//	try {
//		//Run the process
//		Process p =Runtime.getRuntime().exec("sh /Users/eamon.myles/Desktop/verizon_suite/upload_files.sh");
//		// Get the input stream
//		InputStream is = p.getInputStream();
//		
//		//Read script execution results
//		int i =0;
//		StringBuffer sb = new StringBuffer();
//		while ((i = is.read()) != -1)
//			sb.append((char)i);
//		System.out.println(sb.toString());
//	}catch (IOException e) {
//		e.printStackTrace();
//	}
	
	
	//Process procBuildScript = new ProcessBuilder("/Users/eamon.myles/Desktop/verizon_suite/upload_files.sh").start();
	
}
}
	
	

	

