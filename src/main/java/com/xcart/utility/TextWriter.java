package com.xcart.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextWriter {
	
	String timestamp = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(new Date());
	File f = new File(System.getProperty("user.dir") + "/src/test/resources/com/xcart/text/ProductInfo_"+ timestamp+ ".txt" );
	
	public void writeToFile(String value) throws IOException {
		FileWriter fw = new FileWriter(f, true);
		fw.write(value);
		fw.write("\n");
		fw.close();
	}

}
