package com.core.struct32.type32.base;

public abstract class Elf32_Type {

	private int size;
	private byte value[];
	
	public Elf32_Type(int size,byte[] value,Integer offset){
		this.size=size;
		this.value=new byte[size];
		if(offset==null){
			offset=0;
		}
		for(int i=0;i<this.value.length;i++){
			this.value[i]=value[offset++];
		}
	}

	public int getSize() {
		return size;
	}

	public byte[] getValue() {
		return value;
	}

	protected void setValue(byte[] value) {
		for(int i=0;i<this.value.length;i++){
			this.value[i]=value[i];
		}
	}
	
	
}
