package java76.pms.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.coobird.thumbnailator.Thumbnails;

public class MultipartHelper {

	public static Map<String,String> parseMultiDate 
	(HttpServletRequest request, String dir) throws ServletException {
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(request);

			HashMap<String,String> map = new HashMap<>();

			String filename = null; 
			for (FileItem item : items) {
				if (item.isFormField()) {
					map.put(item.getFieldName(), item.getString("UTF-8"));
				} else {
					if (item.getSize() > 0) {
						filename = generatefilename(item.getName());
						File file = new File(dir + "/" + filename);
						item.write(file);
						map.put(item.getFieldName(), filename);
						
						Thumbnails
						.of(file.getPath())
						//.sourceRegion(Positions.CENTER, 300, 300) // 화면 줄이지않고 부분만 갈취
						//.outputQuality(1.0)
						.size(60,60)
						.toFile(dir + "/thumbnail/s-" + filename);
					}
				}
			}

			return map;

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private static String generatefilename(String name) {
		int dot = name.lastIndexOf(".");
		String ext = "";
		if (dot > -1) {
			ext = name.substring(dot);
		}
		return String.format("file-%d-%d%s", 
				System.currentTimeMillis(), count(), ext);
	}

	static int count = 0;
	synchronized private static int count() {
		if (count > 100000) {
			count = 0;
		}
		return ++count;
	}
}
