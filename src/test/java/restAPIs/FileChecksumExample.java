package restAPIs;

import javax.xml.bind.DatatypeConverter;
import java.io.File;

public class FileChecksumExample {

    public static void main(String[] args) throws Exception {

        File file = new File("/Users/eamon.myles/Desktop/verizon_suite/DareDevil.png");

        System.out.println("MD5    : " + toHex(Hash.MD5.checksum(file)));
        System.out.println("SHA1   : " + toHex(Hash.SHA1.checksum(file)));
        System.out.println("SHA256 : " + toHex(Hash.SHA256.checksum(file)));
        System.out.println("SHA512 : " + toHex(Hash.SHA512.checksum(file)));
        
    }

    private static String toHex(byte[] bytes) {
        return DatatypeConverter.printHexBinary(bytes);
    }

}