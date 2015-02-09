package com.core.struct32;

import com.core.struct32.type32.Elf32_Addr;
import com.core.struct32.type32.Elf32_Off;
import com.core.struct32.type32.Elf32_Word;

/**
 * Program Header
 * @author ASUS
 *
 */
public class Elf32_Phdr {
	
	protected Elf32_Word p_type; //Program Header所描述的段类型
	protected Elf32_Off p_offset;//段的第一个字节在文件中的偏移
	protected Elf32_Addr p_vaddr;//段的第一个字节在内存中的虚拟地址
	protected Elf32_Addr p_paddr;//在物理地址定位相关的系统中，此项为物理地址保留
	protected Elf32_Word p_filesz;//段在文件中的长度
	protected Elf32_Word p_memsz;//段在内存中的长度
	protected Elf32_Word p_flags;//与段相关的标志
	protected Elf32_Word p_align;//段在文件以及在内存中的对齐
	
	public Elf32_Word getP_type() {
		return p_type;
	}
	public void setP_type(Elf32_Word pType) {
		p_type = pType;
	}
	public Elf32_Off getP_offset() {
		return p_offset;
	}
	public void setP_offset(Elf32_Off pOffset) {
		p_offset = pOffset;
	}
	public Elf32_Addr getP_vaddr() {
		return p_vaddr;
	}
	public void setP_vaddr(Elf32_Addr pVaddr) {
		p_vaddr = pVaddr;
	}
	public Elf32_Addr getP_paddr() {
		return p_paddr;
	}
	public void setP_paddr(Elf32_Addr pPaddr) {
		p_paddr = pPaddr;
	}
	public Elf32_Word getP_filesz() {
		return p_filesz;
	}
	public void setP_filesz(Elf32_Word pFilesz) {
		p_filesz = pFilesz;
	}
	public Elf32_Word getP_memsz() {
		return p_memsz;
	}
	public void setP_memsz(Elf32_Word pMemsz) {
		p_memsz = pMemsz;
	}
	public Elf32_Word getP_flags() {
		return p_flags;
	}
	public void setP_flags(Elf32_Word pFlags) {
		p_flags = pFlags;
	}
	public Elf32_Word getP_align() {
		return p_align;
	}
	public void setP_align(Elf32_Word pAlign) {
		p_align = pAlign;
	}
	
}
