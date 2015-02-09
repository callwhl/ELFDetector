package com.core.struct32.type32.calc;

import com.core.struct32.type32.base.Elf32_Type;

public interface Elf32_Calc {

	public void add(int num);
	public void add(Elf32_Type num);
	public void sub(int num);
	public void sub(Elf32_Type num);
	public void mul(int num);
	public void mul(Elf32_Type num);
	public void div(int num);
	public void div(Elf32_Type num);
	
}
