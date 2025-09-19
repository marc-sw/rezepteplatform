package de.hwg_lu.bwi520;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.Part;

public class ImageAccess {
	
	
	public static void uploadImage(Part part, String filepath) {
		System.out.println("uploading image to " + filepath);
		try {
			part.write(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeImage(String filepath) {
		File file = new File(filepath);
		
		if (file.exists()) {
			file.delete();
		}
		System.out.println("deleted file");
	}
}
