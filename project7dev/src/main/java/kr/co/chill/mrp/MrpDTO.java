package kr.co.chill.mrp;

public class MrpDTO {
	private int mrpNO;				//자재소요계획고유번호
	
	private int productNo;			//제품정보 로드용(제품명, 제품코드)
	private String productName;		//제품명
	private String productCode;		//제품코드

	private String mrpDueDate;		//자재납기일(제품납기일-리드타임)
	
	private int mstorageNo;			//자재창고정보 로드용(창고코드, 가용재고)
	private String mstorageCode;	//자재창고코드
	private int mstorageStock;		//자재창고 재고수량
	
	private int materialNo;				//부품정보 로드용(부품명,부품코드,재질,규격,단위)
	private String materialName;		//부품명
	private String materialCode;		//부품코드
	private String materialRawMaterial;	//재질
	private String materialDescription;	//규격
	private String materialUnit;		//단위
	
	private int mrpQuantity;			//자재 총 소요량
	private String mrpUnit;				//포장단위
	private int mrpLeadtime;			//리드타임(자재별 상이)
	
	private int empNo;					//담당자정보 로드용(사원명,사원연락처,사원이메일)
	private String empName;				//사원명
	private String empPhone;			//사원연락처
	private String empEmail;			//사원이메일
	
	private String mrpEtc;				//기타사항

	public MrpDTO() {
		super();
	}

	public MrpDTO(int mrpNO, int productNo, String productName, String productCode, String mrpDueDate, int mstorageNo,
			String mstorageCode, int mstorageStock, int materialNo, String materialName, String materialCode,
			String materialRawMaterial, String materialDescription, String materialUnit, int mrpQuantity,
			String mrpUnit, int mrpLeadtime, int empNo, String empName, String empPhone, String empEmail,
			String mrpEtc) {
		super();
		this.mrpNO = mrpNO;
		this.productNo = productNo;
		this.productName = productName;
		this.productCode = productCode;
		this.mrpDueDate = mrpDueDate;
		this.mstorageNo = mstorageNo;
		this.mstorageCode = mstorageCode;
		this.mstorageStock = mstorageStock;
		this.materialNo = materialNo;
		this.materialName = materialName;
		this.materialCode = materialCode;
		this.materialRawMaterial = materialRawMaterial;
		this.materialDescription = materialDescription;
		this.materialUnit = materialUnit;
		this.mrpQuantity = mrpQuantity;
		this.mrpUnit = mrpUnit;
		this.mrpLeadtime = mrpLeadtime;
		this.empNo = empNo;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
		this.mrpEtc = mrpEtc;
	}

	public int getMrpNO() {
		return mrpNO;
	}

	public void setMrpNO(int mrpNO) {
		this.mrpNO = mrpNO;
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

	public String getMrpDueDate() {
		return mrpDueDate;
	}

	public void setMrpDueDate(String mrpDueDate) {
		this.mrpDueDate = mrpDueDate;
	}

	public int getMstorageNo() {
		return mstorageNo;
	}

	public void setMstorageNo(int mstorageNo) {
		this.mstorageNo = mstorageNo;
	}

	public String getMstorageCode() {
		return mstorageCode;
	}

	public void setMstorageCode(String mstorageCode) {
		this.mstorageCode = mstorageCode;
	}

	public int getMstorageStock() {
		return mstorageStock;
	}

	public void setMstorageStock(int mstorageStock) {
		this.mstorageStock = mstorageStock;
	}

	public int getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(int materialNo) {
		this.materialNo = materialNo;
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

	public String getMaterialRawMaterial() {
		return materialRawMaterial;
	}

	public void setMaterialRawMaterial(String materialRawMaterial) {
		this.materialRawMaterial = materialRawMaterial;
	}

	public String getMaterialDescription() {
		return materialDescription;
	}

	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}

	public String getMaterialUnit() {
		return materialUnit;
	}

	public void setMaterialUnit(String materialUnit) {
		this.materialUnit = materialUnit;
	}

	public int getMrpQuantity() {
		return mrpQuantity;
	}

	public void setMrpQuantity(int mrpQuantity) {
		this.mrpQuantity = mrpQuantity;
	}

	public String getMrpUnit() {
		return mrpUnit;
	}

	public void setMrpUnit(String mrpUnit) {
		this.mrpUnit = mrpUnit;
	}

	public int getMrpLeadtime() {
		return mrpLeadtime;
	}

	public void setMrpLeadtime(int mrpLeadtime) {
		this.mrpLeadtime = mrpLeadtime;
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

	public String getMrpEtc() {
		return mrpEtc;
	}

	public void setMrpEtc(String mrpEtc) {
		this.mrpEtc = mrpEtc;
	}

	@Override
	public String toString() {
		return "MrpDTO [mrpNO=" + mrpNO + ", productNo=" + productNo + ", productName=" + productName + ", productCode="
				+ productCode + ", mrpDueDate=" + mrpDueDate + ", mstorageNo=" + mstorageNo + ", mstorageCode="
				+ mstorageCode + ", mstorageStock=" + mstorageStock + ", materialNo=" + materialNo + ", materialName="
				+ materialName + ", materialCode=" + materialCode + ", materialRawMaterial=" + materialRawMaterial
				+ ", materialDescription=" + materialDescription + ", materialUnit=" + materialUnit + ", mrpQuantity="
				+ mrpQuantity + ", mrpUnit=" + mrpUnit + ", mrpLeadtime=" + mrpLeadtime + ", empNo=" + empNo
				+ ", empName=" + empName + ", empPhone=" + empPhone + ", empEmail=" + empEmail + ", mrpEtc=" + mrpEtc
				+ "]";
	}

}
