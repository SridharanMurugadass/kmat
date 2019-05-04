package com.kmat.service.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

	public static File create(String pathname, byte[] bytes) {
		File file = new File(pathname);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(bytes);
		} catch (Exception e) {
			// TODO throw error
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO throw error
				}
			}
		}
		return file;
	}
}