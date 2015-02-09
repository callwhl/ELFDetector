package com.core.struct32;

import com.core.struct32.type32.Elf32_Addr;
import com.core.struct32.type32.Elf32_Half;
import com.core.struct32.type32.Elf32_Ident;
import com.core.struct32.type32.Elf32_Off;
import com.core.struct32.type32.Elf32_Word;
/**
 * ELF Header
 * @author ASUS
 *
 */
public class Elf32_Ehdr {
	
	protected Elf32_Ident e_ident;  	/*开头4字节保持不变：0x7F 0x45 0x4C 0x46标明这是一个ELF文件*/
	protected Elf32_Half e_type;        /*文件类型*/
	protected Elf32_Half e_machine;     /*程序所运行的CPU体系结构*/
	protected Elf32_Word e_version;     /*文件版本*/
	protected Elf32_Addr e_entry;       /*程序入口*/
	protected Elf32_Off  e_phoff;      	/*Program header table在文件中的偏移*/
	protected Elf32_Off  e_shoff;       /*Section header table在文件中的偏移*/
	protected Elf32_Word e_flags;       /*对于IA32而言，此项为0*/
	protected Elf32_Half e_ehsize;      /*ELF header大小*/
	protected Elf32_Half e_phentsize;   /*Program header table每一个条目的大小*/
	protected Elf32_Half e_phnum;		/*Program header table中有多少个条目*/
	protected Elf32_Half e_shentsize;   /*Section header table中每一个条目的大小*/
	protected Elf32_Half e_shnum;      	/*Section header table中有多少个条目*/
	protected Elf32_Half e_shstrndx;    /*包含节名称的字符串表示第几个节（从零开始数）*/

	public Elf32_Ident getE_ident() {
		return e_ident;
	}

	public void setE_ident(Elf32_Ident eIdent) {
		e_ident = eIdent;
	}

	public Elf32_Half getE_type() {
		return e_type;
	}

	public void setE_type(Elf32_Half eType) {
		e_type = eType;
	}

	public Elf32_Half getE_machine() {
		return e_machine;
	}

	public void setE_machine(Elf32_Half eMachine) {
		e_machine = eMachine;
	}

	public Elf32_Word getE_version() {
		return e_version;
	}

	public void setE_version(Elf32_Word eVersion) {
		e_version = eVersion;
	}

	public Elf32_Addr getE_entry() {
		return e_entry;
	}

	public void setE_entry(Elf32_Addr eEntry) {
		e_entry = eEntry;
	}

	public Elf32_Off getE_phoff() {
		return e_phoff;
	}

	public void setE_phoff(Elf32_Off ePhoff) {
		e_phoff = ePhoff;
	}

	public Elf32_Off getE_shoff() {
		return e_shoff;
	}

	public void setE_shoff(Elf32_Off eShoff) {
		e_shoff = eShoff;
	}

	public Elf32_Word getE_flags() {
		return e_flags;
	}

	public void setE_flags(Elf32_Word eFlags) {
		e_flags = eFlags;
	}

	public Elf32_Half getE_ehsize() {
		return e_ehsize;
	}

	public void setE_ehsize(Elf32_Half eEhsize) {
		e_ehsize = eEhsize;
	}

	public Elf32_Half getE_phentsize() {
		return e_phentsize;
	}

	public void setE_phentsize(Elf32_Half ePhentsize) {
		e_phentsize = ePhentsize;
	}

	public Elf32_Half getE_phnum() {
		return e_phnum;
	}

	public void setE_phnum(Elf32_Half ePhnum) {
		e_phnum = ePhnum;
	}

	public Elf32_Half getE_shentsize() {
		return e_shentsize;
	}

	public void setE_shentsize(Elf32_Half eShentsize) {
		e_shentsize = eShentsize;
	}

	public Elf32_Half getE_shnum() {
		return e_shnum;
	}

	public void setE_shnum(Elf32_Half eShnum) {
		e_shnum = eShnum;
	}

	public Elf32_Half getE_shstrndx() {
		return e_shstrndx;
	}

	public void setE_shstrndx(Elf32_Half eShstrndx) {
		e_shstrndx = eShstrndx;
	}
	
}
