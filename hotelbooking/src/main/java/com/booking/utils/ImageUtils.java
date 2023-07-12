package com.booking.utils;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

public class ImageUtils {

	public static File uploadFile(MultipartFile file, String folderPath) {
		try {
			File path = new File(folderPath + file.getOriginalFilename());
			path.createNewFile();
			FileOutputStream output = new FileOutputStream(path);
			output.write(file.getBytes());
			output.close();
			return path;
		} catch (Exception e) {
			throw new NotFoundException(e.getMessage());
		}
	}

}
