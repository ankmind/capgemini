package org.capgemini.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrintReverse {

	public static void main(String[] args) {
		
		File file=new File("D:\\vidavid\\Training\\2015\\Barclays\\Demo\\Day12-FILEIO\\src\\org\\capgemini\\demo\\FileDemo.java");
		

		try {
			FileReader fread=new FileReader(file);
			
			long size=file.length();
			
			char[] chr=new char[(int)size];
			
			fread.read(chr);
			
			/*for(int i=0;i<size;i++)
				chr[i]=(char)fread.read();
			*/
			
			
			for(int i=(int)size-1;i>=0;i--){
				System.out.print(chr[i]);
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
