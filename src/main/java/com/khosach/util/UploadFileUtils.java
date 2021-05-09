/*
 * @author THUAN-PHAN
 * @date May 13, 2020
 * @version 1.0
 */

package com.khosach.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class UploadFileUtils {

	
	//public final String root = "/usr/var";
	
	public void writeOrUpdate(byte[] bytes, String path, String path2) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		try (FileOutputStream fileOutputStream = new FileOutputStream(new File(path2))) {
			fileOutputStream.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
