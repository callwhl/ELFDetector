package com.core.struct32.type32;

import com.core.struct32.flag.MachineCharacter;
import com.core.struct32.type32.base.Elf32_StandardType;
import com.core.struct32.type32.base.Elf32_Type;
import com.core.util.ConvertUtil;

public class Elf32_Ident extends Elf32_StandardType{
	
	public Elf32_Ident(int[] value,Integer offset){
		super(16,value,offset);
	}
	
	public Elf32_Ident(int[] value,Elf32_Off offset){
		super(16,value,ConvertUtil.byteArrayToInt(offset.getValue(),MachineCharacter.LITTLE_ENDIAN));
	}
	
	
	
}
