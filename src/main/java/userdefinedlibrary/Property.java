package userdefinedlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property {

public String readPropertiesFile(String keyAttribute) throws IOException {
	FileInputStream fis = null;
	Properties prop = null;
	String returnValue = null;
	try {
		fis = new FileInputStream(new File(System.getProperty("user.dir")+"/Properties/master.properties"));
		prop = new Properties();
		prop.load(fis);
		returnValue = prop.getProperty(keyAttribute);

	} catch(FileNotFoundException fnfe) {
		fnfe.printStackTrace();
	} catch(IOException ioe) {
		ioe.printStackTrace();
	} finally {
		fis.close();
	}
	return returnValue;
}

}
