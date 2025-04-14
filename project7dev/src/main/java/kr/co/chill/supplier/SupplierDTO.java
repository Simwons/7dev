package kr.co.chill.supplier;

public class SupplierDTO {
	private int supNo;				//거래처고유번호
	private String supCategory;		//업종분류
	private String supRegNo;		//사업자등록번호
	private String supName;			//거래처명
	private String supCeoName;		//거래처대표이름
	private String supPhone;		//거래처전화번호
	private String supEmail;		//거래처이메일
	private String supAddr1;		//거래처주소
	private String supAddr2;		//거래처상세주소
	
	private String supCip;			//거래처담당자명
	private String supCipPhone;		//거래처담당자	전화번호
	private String supCipEmail;		//거래처담당자 이메일
	private String supId;			//거래처계정 아이디
	private String supPassword;		//거래처계정 비밀번호
	private String supEtc;			//기타사항
	
	public SupplierDTO() {
		super();
	}

	public SupplierDTO(int supNo, String supCategory, String supRegNo, String supName, String supCeoName,
			String supPhone, String supEmail, String supAddr1, String supAddr2, String supCip, String supCipPhone,
			String supCipEmail, String supId, String supPassword, String supEtc) {
		super();
		this.supNo = supNo;
		this.supCategory = supCategory;
		this.supRegNo = supRegNo;
		this.supName = supName;
		this.supCeoName = supCeoName;
		this.supPhone = supPhone;
		this.supEmail = supEmail;
		this.supAddr1 = supAddr1;
		this.supAddr2 = supAddr2;
		this.supCip = supCip;
		this.supCipPhone = supCipPhone;
		this.supCipEmail = supCipEmail;
		this.supId = supId;
		this.supPassword = supPassword;
		this.supEtc = supEtc;
	}

	public int getSupNo() {
		return supNo;
	}

	public void setSupNo(int supNo) {
		this.supNo = supNo;
	}

	public String getSupCategory() {
		return supCategory;
	}

	public void setSupCategory(String supCategory) {
		this.supCategory = supCategory;
	}

	public String getSupRegNo() {
		return supRegNo;
	}

	public void setSupRegNo(String supRegNo) {
		this.supRegNo = supRegNo;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupCeoName() {
		return supCeoName;
	}

	public void setSupCeoName(String supCeoName) {
		this.supCeoName = supCeoName;
	}

	public String getSupPhone() {
		return supPhone;
	}

	public void setSupPhone(String supPhone) {
		this.supPhone = supPhone;
	}

	public String getSupEmail() {
		return supEmail;
	}

	public void setSupEmail(String supEmail) {
		this.supEmail = supEmail;
	}

	public String getSupAddr1() {
		return supAddr1;
	}

	public void setSupAddr1(String supAddr1) {
		this.supAddr1 = supAddr1;
	}

	public String getSupAddr2() {
		return supAddr2;
	}

	public void setSupAddr2(String supAddr2) {
		this.supAddr2 = supAddr2;
	}

	public String getSupCip() {
		return supCip;
	}

	public void setSupCip(String supCip) {
		this.supCip = supCip;
	}

	public String getSupCipPhone() {
		return supCipPhone;
	}

	public void setSupCipPhone(String supCipPhone) {
		this.supCipPhone = supCipPhone;
	}

	public String getSupCipEmail() {
		return supCipEmail;
	}

	public void setSupCipEmail(String supCipEmail) {
		this.supCipEmail = supCipEmail;
	}

	public String getSupId() {
		return supId;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

	public String getSupPassword() {
		return supPassword;
	}

	public void setSupPassword(String supPassword) {
		this.supPassword = supPassword;
	}

	public String getSupEtc() {
		return supEtc;
	}

	public void setSupEtc(String supEtc) {
		this.supEtc = supEtc;
	}

	@Override
	public String toString() {
		return "SupplierDTO [supNo=" + supNo + ", supCategory=" + supCategory + ", supRegNo=" + supRegNo + ", supName="
				+ supName + ", supCeoName=" + supCeoName + ", supPhone=" + supPhone + ", supEmail=" + supEmail
				+ ", supAddr1=" + supAddr1 + ", supAddr2=" + supAddr2 + ", supCip=" + supCip + ", supCipPhone="
				+ supCipPhone + ", supCipEmail=" + supCipEmail + ", supId=" + supId + ", supPassword=" + supPassword
				+ ", supEtc=" + supEtc + "]";
	}
	
	
	
}
