package kr.co.chill.quotation;

public class QuotationDTO {
	private int quotNo;					//견적서고유번호
	private String quotCode;			//견적서 코드
	
	private int supNo;					//거래처정보 불러오는용(회사명, 사업자등록번호)
	private String supName;				//거래처명(화면표시용)
	private String supRegNo;			//사업자등록번호(화면표시용)
	
	private String quotFile;			//견적서파일
	private String quotDterms;			//인도조건
	private String quotPterms;			//지급조건
	
	private int materialNo;				//부품정보 불러오는용(부품명, 부품코드, 소재, 규격, 단위)
	private String materialName;		//부품명(화면표시용)
	private String materialCode;		//부품코드(화면표시용)
	private String materialRawMaterial;	//소재(화면표시용)
	private String materialDescription;	//규격(화면표시용)
	private String materialUnit;		//단위(화면표시용)
	
	private int quotPrice;				//견적단가
	private String quotPriceCurrency;	//화폐종류
	private int quotMaterialCnt;		//수량
	private String quotMaterialSku;		//단위
	private String quotDueDate;			//납기일
	private String quotEtc;				//기타사항
	
	private String quotDate;			//작성일
	private int quotState;				//계약확정여부
	
	public QuotationDTO() {
		super();
	}

	public QuotationDTO(int quotNo, String quotCode, int supNo, String supName, String supRegNo, String quotFile,
			String quotDterms, String quotPterms, int materialNo, String materialName, String materialCode,
			String materialRawMaterial, String materialDescription, String materialUnit, int quotPrice,
			String quotPriceCurrency, int quotMaterialCnt, String quotMaterialSku, String quotDueDate, String quotEtc,
			String quotDate, int quotState) {
		super();
		this.quotNo = quotNo;
		this.quotCode = quotCode;
		this.supNo = supNo;
		this.supName = supName;
		this.supRegNo = supRegNo;
		this.quotFile = quotFile;
		this.quotDterms = quotDterms;
		this.quotPterms = quotPterms;
		this.materialNo = materialNo;
		this.materialName = materialName;
		this.materialCode = materialCode;
		this.materialRawMaterial = materialRawMaterial;
		this.materialDescription = materialDescription;
		this.materialUnit = materialUnit;
		this.quotPrice = quotPrice;
		this.quotPriceCurrency = quotPriceCurrency;
		this.quotMaterialCnt = quotMaterialCnt;
		this.quotMaterialSku = quotMaterialSku;
		this.quotDueDate = quotDueDate;
		this.quotEtc = quotEtc;
		this.quotDate = quotDate;
		this.quotState = quotState;
	}

	public int getQuotNo() {
		return quotNo;
	}

	public void setQuotNo(int quotNo) {
		this.quotNo = quotNo;
	}

	public String getQuotCode() {
		return quotCode;
	}

	public void setQuotCode(String quotCode) {
		this.quotCode = quotCode;
	}

	public int getSupNo() {
		return supNo;
	}

	public void setSupNo(int supNo) {
		this.supNo = supNo;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupRegNo() {
		return supRegNo;
	}

	public void setSupRegNo(String supRegNo) {
		this.supRegNo = supRegNo;
	}

	public String getQuotFile() {
		return quotFile;
	}

	public void setQuotFile(String quotFile) {
		this.quotFile = quotFile;
	}

	public String getQuotDterms() {
		return quotDterms;
	}

	public void setQuotDterms(String quotDterms) {
		this.quotDterms = quotDterms;
	}

	public String getQuotPterms() {
		return quotPterms;
	}

	public void setQuotPterms(String quotPterms) {
		this.quotPterms = quotPterms;
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

	public int getQuotPrice() {
		return quotPrice;
	}

	public void setQuotPrice(int quotPrice) {
		this.quotPrice = quotPrice;
	}

	public String getQuotPriceCurrency() {
		return quotPriceCurrency;
	}

	public void setQuotPriceCurrency(String quotPriceCurrency) {
		this.quotPriceCurrency = quotPriceCurrency;
	}

	public int getQuotMaterialCnt() {
		return quotMaterialCnt;
	}

	public void setQuotMaterialCnt(int quotMaterialCnt) {
		this.quotMaterialCnt = quotMaterialCnt;
	}

	public String getQuotMaterialSku() {
		return quotMaterialSku;
	}

	public void setQuotMaterialSku(String quotMaterialSku) {
		this.quotMaterialSku = quotMaterialSku;
	}

	public String getQuotDueDate() {
		return quotDueDate;
	}

	public void setQuotDueDate(String quotDueDate) {
		this.quotDueDate = quotDueDate;
	}

	public String getQuotEtc() {
		return quotEtc;
	}

	public void setQuotEtc(String quotEtc) {
		this.quotEtc = quotEtc;
	}

	public String getQuotDate() {
		return quotDate;
	}

	public void setQuotDate(String quotDate) {
		this.quotDate = quotDate;
	}

	public int getQuotState() {
		return quotState;
	}

	public void setQuotState(int quotState) {
		this.quotState = quotState;
	}

	@Override
	public String toString() {
		return "QuotationDTO [quotNo=" + quotNo + ", quotCode=" + quotCode + ", supNo=" + supNo + ", supName=" + supName
				+ ", supRegNo=" + supRegNo + ", quotFile=" + quotFile + ", quotDterms=" + quotDterms + ", quotPterms="
				+ quotPterms + ", materialNo=" + materialNo + ", materialName=" + materialName + ", materialCode="
				+ materialCode + ", materialRawMaterial=" + materialRawMaterial + ", materialDescription="
				+ materialDescription + ", materialUnit=" + materialUnit + ", quotPrice=" + quotPrice
				+ ", quotPriceCurrency=" + quotPriceCurrency + ", quotMaterialCnt=" + quotMaterialCnt
				+ ", quotMaterialSku=" + quotMaterialSku + ", quotDueDate=" + quotDueDate + ", quotEtc=" + quotEtc
				+ ", quotDate=" + quotDate + ", quotState=" + quotState + "]";
	}
	
}
