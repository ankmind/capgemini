package org.capgemini.demo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDemo {

	public static void main(String[] args) {
	
		
		File file=new File("D:\\vidavid\\fileINfo\\mydetails.txt");
		File fileCopy=new File("D:\\vidavid\\fileINfo\\copy_of_mydetails.txt");
		
		
		FileReader fileReader=null;
		FileWriter fileWriter=null;
		try {
			
			
			fileReader=new FileReader(file);
			//fileWriter=new FileWriter(fileCopy,true);
			fileWriter=new FileWriter("D:\\vidavid\\fileINfo\\copy_of_mydetails.txt",false);
			
			
			long length=file.length();
			
			for(int i=0;i<length;i++)
			{
				int chr=fileReader.read();
				
				fileWriter.write(chr);
				System.out.print((char)chr);
			}
			
			
			String mydata="Hello! I am leanring File IO";
			//fileWriter.write(mydata);
			fileWriter.write(mydata.toCharArray(),7,mydata.length()-7);
			
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				fileReader.close();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
