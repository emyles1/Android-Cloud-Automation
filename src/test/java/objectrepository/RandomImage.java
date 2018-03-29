/*
 * package objectrepository;
 * 
 * import java.io.File; import java.io.IOException; import
 * java.net.MalformedURLException; import java.awt.image.BufferedImage; import
 * javax.imageio.ImageIO; import org.apache.commons.io.FileUtils; import
 * org.openqa.selenium.WebElement; import
 * io.appium.java_client.android.AndroidDriver; import testcases.CloudBaseTest;
 * 
 * public class RandomImage extends CloudBaseTest {
 * 
 * public static void main(String args[])throws IOException,
 * MalformedURLException, InterruptedException { AndroidDriver<WebElement>
 * driver = Capabilities(); // Image file dimensions int width = 640, height =
 * 318;
 * 
 * // Create buffered image object BufferedImage img = null; img = new
 * BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
 * 
 * // file object File f = null;
 * 
 * // create random values pixel by pixel for (int y = 0; y < height; y++) { for
 * (int x = 0; x < width; x++) { int a = (int)(Math.random()*256); //generating
 * int r = (int)(Math.random()*256); //values int g = (int)(Math.random()*256);
 * //less than int b = (int)(Math.random()*256); //256
 * 
 * int p = (a<<24) | (r<<16) | (g<<9) | b; //pixel
 * 
 * img.setRGB(x, y, p); } }
 * 
 * // write image int a = (int)(Math.random()*256); try
 * 
 * {
 * 
 * f = new File("/Users/eamon.myles/Desktop/Out"+ a +".jpg");
 * 
 * ImageIO.write(img, "jpg", f); } catch(IOException e) {
 * System.out.println("Error: " + e); }
 * 
 * 
 * //pushes the file to the device. byte[] content =
 * FileUtils.readFileToByteArray(f);
 * driver.pushFile("/sdcard/pictures/screenshots/Out"+ a +".jpg", content);
 * 
 * 
 * } }
 */