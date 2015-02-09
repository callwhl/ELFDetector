package com.core.util;

import com.core.struct32.flag.ElfFileType;
import com.core.struct32.flag.ElfMachine;

public class Recognizer {

	public static String recognizeElf32Type(String hex){
		String s="";
		switch(Integer.valueOf(hex)){
			case ElfFileType.ET_NONE:
				s="未知目标文件格式";
				break;
			case ElfFileType.ET_REL:
				s="可重定位文件";
				break;
			case ElfFileType.ET_EXEC:
				s="可执行文件";
				break;
			case ElfFileType.ET_DYN:
				s="共享目标文件";
				break;
			case ElfFileType.ET_CORE:
				s="Core 文件（转储格式）";
				break;
			default:
				int v=Integer.valueOf(hex);
				if( v>=ElfFileType.ET_LOPROC && 
					v<=ElfFileType.ET_HIPROC ){
					s="特定处理器文件";
				}
				break;
		}
		return s;
	}
	
	public static String recognizeElf32Machine(String hex){
		String s="";
		switch(Integer.valueOf(hex)){
			case ElfMachine.EM_NONE:
				s="未指定";
				break;
			case ElfMachine.EM_M32:
				s="AT&T WE 32100";
				break;
			case ElfMachine.EM_SPARC:
				s="SPARC";
				break;
			case ElfMachine.EM_386:
				s="Intel 80386";
				break;
			case ElfMachine.EM_68K:
				s="Motorola 68000";
				break;
			case ElfMachine.EM_88K:
				s="Motorola 88000";
				break;
			case ElfMachine.EM_860:
				s="Intel 80860";
				break;
			case ElfMachine.EM_MIPS:
				s="MIPS RS3000";
				break;
			default:
				if(Integer.valueOf(s)>=ElfMachine.OTHERS){
					s="保留";
				}
				else{
					s="未知";
				}
				break;
		}
		return s;
	}
	
}
