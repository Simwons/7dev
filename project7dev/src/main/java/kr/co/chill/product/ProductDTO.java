package kr.co.chill.product;

public class ProductDTO {
	private int productNo;			//제품고유번호
	private String productName;		//제품명	
	private String productCode;		//제품코드
	private int eop;				//판매상태
	
	public ProductDTO() {
		super();
	}

	public ProductDTO(int productNo, String productName, String productCode, int eop) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productCode = productCode;
		this.eop = eop;
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

	public int getEop() {
		return eop;
	}

	public void setEop(int eop) {
		this.eop = eop;
	}

	@Override
	public String toString() {
		return "ProductDTO [productNo=" + productNo + ", productName=" + productName + ", productCode=" + productCode
				+ ", eop=" + eop + "]";
	}
	
}
