package org.capgemini.demo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) {
	
		File file=new File("D:\\vidavid\\Training\\MyDetails.txt");
		
		if(file.isFile()){
			System.out.println("This is File");
			
			
			System.out.println("File Readable:" + file.canRead());
			System.out.println("Last Modified:" + new Date(file.lastModified()));
			
			
		}else if(file.isDirectory()){
			System.out.println("This is Diectory");
			
			String[] listFile=file.list();
			
			for(String fname:listFile)
				System.out.println(fname);
			
		}else
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("Size:" + file.length());
		
		
		//file.delete();
		
	}

}
