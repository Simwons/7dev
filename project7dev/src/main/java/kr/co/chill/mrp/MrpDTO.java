package kr.co.chill.mrp;

public class MrpDTO {
	private int mrpNo;				//자재소요계획고유번호
	private String mrpCode;
	
	private int prplNo;				//생산계획번호(끌고오기)
	
	private int productNo;			//제품정보 로드용(제품명, 제품코드)
	private String productName;		//제품명
	private String productCode;		//제품코드

	private int mstorageNo;			//자재창고정보 로드용(창고코드, 가용재고)
	private String mstorageCode;	//자재창고코드
	private int mstorageStock;		//자재창고 재고수량
	
	private int materialNo;				//부품정보 로드용(부품명,부품코드,재질,규격,단위)
	private String materialName;		//부품명
	private String materialCode;		//부품코드
	private String materialRawMaterial;	//재질
	private String materialDescription;	//규격
	private String materialUnit;		//단위
	
	private int mpriceNo;				//자재단가번호
	private int sellMprice;				//계약단가
	private int contMprice;				//계약단가
	private String mpriceCurrency;		//화폐단위
	
	private int mrpQuantity;			//자재 총 소요량
	private String mrpSku;				//포장단위
	private String mrpDueDate;		//자재납기일(제품납기일-리드타임)
	private int mrpLeadtime;			//리드타임(자재별 상이)
	private String mrpEtc;				//기타사항
	
	private int empNo;					//담당자정보 로드용(사원명,사원연락처,사원이메일)
	private String empName;				//사원명
	private String empPhone;			//사원연락처
	private String empEmail;			//사원이메일
	
	private int quotNo;
	
	private int contNo;
	private String contDterms;
	
	
	public MrpDTO() {
		super();
	}


	public MrpDTO(int mrpNo, String mrpCode, int prplNo, int productNo, String productName, String productCode,
			int mstorageNo, String mstorageCode, int mstorageStock, int materialNo, String materialName,
			String materialCode, String materialRawMaterial, String materialDescription, String materialUnit,
			int mpriceNo, int sellMprice, int contMprice, String mpriceCurrency, int mrpQuantity, String mrpSku,
			String mrpDueDate, int mrpLeadtime, String mrpEtc, int empNo, String empName, String empPhone,
			String empEmail, int quotNo, int contNo, String contDterms) {
		super();
		this.mrpNo = mrpNo;
		this.mrpCode = mrpCode;
		this.prplNo = prplNo;
		this.productNo = productNo;
		this.productName = productName;
		this.productCode = productCode;
		this.mstorageNo = mstorageNo;
		this.mstorageCode = mstorageCode;
		this.mstorageStock = mstorageStock;
		this.materialNo = materialNo;
		this.materialName = materialName;
		this.materialCode = materialCode;
		this.materialRawMaterial = materialRawMaterial;
		this.materialDescription = materialDescription;
		this.materialUnit = materialUnit;
		this.mpriceNo = mpriceNo;
		this.sellMprice = sellMprice;
		this.contMprice = contMprice;
		this.mpriceCurrency = mpriceCurrency;
		this.mrpQuantity = mrpQuantity;
		this.mrpSku = mrpSku;
		this.mrpDueDate = mrpDueDate;
		this.mrpLeadtime = mrpLeadtime;
		this.mrpEtc = mrpEtc;
		this.empNo = empNo;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
		this.quotNo = quotNo;
		this.contNo = contNo;
		this.contDterms = contDterms;
	}


	public int getMrpNo() {
		return mrpNo;
	}


	public void setMrpNo(int mrpNo) {
		this.mrpNo = mrpNo;
	}


	public String getMrpCode() {
		return mrpCode;
	}


	public void setMrpCode(String mrpCode) {
		this.mrpCode = mrpCode;
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


	public int getMpriceNo() {
		return mpriceNo;
	}


	public void setMpriceNo(int mpriceNo) {
		this.mpriceNo = mpriceNo;
	}


	public int getSellMprice() {
		return sellMprice;
	}


	public void setSellMprice(int sellMprice) {
		this.sellMprice = sellMprice;
	}


	public int getContMprice() {
		return contMprice;
	}


	public void setContMprice(int contMprice) {
		this.contMprice = contMprice;
	}


	public String getMpriceCurrency() {
		return mpriceCurrency;
	}


	public void setMpriceCurrency(String mpriceCurrency) {
		this.mpriceCurrency = mpriceCurrency;
	}


	public int getMrpQuantity() {
		return mrpQuantity;
	}


	public void setMrpQuantity(int mrpQuantity) {
		this.mrpQuantity = mrpQuantity;
	}


	public String getMrpSku() {
		return mrpSku;
	}


	public void setMrpSku(String mrpSku) {
		this.mrpSku = mrpSku;
	}


	public String getMrpDueDate() {
		return mrpDueDate;
	}


	public void setMrpDueDate(String mrpDueDate) {
		this.mrpDueDate = mrpDueDate;
	}


	public int getMrpLeadtime() {
		return mrpLeadtime;
	}


	public void setMrpLeadtime(int mrpLeadtime) {
		this.mrpLeadtime = mrpLeadtime;
	}


	public String getMrpEtc() {
		return mrpEtc;
	}


	public void setMrpEtc(String mrpEtc) {
		this.mrpEtc = mrpEtc;
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


	public int getQuotNo() {
		return quotNo;
	}


	public void setQuotNo(int quotNo) {
		this.quotNo = quotNo;
	}


	public int getContNo() {
		return contNo;
	}


	public void setContNo(int contNo) {
		this.contNo = contNo;
	}


	public String getContDterms() {
		return contDterms;
	}


	public void setContDterms(String contDterms) {
		this.contDterms = contDterms;
	}


	@Override
	public String toString() {
		return "MrpDTO [mrpNo=" + mrpNo + ", mrpCode=" + mrpCode + ", prplNo=" + prplNo + ", productNo=" + productNo
				+ ", productName=" + productName + ", productCode=" + productCode + ", mstorageNo=" + mstorageNo
				+ ", mstorageCode=" + mstorageCode + ", mstorageStock=" + mstorageStock + ", materialNo=" + materialNo
				+ ", materialName=" + materialName + ", materialCode=" + materialCode + ", materialRawMaterial="
				+ materialRawMaterial + ", materialDescription=" + materialDescription + ", materialUnit="
				+ materialUnit + ", mpriceNo=" + mpriceNo + ", sellMprice=" + sellMprice + ", contMprice=" + contMprice
				+ ", mpriceCurrency=" + mpriceCurrency + ", mrpQuantity=" + mrpQuantity + ", mrpSku=" + mrpSku
				+ ", mrpDueDate=" + mrpDueDate + ", mrpLeadtime=" + mrpLeadtime + ", mrpEtc=" + mrpEtc + ", empNo="
				+ empNo + ", empName=" + empName + ", empPhone=" + empPhone + ", empEmail=" + empEmail + ", quotNo="
				+ quotNo + ", contNo=" + contNo + ", contDterms=" + contDterms + "]";
	}
	
}
