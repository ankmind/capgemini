package org.capgemini.demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FormattedInDemo {

	public static void main(String[] args) {
		
		File file=new File("D:\\vidavid\\fileINfo\\studentInfo.txt");
		
		String sName="TomJerry";
		int regNo=12345;
		float fees=34000;
		char gender='M';
		boolean isPartTime=true;
		
		
		
		FileOutputStream fout=null;
		DataOutputStream dout=null;
		
		
		
		
		try {
			fout=new FileOutputStream(file);
			dout=new DataOutputStream(fout);
			
			dout.writeChar((int)gender);
			dout.writeInt(regNo);
			dout.writeFloat(fees);
			dout.writeBoolean(isPartTime);
			dout.writeBytes(sName);
			
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dout.close();
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		FileInputStream fin=null;
		DataInputStream din=null;
		
		try {
			fin=new FileInputStream(file);
			din=new DataInputStream(fin);
			
			
			
			char sgender=din.readChar();
			int sno=din.readInt();
			float sfees=din.readFloat();
			boolean status=din.readBoolean();
			byte[] mysName=new byte[sName.length()];
			din.read(mysName);
			
			String str=new String(mysName);
			
			
			System.out.println("Student Name:" + str);
			System.out.println("Student Number:" + sno);
			System.out.println("Fees:" + sfees);
			System.out.println("Gender : " + sgender);
			System.out.println("Is PArtTime :"  + status);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				din.close();
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
