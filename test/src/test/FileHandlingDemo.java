package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlingDemo {
	public static void main(String[] args) throws IOException {
		//1. create file using makedirs()
		File file=new File("/home/macbook/Documents/New Folder");
		if (file.exists()) {
			System.out.println("already New Folder is exists");
		} else {
			file.mkdirs();
			System.out.println("New Folder is created");
		}
		//2.create new file using createNewFile()
		File newFile=new File("/home/macbook/Documents/New Folder/NewFile.txt");
		if (newFile.exists()) {
			System.out.println("NewFile already exits");
		} else {
			newFile.createNewFile();
			System.out.println("NewFile.txt is created");
		}
		//3.Write on file Using FileWriter
		FileWriter fw=new FileWriter("/home/macbook/Documents/New Folder/NewFile.txt");
		fw.write("Hello Friends chai pilo\n");
		fw.write("Hello Friends coffee pilo");
		fw.flush();
		System.out.println("writing is successful");
		//4.Read file using FileReader
		FileReader fr=new FileReader("/home/macbook/Documents/New Folder/NewFile.txt");
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		while (line!=null) {
			System.out.println(line);
			line=br.readLine();
		}
	}
}
