package com.core.struct32;

import com.core.struct32.type32.Elf32_Addr;
import com.core.struct32.type32.Elf32_Off;
import com.core.struct32.type32.Elf32_Word;

/**
 * Section Header
 * @author ASUS
 *
 */
public class Elf32_Shdr {

	protected Elf32_Word    sh_name;		//节区名，是节区头部字符串表节区（Section Header String Table Section）的索引。名字是一个
	protected Elf32_Word    sh_type;		//为节区类型
	protected Elf32_Word    sh_flags;		//节区标志
	protected Elf32_Addr    sh_addr;		//如果节区将出现在进程的内存映像中，此成员给出节区的第一个字节应处的位置。否则，此字段为 0。
	protected Elf32_Off     sh_offset;		//此成员的取值给出节区的第一个字节与文件头之间的偏移。
	protected Elf32_Word    sh_size;		//此 成 员 给 出 节 区 的 长 度 （ 字 节 数 ）。
	protected Elf32_Word    sh_link;		//此成员给出节区头部表索引链接。其具体的解释依赖于节区类型。
	protected Elf32_Word    sh_info;		//此成员给出附加信息，其解释依赖于节区类型。
	protected Elf32_Word    sh_addralign;	//某些节区带有地址对齐约束.
	protected Elf32_Word    sh_entsize;		//某些节区中包含固定大小的项目，如符号表。对于这类节区，此成员给出每个表项的长度字节数。
	
	public Elf32_Word getSh_name() {
		return sh_name;
	}
	public void setSh_name(Elf32_Word shName) {
		sh_name = shName;
	}
	public Elf32_Word getSh_type() {
		return sh_type;
	}
	public void setSh_type(Elf32_Word shType) {
		sh_type = shType;
	}
	public Elf32_Word getSh_flags() {
		return sh_flags;
	}
	public void setSh_flags(Elf32_Word shFlags) {
		sh_flags = shFlags;
	}
	public Elf32_Addr getSh_addr() {
		return sh_addr;
	}
	public void setSh_addr(Elf32_Addr shAddr) {
		sh_addr = shAddr;
	}
	public Elf32_Off getSh_offset() {
		return sh_offset;
	}
	public void setSh_offset(Elf32_Off shOffset) {
		sh_offset = shOffset;
	}
	public Elf32_Word getSh_size() {
		return sh_size;
	}
	public void setSh_size(Elf32_Word shSize) {
		sh_size = shSize;
	}
	public Elf32_Word getSh_link() {
		return sh_link;
	}
	public void setSh_link(Elf32_Word shLink) {
		sh_link = shLink;
	}
	public Elf32_Word getSh_info() {
		return sh_info;
	}
	public void setSh_info(Elf32_Word shInfo) {
		sh_info = shInfo;
	}
	public Elf32_Word getSh_addralign() {
		return sh_addralign;
	}
	public void setSh_addralign(Elf32_Word shAddralign) {
		sh_addralign = shAddralign;
	}
	public Elf32_Word getSh_entsize() {
		return sh_entsize;
	}
	public void setSh_entsize(Elf32_Word shEntsize) {
		sh_entsize = shEntsize;
	}
	
}
