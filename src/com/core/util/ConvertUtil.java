package com.core.util;

import com.core.struct32.flag.MachineCharacter;

public class ConvertUtil {
	
	public static byte intToByte(int x) {  
	    return (byte) x;  
	}
	
	public static int byteToInt(byte b) {  
	    //Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
	    return b & 0xFF;  
	}
	
	public static int byteArrayToInt(byte[] b,MachineCharacter mc) { 
		if(b.length<4){
			byte[] tmp=new byte[4];
			for(int i=0;i<4;i++){
				if(i>=b.length){
					tmp[i]=0;
				}
				else{
					tmp[i]=b[i];
				}
			}
			b=tmp;
		}
		if(mc==MachineCharacter.LITTLE_ENDIAN){
			return   b[0] & 0xFF |  
			        (b[1] & 0xFF) << 8 |  
			        (b[2] & 0xFF) << 16 |  
			        (b[3] & 0xFF) << 24;
		}
		else if(mc==MachineCharacter.BIG_ENDIAN){
			return   b[3] & 0xFF |  
		            (b[2] & 0xFF) << 8 |  
		            (b[1] & 0xFF) << 16 |  
		            (b[0] & 0xFF) << 24;
		}
		else{
			return -1;
		}
	}
	
	public static byte[] intToByteArray(int a,MachineCharacter mc) {
		if(mc==MachineCharacter.LITTLE_ENDIAN){
			return new byte[] {
					(byte) (a & 0xFF),
					(byte) ((a >> 8) & 0xFF),
					(byte) ((a >> 16) & 0xFF),
			        (byte) ((a >> 24) & 0xFF)
			};
		}
		else if(mc==MachineCharacter.BIG_ENDIAN){
			return new byte[] {
			        (byte) ((a >> 24) & 0xFF),
			        (byte) ((a >> 16) & 0xFF),
			        (byte) ((a >> 8) & 0xFF),
			        (byte) (a & 0xFF)
			};
		}
		else{
			return null;
		}
	}
	
}
