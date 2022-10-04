package lwhat.dto;

import java.io.Serializable;

public class CodeTableDTO implements Serializable{
	public static final long serialVersionUID = 56565656565656L;
	
	private String codeValue;
	private String codeName;
	
	public CodeTableDTO() {
		
	}// default g
	
	public String getCodeValue() {
		return codeValue;
	}
	
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	@Override
	public String toString() {
		return "CodeTableDTO [codeValue=" + codeValue + ", codeName=" + codeName + "]";
	}
	
	
	
}// class 
