package com.core.manager;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

import com.core.struct32.Elf32_Ehdr;
import com.core.struct32.Elf32_Phdr;
import com.core.struct32.Elf32_Shdr;
import com.core.struct32.flag.MachineCharacter;
import com.core.struct32.type32.Elf32_Addr;
import com.core.struct32.type32.Elf32_Half;
import com.core.struct32.type32.Elf32_Ident;
import com.core.struct32.type32.Elf32_Off;
import com.core.struct32.type32.Elf32_Word;
import com.core.util.ConvertUtil;
import com.core.util.Recognizer;

public class ElfManager {
	
	private Elf32_Ehdr elf_header=new Elf32_Ehdr();
	private List<Elf32_Phdr> program_header_table=new ArrayList<Elf32_Phdr>();
	private List<Elf32_Shdr> section_header_table=new ArrayList<Elf32_Shdr>();
	
	public ElfManager(MappedByteBuffer fileMemMap)throws Exception{
		//获取文件内存映射数组
		//byte[] fileMemArray=fileMemMap.array();
		int[] fileMemArray=new int[fileMemMap.limit()];
		for(int i=0;i<fileMemMap.limit();i++){
			fileMemArray[i]=(fileMemMap.get()&0xff);
		}
		//读取ELF header
		elf_header.setE_ident(new Elf32_Ident(fileMemArray,0));
		elf_header.setE_type(new Elf32_Half(fileMemArray,16));
		elf_header.setE_machine(new Elf32_Half(fileMemArray,18));
		elf_header.setE_version(new Elf32_Word(fileMemArray,20));
		elf_header.setE_entry(new Elf32_Addr(fileMemArray,24));
		elf_header.setE_phoff(new Elf32_Off(fileMemArray,28));
		elf_header.setE_shoff(new Elf32_Off(fileMemArray,32));
		elf_header.setE_flags(new Elf32_Word(fileMemArray,36));
		elf_header.setE_ehsize(new Elf32_Half(fileMemArray,40));
		elf_header.setE_phentsize(new Elf32_Half(fileMemArray,42));
		elf_header.setE_phnum(new Elf32_Half(fileMemArray,44));
		elf_header.setE_shentsize(new Elf32_Half(fileMemArray,46));
		elf_header.setE_shnum(new Elf32_Half(fileMemArray,48));
		elf_header.setE_shstrndx(new Elf32_Half(fileMemArray,50));
		//读取Program header table
		Elf32_Off offset=new Elf32_Off(elf_header.getE_phoff().getValue(),0);
		for(int i=0;i<ConvertUtil.byteArrayToInt(elf_header.getE_phnum().getValue(),MachineCharacter.LITTLE_ENDIAN);i++){
			Elf32_Phdr program_header=new Elf32_Phdr();
			program_header.setP_type(new Elf32_Word(fileMemArray,offset));
			offset.add(4);
			program_header.setP_offset(new Elf32_Off(fileMemArray,offset));
			offset.add(4);
			program_header.setP_vaddr(new Elf32_Addr(fileMemArray,offset));
			offset.add(4);
			program_header.setP_paddr(new Elf32_Addr(fileMemArray,offset));
			offset.add(4);
			program_header.setP_filesz(new Elf32_Word(fileMemArray,offset));
			offset.add(4);
			program_header.setP_memsz(new Elf32_Word(fileMemArray,offset));
			offset.add(4);
			program_header.setP_flags(new Elf32_Word(fileMemArray,offset));
			offset.add(4);
			program_header.setP_align(new Elf32_Word(fileMemArray,offset));
			offset.add(4);
			program_header_table.add(program_header);
		}
		//读取Section header table
		Elf32_Off offset2=new Elf32_Off(elf_header.getE_shoff().getValue(),0);
		for(int i=0;i<ConvertUtil.byteArrayToInt(elf_header.getE_shnum().getValue(),MachineCharacter.LITTLE_ENDIAN);i++){
			Elf32_Shdr section_header=new Elf32_Shdr();
			section_header.setSh_name(new Elf32_Word(fileMemArray,offset2));
			offset2.add(4);
			section_header.setSh_type(new Elf32_Word(fileMemArray,offset2));
			offset2.add(4);
			section_header.setSh_flags(new Elf32_Word(fileMemArray,offset2));
			offset2.add(4);
			section_header.setSh_addr(new Elf32_Addr(fileMemArray,offset2));
			offset2.add(4);
			section_header.setSh_offset(new Elf32_Off(fileMemArray,offset2));
			offset2.add(4);
			section_header.setSh_size(new Elf32_Word(fileMemArray,offset2));
			offset2.add(4);
			section_header.setSh_link(new Elf32_Word(fileMemArray,offset2));
			offset2.add(4);
			section_header.setSh_info(new Elf32_Word(fileMemArray,offset2));
			offset2.add(4);
			section_header.setSh_addralign(new Elf32_Word(fileMemArray,offset2));
			offset2.add(4);
			section_header.setSh_entsize(new Elf32_Word(fileMemArray,offset2));
			offset2.add(4);
			section_header_table.add(section_header);
		}
	}
	
	public void printElfHeader(){
		System.out.println("ELF Header:----------------------------------------");
		System.out.println("e_ident:"+elf_header.getE_ident().getHexString(MachineCharacter.ORG));
		System.out.println("e_type:"+Recognizer.recognizeElf32HeaderType(elf_header.getE_type().getHexString(MachineCharacter.LITTLE_ENDIAN)));
		System.out.println("e_machine:"+Recognizer.recognizeElf32HeaderMachine(elf_header.getE_machine().getHexString(MachineCharacter.LITTLE_ENDIAN)));
		System.out.println("e_version:"+Recognizer.recognizeElf32HeaderVersion(elf_header.getE_version().getHexString(MachineCharacter.LITTLE_ENDIAN)));
		System.out.println("e_entry:"+elf_header.getE_entry().getHexString(MachineCharacter.LITTLE_ENDIAN));
		System.out.println("e_phoff:"+elf_header.getE_phoff().getHexString(MachineCharacter.LITTLE_ENDIAN));
		System.out.println("e_shoff:"+elf_header.getE_shoff().getHexString(MachineCharacter.LITTLE_ENDIAN));
		System.out.println("e_flags:"+elf_header.getE_flags().getHexString(MachineCharacter.ORG));
		System.out.println("e_ehsize:"+elf_header.getE_ehsize().getHexString(MachineCharacter.LITTLE_ENDIAN));
		System.out.println("e_phentsize:"+elf_header.getE_phentsize().getHexString(MachineCharacter.LITTLE_ENDIAN));
		System.out.println("e_phnum:"+elf_header.getE_phnum().getHexString(MachineCharacter.LITTLE_ENDIAN));
		System.out.println("e_shentsize:"+elf_header.getE_shentsize().getHexString(MachineCharacter.LITTLE_ENDIAN));
		System.out.println("e_shnum:"+elf_header.getE_shnum().getHexString(MachineCharacter.LITTLE_ENDIAN));
		System.out.println("e_shstrndx:"+elf_header.getE_shstrndx().getHexString(MachineCharacter.LITTLE_ENDIAN));
		System.out.println("---------------------------------------------------");
	}
	
	public void printElfProgramHeaderTable(){
		int i=0;
		for(Elf32_Phdr ph:program_header_table){
			System.out.println("Program Header"+(i++)+":-----------------------------------");
			System.out.println("p_type:"+ph.getP_type().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("p_offset:"+ph.getP_offset().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("p_vaddr:"+ph.getP_vaddr().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("p_paddr:"+ph.getP_paddr().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("p_filesz:"+ph.getP_filesz().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("p_memsz:"+ph.getP_memsz().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("p_flags:"+ph.getP_flags().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("p_align:"+ph.getP_align().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("---------------------------------------------------");
		}
	}
	
	public void printElfSectionHeaderTable(){
		int i=0;
		for(Elf32_Shdr sh:section_header_table){
			System.out.println("Section Header"+(i++)+":-----------------------------------");
			System.out.println("sh_name:"+sh.getSh_name().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("sh_type:"+sh.getSh_type().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("sh_flags:"+sh.getSh_flags().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("sh_addr:"+sh.getSh_addr().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("sh_offset:"+sh.getSh_offset().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("sh_size:"+sh.getSh_size().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("sh_link:"+sh.getSh_link().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("sh_info:"+sh.getSh_info().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("sh_addralign:"+sh.getSh_addralign().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("sh_entsize:"+sh.getSh_entsize().getHexString(MachineCharacter.LITTLE_ENDIAN));
			System.out.println("---------------------------------------------------");
		}
	}
	
}
