package com.core;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import com.core.manager.ElfManager;

public class Main {

	public static void main(String[] arg){
		try{
			//String filePath="C:\\Users\\Administrator\\Desktop\\一键APKTOOL_v1.5.3\\hsp\\assets\\ijm_lib\\x86\\libexec.so";
			String filePath="C:\\Users\\Administrator\\Desktop\\一键APKTOOL_v1.5.3\\hsp\\assets\\ijm_lib\\x86\\libexecmain.so";
			File f=new File(filePath);
			FileChannel channel=new FileInputStream(f).getChannel();
			MappedByteBuffer fileMemMap=channel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			ElfManager em=new ElfManager(fileMemMap);
			em.printElfHeader();
			em.printElfProgramHeaderTable();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
