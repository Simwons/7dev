package kr.co.chill.procurement;

public class ProcurementDTO {
	private int mppNo;				//부품조달계획고유번호
	
	private String mppCode;			//부품조달계획코드
	private int mppVer;				//차수
	private String mppRegDate;		//수립일
	private String mppFile;			//첨부파일
	
	private int prplNo;				//생산계획정보 로드용(제품명, 제품코드)
	private String productName;		//제품명
	private String productCode;		//제품코드
	private int productCnt;			//생산계획수량
	
	private int mrpNo;				//자재소요계획정보 로드용(부품명, 부품코드, 자재창고코드, 총소요량, 가용재고, 포장단위, 리드타임)
	private String materialName;	//부품명
	private String materialCode;	//부품코드
	private String mstorageCode;	//자재창고코드
	private int mrpQuantity;		//총소요량
	private int mstorageStock;		//가용재고
	private String mrpUnit;			//포장단위
	private String mrpLeadtime;		//리드타임
	private String mrpDueDate;      //자재납기일
	
	private int empNo;				//담당자정보 로드용(이름,연락처,이메일)
	private String empName;			//담당자명
	private String empPhone;		//담당자연략처
	private String empEmail;		//담당자이메일
	
	private String mppEtc;			//기타사항

	public ProcurementDTO() {
		super();
	}

	public ProcurementDTO(int mppNo, String mppCode, int mppVer, String mppRegDate, String mppFile, int prplNo,
			String productName, String productCode, int productCnt, int mrpNo, String materialName, String materialCode,
			String mstorageCode, int mrpQuantity, int mstorageStock, String mrpUnit, String mrpLeadtime,
			String mrpDueDate, int empNo, String empName, String empPhone, String empEmail, String mppEtc) {
		super();
		this.mppNo = mppNo;
		this.mppCode = mppCode;
		this.mppVer = mppVer;
		this.mppRegDate = mppRegDate;
		this.mppFile = mppFile;
		this.prplNo = prplNo;
		this.productName = productName;
		this.productCode = productCode;
		this.productCnt = productCnt;
		this.mrpNo = mrpNo;
		this.materialName = materialName;
		this.materialCode = materialCode;
		this.mstorageCode = mstorageCode;
		this.mrpQuantity = mrpQuantity;
		this.mstorageStock = mstorageStock;
		this.mrpUnit = mrpUnit;
		this.mrpLeadtime = mrpLeadtime;
		this.mrpDueDate = mrpDueDate;
		this.empNo = empNo;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
		this.mppEtc = mppEtc;
	}

	public int getMppNo() {
		return mppNo;
	}

	public void setMppNo(int mppNo) {
		this.mppNo = mppNo;
	}

	public String getMppCode() {
		return mppCode;
	}

	public void setMppCode(String mppCode) {
		this.mppCode = mppCode;
	}

	public int getMppVer() {
		return mppVer;
	}

	public void setMppVer(int mppVer) {
		this.mppVer = mppVer;
	}

	public String getMppRegDate() {
		return mppRegDate;
	}

	public void setMppRegDate(String mppRegDate) {
		this.mppRegDate = mppRegDate;
	}

	public String getMppFile() {
		return mppFile;
	}

	public void setMppFile(String mppFile) {
		this.mppFile = mppFile;
	}

	public int getPrplNo() {
		return prplNo;
	}

	public void setPrplNo(int prplNo) {
		this.prplNo = prplNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}

	public int getMrpNo() {
		return mrpNo;
	}

	public void setMrpNo(int mrpNo) {
		this.mrpNo = mrpNo;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMstorageCode() {
		return mstorageCode;
	}

	public void setMstorageCode(String mstorageCode) {
		this.mstorageCode = mstorageCode;
	}

	public int getMrpQuantity() {
		return mrpQuantity;
	}

	public void setMrpQuantity(int mrpQuantity) {
		this.mrpQuantity = mrpQuantity;
	}

	public int getMstorageStock() {
		return mstorageStock;
	}

	public void setMstorageStock(int mstorageStock) {
		this.mstorageStock = mstorageStock;
	}

	public String getMrpUnit() {
		return mrpUnit;
	}

	public void setMrpUnit(String mrpUnit) {
		this.mrpUnit = mrpUnit;
	}

	public String getMrpLeadtime() {
		return mrpLeadtime;
	}

	public void setMrpLeadtime(String mrpLeadtime) {
		this.mrpLeadtime = mrpLeadtime;
	}

	public String getMrpDueDate() {
		return mrpDueDate;
	}

	public void setMrpDueDate(String mrpDueDate) {
		this.mrpDueDate = mrpDueDate;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getMppEtc() {
		return mppEtc;
	}

	public void setMppEtc(String mppEtc) {
		this.mppEtc = mppEtc;
	}

	@Override
	public String toString() {
		return "ProcurementDTO [mppNo=" + mppNo + ", mppCode=" + mppCode + ", mppVer=" + mppVer + ", mppRegDate="
				+ mppRegDate + ", mppFile=" + mppFile + ", prplNo=" + prplNo + ", productName=" + productName
				+ ", productCode=" + productCode + ", productCnt=" + productCnt + ", mrpNo=" + mrpNo + ", materialName="
				+ materialName + ", materialCode=" + materialCode + ", mstorageCode=" + mstorageCode + ", mrpQuantity="
				+ mrpQuantity + ", mstorageStock=" + mstorageStock + ", mrpUnit=" + mrpUnit + ", mrpLeadtime="
				+ mrpLeadtime + ", mrpDueDate=" + mrpDueDate + ", empNo=" + empNo + ", empName=" + empName
				+ ", empPhone=" + empPhone + ", empEmail=" + empEmail + ", mppEtc=" + mppEtc + "]";
	}

}
