package com.core.struct32.flag;

public class ElfFileType {

	public static final int ET_NONE=0;				//未知目标文件格式
	public static final int ET_REL=1;				//可重定位文件
	public static final int ET_EXEC=2;				//可执行文件
	public static final int ET_DYN=3;				//共享目标文件
	public static final int ET_CORE=4;				//Core 文件（转储格式）
	public static final int ET_LOPROC=0xff00;		//特定处理器文件
	public static final int ET_HIPROC=0xffff;		//特定处理器文件
	//ET_LOPROC~ET_HIPROC 0xff00~0xffff;			//特定处理器文件
	
}
