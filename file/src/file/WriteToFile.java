package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;


public class WriteToFile {
	public static void Wirte_FileWriter(String fileName, String content1){
		try {
			String content = content1;

			File file = new File( fileName );

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void Wirte_FileOutputStream(String fileName, String content1) {
		File file = new File( fileName );
		String content = content1;

		try (FileOutputStream fop = new FileOutputStream(file)) {
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String fileName = "test.txt";
		String content = "new write!";

		WriteToFile.Wirte_FileWriter(fileName, content);
		WriteToFile.Wirte_FileWriter(fileName, "write end. \n");

		ReadFromFile.readFileByLines(fileName);

		WriteToFile.Wirte_FileOutputStream(fileName, content);
		WriteToFile.Wirte_FileOutputStream(fileName, "write end. \n");

		ReadFromFile.readFileByLines(fileName);
	}
}


