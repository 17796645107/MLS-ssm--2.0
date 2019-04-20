package com.dn.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpLoadUtil {

	private static HashMap<String, String> items;
    private FileUpLoadUtil(){
    	
    }
	public static FileUpLoadUtil upload(HttpServletRequest req) {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		try {
			 @SuppressWarnings("unchecked")
			List<FileItem> list = fileUpload.parseRequest(req);
			 items = new HashMap<String, String>();
			for (FileItem fileItem : list) {
				String name = fileItem.getFieldName();
				if (fileItem.isFormField()) {
					String value = fileItem.getString("UTF-8");
					items.put(name, value);
				} else {
					String n = UUID.randomUUID().toString() + ".jpg";
					String realPath = req.getSession().getServletContext().getRealPath("/Resources/images/products");
                    fileItem.write(new File(realPath,n));
                    /*System.out.println(realPath);*/
                    items.put(name,n);
				}
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new FileUpLoadUtil();
	}
	
	public String getParameter(String key){
		return items.get(key);
	}

}
