package kr.co.chill.material;

public class MaterialDTO {
	private String materialNo;			//부품고유번호
	private String materialName;		//부품명
	private String materialRawMaterial;	//원자재
	private String materialCode;		//부품코드
	private String materialDescription;	//규격
	private String materialUnit;		//단위(mm,ml등)
	private String materialFile;		//세부제작사항
	private int materialQuantity;		//소요량
	
	private int productNo;				//사용되는 제품 매칭용
	
	//이하 내용은 계약 시 작성
	private String materialSku;			//포장단위
	private int materialLeadtime;		//리드타임(발주 시 납품까지 걸리는 일수)
	private int materialMoq;			//최소주문수량
	private int materialSkuQuantity;	//포장단위당 수량
	private String materialEtc;			//기타사항
	
	private int supNo;					//납품 거래처 확인용

	public MaterialDTO() {
		super();
	}

	public MaterialDTO(String materialNo, String materialName, String materialRawMaterial, String materialCode,
			String materialDescription, String materialUnit, String materialFile, int materialQuantity, int productNo,
			String materialSku, int materialLeadtime, int materialMoq, int materialSkuQuantity, String materialEtc,
			int supNo) {
		super();
		this.materialNo = materialNo;
		this.materialName = materialName;
		this.materialRawMaterial = materialRawMaterial;
		this.materialCode = materialCode;
		this.materialDescription = materialDescription;
		this.materialUnit = materialUnit;
		this.materialFile = materialFile;
		this.materialQuantity = materialQuantity;
		this.productNo = productNo;
		this.materialSku = materialSku;
		this.materialLeadtime = materialLeadtime;
		this.materialMoq = materialMoq;
		this.materialSkuQuantity = materialSkuQuantity;
		this.materialEtc = materialEtc;
		this.supNo = supNo;
	}

	public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialRawMaterial() {
		return materialRawMaterial;
	}

	public void setMaterialRawMaterial(String materialRawMaterial) {
		this.materialRawMaterial = materialRawMaterial;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
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

	public String getMaterialFile() {
		return materialFile;
	}

	public void setMaterialFile(String materialFile) {
		this.materialFile = materialFile;
	}

	public int getMaterialQuantity() {
		return materialQuantity;
	}

	public void setMaterialQuantity(int materialQuantity) {
		this.materialQuantity = materialQuantity;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getMaterialSku() {
		return materialSku;
	}

	public void setMaterialSku(String materialSku) {
		this.materialSku = materialSku;
	}

	public int getMaterialLeadtime() {
		return materialLeadtime;
	}

	public void setMaterialLeadtime(int materialLeadtime) {
		this.materialLeadtime = materialLeadtime;
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

	public String getMaterialEtc() {
		return materialEtc;
	}

	public void setMaterialEtc(String materialEtc) {
		this.materialEtc = materialEtc;
	}

	public int getSupNo() {
		return supNo;
	}

	public void setSupNo(int supNo) {
		this.supNo = supNo;
	}

	@Override
	public String toString() {
		return "MaterialDTO [materialNo=" + materialNo + ", materialName=" + materialName + ", materialRawMaterial="
				+ materialRawMaterial + ", materialCode=" + materialCode + ", materialDescription="
				+ materialDescription + ", materialUnit=" + materialUnit + ", materialFile=" + materialFile
				+ ", materialQuantity=" + materialQuantity + ", productNo=" + productNo + ", materialSku=" + materialSku
				+ ", materialLeadtime=" + materialLeadtime + ", materialMoq=" + materialMoq + ", materialSkuQuantity="
				+ materialSkuQuantity + ", materialEtc=" + materialEtc + ", supNo=" + supNo + "]";
	}

	

}
