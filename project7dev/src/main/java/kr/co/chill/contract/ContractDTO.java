package kr.co.chill.contract;

public class ContractDTO {
	private int contNo;			//계약서고유번호
	private String contCode;	//계약서 코드
	
	private int supNo;			//거래처정보 로드용(사명, 사업자등록번호)
	private String supName;		//회사명(화면출력용)
	private String supRegNo;	//사업자등록번호(화면출력용)
	private String supCip;		//거래처담당자 이름
	
	private String contDate;		//계약일
	private int contPeriod;			//계약기간
	
	private int empNo;			//직원정보 로드용(이름)
	private String empName;		//당사담당자 이름
	
	private int materialNo;				//부품정보 로드용(부품명, 부품코드, 소재, 규격, 단위)	
	private String materialName;		//부품명(화면출력용)
	private String materialCode;		//부품코드(화면출력용)
	private String materialRawMaterial;	//소재(화면출력용)
	private String materialDescription;	//규격(화면출력용)
	private String materialUnit;		//단위(화면출력용)
	
	private int quotNo;			//견적정보 로드용(부품단가, 화폐종류, 수량, 포장단위, 인도조건, 지급조건)	
	private int quotPrice;				//부품단가(화면출력용, 수정가능)
	private String quotPriceCurrency;	//화폐종류(화면출력용, 수정가능)
	private int quotMaterialCnt;		//수량(화면출력용, 수정가능)
	private String quotMaterialSku;		//포장단위(화면출력용, 수정가능)
	private String quotDterms;			//인도조건(화면출력용, 수정가능)
	private String quotPterms;			//지급조건(화면출력용, 수정가능)
	
	private int mpriceNo;				//자재단가 테이블 저장용(계약가, 판매가, 화폐단위)
	private int contMprice;				//계약단가(DB저장용)
	private int sellMprice;				//판매단가(DB저장용)(최초입력 시 계약단가와 같게 설정)
	private String mpriceCurrency;		//화폐단위(DB저장용)
	
	private int contMaterialCnt;		//수량(자재 테이블의 material_quantity도 같은 값을 받음)
	private String contMaterialSku;		//포장단위(자재 테이블의 material_sku도 같은 값을 받음)
	private int contLeadtime;			//계약상의 리드타임(자재 테이블의 material_leadtime도 같은 값을 받음)
	private String contDterms;			//인도조건
	private String contPterms;			//지급조건
	
	private int materialMoq;			//최소주문수량
	private int materialSkuQuantity;	//포장단위당 수량
	private String contFile;			//계약서 파일
	
	public ContractDTO() {
		super();
	}

	public ContractDTO(int contNo, String contCode, int supNo, String supName, String supRegNo, String supCip,
			String contDate, int contPeriod, int empNo, String empName, int materialNo, String materialName,
			String materialCode, String materialRawMaterial, String materialDescription, String materialUnit,
			int quotNo, int quotPrice, String quotPriceCurrency, int quotMaterialCnt, String quotMaterialSku,
			String quotDterms, String quotPterms, int mpriceNo, int contMprice, int sellMprice, String mpriceCurrency,
			int contMaterialCnt, String contMaterialSku, int contLeadtime, String contDterms, String contPterms,
			int materialMoq, int materialSkuQuantity, String contFile) {
		super();
		this.contNo = contNo;
		this.contCode = contCode;
		this.supNo = supNo;
		this.supName = supName;
		this.supRegNo = supRegNo;
		this.supCip = supCip;
		this.contDate = contDate;
		this.contPeriod = contPeriod;
		this.empNo = empNo;
		this.empName = empName;
		this.materialNo = materialNo;
		this.materialName = materialName;
		this.materialCode = materialCode;
		this.materialRawMaterial = materialRawMaterial;
		this.materialDescription = materialDescription;
		this.materialUnit = materialUnit;
		this.quotNo = quotNo;
		this.quotPrice = quotPrice;
		this.quotPriceCurrency = quotPriceCurrency;
		this.quotMaterialCnt = quotMaterialCnt;
		this.quotMaterialSku = quotMaterialSku;
		this.quotDterms = quotDterms;
		this.quotPterms = quotPterms;
		this.mpriceNo = mpriceNo;
		this.contMprice = contMprice;
		this.sellMprice = sellMprice;
		this.mpriceCurrency = mpriceCurrency;
		this.contMaterialCnt = contMaterialCnt;
		this.contMaterialSku = contMaterialSku;
		this.contLeadtime = contLeadtime;
		this.contDterms = contDterms;
		this.contPterms = contPterms;
		this.materialMoq = materialMoq;
		this.materialSkuQuantity = materialSkuQuantity;
		this.contFile = contFile;
	}

	public int getContNo() {
		return contNo;
	}

	public void setContNo(int contNo) {
		this.contNo = contNo;
	}

	public String getContCode() {
		return contCode;
	}

	public void setContCode(String contCode) {
		this.contCode = contCode;
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

	public String getSupCip() {
		return supCip;
	}

	public void setSupCip(String supCip) {
		this.supCip = supCip;
	}

	public String getContDate() {
		return contDate;
	}

	public void setContDate(String contDate) {
		this.contDate = contDate;
	}

	public int getContPeriod() {
		return contPeriod;
	}

	public void setContPeriod(int contPeriod) {
		this.contPeriod = contPeriod;
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

	public int getQuotNo() {
		return quotNo;
	}

	public void setQuotNo(int quotNo) {
		this.quotNo = quotNo;
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

	public int getMpriceNo() {
		return mpriceNo;
	}

	public void setMpriceNo(int mpriceNo) {
		this.mpriceNo = mpriceNo;
	}

	public int getContMprice() {
		return contMprice;
	}

	public void setContMprice(int contMprice) {
		this.contMprice = contMprice;
	}

	public int getSellMprice() {
		return sellMprice;
	}

	public void setSellMprice(int sellMprice) {
		this.sellMprice = sellMprice;
	}

	public String getMpriceCurrency() {
		return mpriceCurrency;
	}

	public void setMpriceCurrency(String mpriceCurrency) {
		this.mpriceCurrency = mpriceCurrency;
	}

	public int getContMaterialCnt() {
		return contMaterialCnt;
	}

	public void setContMaterialCnt(int contMaterialCnt) {
		this.contMaterialCnt = contMaterialCnt;
	}

	public String getContMaterialSku() {
		return contMaterialSku;
	}

	public void setContMaterialSku(String contMaterialSku) {
		this.contMaterialSku = contMaterialSku;
	}

	public int getContLeadtime() {
		return contLeadtime;
	}

	public void setContLeadtime(int contLeadtime) {
		this.contLeadtime = contLeadtime;
	}

	public String getContDterms() {
		return contDterms;
	}

	public void setContDterms(String contDterms) {
		this.contDterms = contDterms;
	}

	public String getContPterms() {
		return contPterms;
	}

	public void setContPterms(String contPterms) {
		this.contPterms = contPterms;
	}

	public int getMaterialMoq() {
		return materialMoq;
	}

	public void setMaterialMoq(int materialMoq) {
		this.materialMoq = materialMoq;
	}

	public int getMaterialSkuQuantity() {
		return materialSkuQuantity;
	}

	public void setMaterialSkuQuantity(int materialSkuQuantity) {
		this.materialSkuQuantity = materialSkuQuantity;
	}

	public String getContFile() {
		return contFile;
	}

	public void setContFile(String contFile) {
		this.contFile = contFile;
	}

	@Override
	public String toString() {
		return "ContractDTO [contNo=" + contNo + ", contCode=" + contCode + ", supNo=" + supNo + ", supName=" + supName
				+ ", supRegNo=" + supRegNo + ", supCip=" + supCip + ", contDate=" + contDate + ", contPeriod="
				+ contPeriod + ", empNo=" + empNo + ", empName=" + empName + ", materialNo=" + materialNo
				+ ", materialName=" + materialName + ", materialCode=" + materialCode + ", materialRawMaterial="
				+ materialRawMaterial + ", materialDescription=" + materialDescription + ", materialUnit="
				+ materialUnit + ", quotNo=" + quotNo + ", quotPrice=" + quotPrice + ", quotPriceCurrency="
				+ quotPriceCurrency + ", quotMaterialCnt=" + quotMaterialCnt + ", quotMaterialSku=" + quotMaterialSku
				+ ", quotDterms=" + quotDterms + ", quotPterms=" + quotPterms + ", mpriceNo=" + mpriceNo
				+ ", contMprice=" + contMprice + ", sellMprice=" + sellMprice + ", mpriceCurrency=" + mpriceCurrency
				+ ", contMaterialCnt=" + contMaterialCnt + ", contMaterialSku=" + contMaterialSku + ", contLeadtime="
				+ contLeadtime + ", contDterms=" + contDterms + ", contPterms=" + contPterms + ", materialMoq="
				+ materialMoq + ", materialSkuQuantity=" + materialSkuQuantity + ", contFile=" + contFile + "]";
	}

	
}
