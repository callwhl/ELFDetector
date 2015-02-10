package com.core.struct32.flag;

public class ElfProgramType {
	
	public static final int PT_NULL=0;               	/* Program header table entry unused */
	public static final int PT_LOAD=1;               	/* Loadable program segment */
	public static final int PT_DYNAMIC=2;               /* Dynamic linking information */
	public static final int PT_INTERP=3;               	/* Program interpreter */
	public static final int PT_NOTE=4;               	/* Auxiliary information */
	public static final int PT_SHLIB=5;               	/* Reserved */
	public static final int PT_PHDR=6;               	/* Entry for header table itself */
	public static final int PT_TLS=7;               	/* Thread-local storage segment */
	public static final int PT_NUM=8;               	/* Number of defined types */
	public static final int PT_LOOS=0x60000000;      	/* Start of OS-specific */
	public static final int PT_GNU_EH_FRAME=0x6474e550; /* GCC .eh_frame_hdr segment */
	public static final int PT_LOSUNW=0x6ffffffa;
	public static final int PT_SUNWBSS=0x6ffffffa;      /* Sun Specific segment */
	public static final int PT_SUNWSTACK=0x6ffffffb;    /* Stack segment */
	public static final int PT_HISUNW=0x6fffffff;
	public static final int PT_HIOS=0x6fffffff;      	/* End of OS-specific */
	public static final int PT_LOPROC=0x70000000;      	/* Start of processor-specific */
	public static final int PT_HIPROC=0x7fffffff;      	/* End of processor-specific */
	
}
