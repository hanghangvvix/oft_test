package ct.oft.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 生成TXT文件
 * 
 * @author cxj
 * 
 */
public class TxtUtils {

	public static int writeTxtFile(String filePath, String fileName, String content) {

		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdir();
			// System.out.println("文件夹已创建");
		}
		// 定义文件名格式并创建
		String filenameTemp = filePath + fileName + IPARAM.INVEST_ORDER_FILE_TYPE;
		File txtFile = new File(filenameTemp);
		if (txtFile.exists()) {
			txtFile.delete();
			try {
				txtFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
		}
		// File txtFile = null;
		// try {
		// txtFile = File.createTempFile(fileName, ".txt", new File(filePath));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// return -1;
		// }
		// 进行写入操作
		FileWriter writer = null;
		try {
			writer = new FileWriter(txtFile, true);
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
			return -2;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(writeTxtFile(IPARAM.INVEST_ORDER_FILE_PATH, "65564654564", "123123123123123你好得多"));

	}

}
