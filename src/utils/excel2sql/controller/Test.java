package utils.excel2sql.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		File file = new File("test0126.txt");
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("test");
			fw.flush();
			fw.close();
			
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while (bufferedReader.ready()) {
				System.out.println(bufferedReader.readLine());
			}
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
