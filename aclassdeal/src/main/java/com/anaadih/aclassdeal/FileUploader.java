package com.anaadih.aclassdeal;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

/**
 * 
 * @author paras
 *
 */

@Component
public class FileUploader {
	
	public static boolean uploadFile(String flushedImg, String path, String fileName, String userId){
		byte[] fileData = null;
		try {
			fileData = Base64.decodeBase64(flushedImg);
		} catch (Exception e1) {
		}
		try {
			if(path!=null){
				//(new File(path)).mkdirs();
				File newFile = new File(path);
				newFile.mkdirs();
				newFile.setWritable(true);
			}
			FileOutputStream fos = null;
			try{
				fos = new FileOutputStream(path+File.separator+fileName);
				fos.write(fileData);
				fos.close();
				}catch(Exception e){
				}
				finally{
					if(fos != null){
						fos.close();
					}
				}
			return true;
		} catch (Exception e) {
		} 
		return false;
	}
	
	public String getFilePath(String imgName,String userName) {
		return userName;
		
	}

}
