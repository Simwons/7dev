package kr.co.chill.productionPlanning;

public class ProductionPlanningDTO {
	private int prplNo;				//제품생산계획고유번호
	
	private int productNo;			//제품정보 로드용(제품명, 제품코드)
	private String productName;		//제품명(화면출력용)
	private String productCode;		//제품코드(화면 입/출력용)
	
	private String prplPlant;		//우리공장(kr,cn)
	private String prplLine;		//우리공장 생산라인
	
	private int pstorageNo;			//제품창고 로드용(창고재고수량)
	private int pstorageStock;		//창고재고수량(화면출력/연산용)
	
	private int productCnt;			//출고계획수량(사용자가 입력하는 값 - 재고량)
	private String prplDueDate;		//제품납기일(이날까지 완성되어 출고되어야함)
	private int prplLeadtime;		//제품 리드타임
	
	private int empNo;				//담당자정보 로드용(직원명, 직원연락처, 직원이메일)
	private String empName;			//직원명
	private String empPhone;		//직원연락처
	private String empEmail;		//직원이메일
	
	private String prplEtc;			//기타사항

	public ProductionPlanningDTO() {
		super();
	}

	public ProductionPlanningDTO(int prplNo, int productNo, String productName, String productCode, String prplPlant,
			String prplLine, int pstorageNo, int pstorageStock, int productCnt, String prplDueDate, int prplLeadtime,
			int empNo, String empName, String empPhone, String empEmail, String prplEtc) {
		super();
		this.prplNo = prplNo;
		this.productNo = productNo;
		this.productName = productName;
		this.productCode = productCode;
		this.prplPlant = prplPlant;
		this.prplLine = prplLine;
		this.pstorageNo = pstorageNo;
		this.pstorageStock = pstorageStock;
		this.productCnt = productCnt;
		this.prplDueDate = prplDueDate;
		this.prplLeadtime = prplLeadtime;
		this.empNo = empNo;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
		this.prplEtc = prplEtc;
	}

	public int getPrplNo() {
		return prplNo;
	}

	public void setPrplNo(int prplNo) {
		this.prplNo = prplNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
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

	public String getPrplPlant() {
		return prplPlant;
	}

	public void setPrplPlant(String prplPlant) {
		this.prplPlant = prplPlant;
	}

	public String getPrplLine() {
		return prplLine;
	}

	public void setPrplLine(String prplLine) {
		this.prplLine = prplLine;
	}

	public int getPstorageNo() {
		return pstorageNo;
	}

	public void setPstorageNo(int pstorageNo) {
		this.pstorageNo = pstorageNo;
	}

	public int getPstorageStock() {
		return pstorageStock;
	}

	public void setPstorageStock(int pstorageStock) {
		this.pstorageStock = pstorageStock;
	}

	public int getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}

	public String getPrplDueDate() {
		return prplDueDate;
	}

	public void setPrplDueDate(String prplDueDate) {
		this.prplDueDate = prplDueDate;
	}

	public int getPrplLeadtime() {
		return prplLeadtime;
	}

	public void setPrplLeadtime(int prplLeadtime) {
		this.prplLeadtime = prplLeadtime;
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

	public String getPrplEtc() {
		return prplEtc;
	}

	public void setPrplEtc(String prplEtc) {
		this.prplEtc = prplEtc;
	}

	@Override
	public String toString() {
		return "ProductionPlanningDTO [prplNo=" + prplNo + ", productNo=" + productNo + ", productName=" + productName
				+ ", productCode=" + productCode + ", prplPlant=" + prplPlant + ", prplLine=" + prplLine
				+ ", pstorageNo=" + pstorageNo + ", pstorageStock=" + pstorageStock + ", productCnt=" + productCnt
				+ ", prplDueDate=" + prplDueDate + ", prplLeadtime=" + prplLeadtime + ", empNo=" + empNo + ", empName="
				+ empName + ", empPhone=" + empPhone + ", empEmail=" + empEmail + ", prplEtc=" + prplEtc + "]";
	}


}
