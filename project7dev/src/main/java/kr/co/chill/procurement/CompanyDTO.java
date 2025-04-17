package kr.co.chill.procurement;

public class CompanyDTO {
	private int compNo;
	private String compName;
	private String compEmail;
	private String compPhone;
	private String compAddr1;
	private String compAddr2;
	private String compCeoName;
	private String compRegNo;
	private String compEtc;
	
	public CompanyDTO() {
		super();
	}

	public CompanyDTO(int compNo, String compName, String compEmail, String compPhone, String compAddr1,
			String compAddr2, String compCeoName, String compRegNo, String compEtc) {
		super();
		this.compNo = compNo;
		this.compName = compName;
		this.compEmail = compEmail;
		this.compPhone = compPhone;
		this.compAddr1 = compAddr1;
		this.compAddr2 = compAddr2;
		this.compCeoName = compCeoName;
		this.compRegNo = compRegNo;
		this.compEtc = compEtc;
	}

	public int getCompNo() {
		return compNo;
	}

	public void setCompNo(int compNo) {
		this.compNo = compNo;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompEmail() {
		return compEmail;
	}

	public void setCompEmail(String compEmail) {
		this.compEmail = compEmail;
	}

	public String getCompPhone() {
		return compPhone;
	}

	public void setCompPhone(String compPhone) {
		this.compPhone = compPhone;
	}

	public String getCompAddr1() {
		return compAddr1;
	}

	public void setCompAddr1(String compAddr1) {
		this.compAddr1 = compAddr1;
	}

	public String getCompAddr2() {
		return compAddr2;
	}

	public void setCompAddr2(String compAddr2) {
		this.compAddr2 = compAddr2;
	}

	public String getCompCeoName() {
		return compCeoName;
	}

	public void setCompCeoName(String compCeoName) {
		this.compCeoName = compCeoName;
	}

	public String getCompRegNo() {
		return compRegNo;
	}

	public void setCompRegNo(String compRegNo) {
		this.compRegNo = compRegNo;
	}

	public String getCompEtc() {
		return compEtc;
	}

	public void setCompEtc(String compEtc) {
		this.compEtc = compEtc;
	}

	@Override
	public String toString() {
		return "CompanyDTO [compNo=" + compNo + ", compName=" + compName + ", compEmail=" + compEmail + ", compPhone="
				+ compPhone + ", compAddr1=" + compAddr1 + ", compAddr2=" + compAddr2 + ", compCeoName=" + compCeoName
				+ ", compRegNo=" + compRegNo + ", compEtc=" + compEtc + "]";
	}
	
}
