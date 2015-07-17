package org.capgemini.demo;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoByteIO {

	public static void main(String[] args) {
		

		File file=new File("D:\\vidavid\\Training\\buffIO.txt");
		FileOutputStream fout=null;
		BufferedOutputStream bout=null;
		try {
			fout=new FileOutputStream(file);
			bout=new BufferedOutputStream(fout);
			
			
			String myInput="Welcome To Buffered I/O operations!!!";
			
			
			byte[] mybytes=myInput.getBytes();
			
			
			bout.write(mybytes);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bout.close();
				fout.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		/*BufferedReader bf;
		BufferedWriter bw;
		*/
		
		
	}

}
