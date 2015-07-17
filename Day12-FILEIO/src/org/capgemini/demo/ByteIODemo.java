package org.capgemini.demo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteIODemo {

	public static void main(String[] args) {
	
		File file=new File("D:\\vidavid\\Training\\2015\\Barclays\\Demo\\Day12-FILEIO\\src\\org\\capgemini\\demo\\FileDemo.java");
		FileInputStream fin=null;
		BufferedInputStream bin=null;
		try {
			fin = new FileInputStream(file);
			bin=new BufferedInputStream(fin);
			long len=file.length();
			
			for(long i=0; i<len;i++ )
				System.out.print((char)bin.read());
			
			//bin.re
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bin.close();
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
