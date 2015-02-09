package com.core.struct32.type32.base;

import com.core.struct32.flag.MachineCharacter;
import com.core.struct32.type32.calc.Elf32_Calc;
import com.core.struct32.type32.numerical.NumConvert;
import com.core.util.ConvertUtil;

public abstract class Elf32_StandardType extends Elf32_Type implements Elf32_Calc,NumConvert{

	public Elf32_StandardType(int size, byte[] value, Integer offset) {
		super(size, value, offset);
	}

	@Override
	public void add(int num) {
		this.setValue(
				ConvertUtil.intToByteArray(
						ConvertUtil.byteArrayToInt(
								this.getValue(),
								MachineCharacter.LITTLE_ENDIAN
						)+num,
						MachineCharacter.LITTLE_ENDIAN
				)
		);
	}

	@Override
	public void add(Elf32_Type num) {
		int a=ConvertUtil.byteArrayToInt(this.getValue(),MachineCharacter.LITTLE_ENDIAN);
		int b=ConvertUtil.byteArrayToInt(num.getValue(),MachineCharacter.LITTLE_ENDIAN);
		this.setValue(ConvertUtil.intToByteArray(a+b,MachineCharacter.LITTLE_ENDIAN));
	}

	@Override
	public void div(int num) {
		this.setValue(ConvertUtil.intToByteArray(ConvertUtil.byteArrayToInt(this.getValue(),MachineCharacter.LITTLE_ENDIAN)/num,MachineCharacter.LITTLE_ENDIAN));
	}

	@Override
	public void div(Elf32_Type num) {
		int a=ConvertUtil.byteArrayToInt(this.getValue(),MachineCharacter.LITTLE_ENDIAN);
		int b=ConvertUtil.byteArrayToInt(num.getValue(),MachineCharacter.LITTLE_ENDIAN);
		this.setValue(ConvertUtil.intToByteArray(a/b,MachineCharacter.LITTLE_ENDIAN));
	}

	@Override
	public void mul(int num) {
		this.setValue(ConvertUtil.intToByteArray(ConvertUtil.byteArrayToInt(this.getValue(),MachineCharacter.LITTLE_ENDIAN)*num,MachineCharacter.LITTLE_ENDIAN));
	}

	@Override
	public void mul(Elf32_Type num) {
		int a=ConvertUtil.byteArrayToInt(this.getValue(),MachineCharacter.LITTLE_ENDIAN);
		int b=ConvertUtil.byteArrayToInt(num.getValue(),MachineCharacter.LITTLE_ENDIAN);
		this.setValue(ConvertUtil.intToByteArray(a*b,MachineCharacter.LITTLE_ENDIAN));
	}

	@Override
	public void sub(int num) {
		this.setValue(ConvertUtil.intToByteArray(ConvertUtil.byteArrayToInt(this.getValue(),MachineCharacter.LITTLE_ENDIAN)-num,MachineCharacter.LITTLE_ENDIAN));
	}

	@Override
	public void sub(Elf32_Type num) {
		int a=ConvertUtil.byteArrayToInt(this.getValue(),MachineCharacter.LITTLE_ENDIAN);
		int b=ConvertUtil.byteArrayToInt(num.getValue(),MachineCharacter.LITTLE_ENDIAN);
		this.setValue(ConvertUtil.intToByteArray(a-b,MachineCharacter.LITTLE_ENDIAN));
	}

	@Override
	public String getHexString(MachineCharacter mc) {
		String s="";
		if(mc==MachineCharacter.LITTLE_ENDIAN){
			for(int i=(getValue().length-1);i>=0;i--){
				String hex=Integer.toHexString(getValue()[i]);
				s+=hex.length()==1?"0"+hex:hex;
			}
		}
		else if(mc==MachineCharacter.BIG_ENDIAN||mc==MachineCharacter.ORG){
			for(int i=0;i<getValue().length;i++){
				String hex=Integer.toHexString(getValue()[i]);
				s+=hex.length()==1?"0"+hex:hex;
			}
		}
		return s;
	}

	@Override
	public String getOctalString(MachineCharacter mc){
		return null;
	}

	@Override
	public String getBinaryString(MachineCharacter mc) {
		return null;
	}
	
}
