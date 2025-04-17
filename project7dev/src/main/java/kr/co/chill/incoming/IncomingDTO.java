package kr.co.chill.incoming;

import java.util.List;

//창고별 자재정보 리스트 and 입고예정 리스트DTO
public class IncomingDTO {
	
	// material 테이블
	private int material_no;//자재번호
	private String material_name; //자재명
	private String material_code;// 자재코드
	private String material_raw_material;//소재
	private String material_description;//규격
	private String material_unit;//단위
	private String material_etc;//기타정보
	
	//material_storage 테이블
	private int mstorage_no;
	private	int mstorage_stock;//자재수량
	private String mstorage_code;//창고코드
	private String mstorage_plant_code;
	//emp 테이블
	private int emp_no;//담당자 번호
	private String emp_name;//담당자 이름
	
	//supplier 테이블
	private String sup_name;//공급업체명
	private int sup_no;
	
	//product 테이블
	private int product_no;//제품번호
	
	//material_in 테이블
	private int material_in_no; // 자재도착순서
	private String material_in_date;//입고날짜
	private String mstorage_in_date;//자재 도착날짜
	private int material_in_cnt;//입고예정수량 
	private Integer state;//자재입고여부 상태
	
	//날짜검색에 필요한 변수
	private String start_date;//검색 시작날짜
	private String end_date;// 검색 끝 날짜
	
	//
	private Integer purc_order_no;       // 거래명세서에서 온 발주번호
	private String purc_order_code; // 최종적으로 보고 싶은 시리얼 코드
	private Integer purc_order_status;//구매마감 표시
	private String purc_order_reg_date;
	
	public IncomingDTO(){}

	public IncomingDTO(int material_no, String material_name, String material_code, String material_raw_material,
			String material_description, String material_unit, String material_etc, int mstorage_no, int mstorage_stock,
			String mstorage_code, String mstorage_plant_code, int emp_no, String emp_name, String sup_name, int sup_no,
			int product_no, int material_in_no, String material_in_date, String mstorage_in_date, int material_in_cnt,
			Integer state, String start_date, String end_date, Integer purc_order_no, String purc_order_code,
			Integer purc_order_status, String purc_order_reg_date) {
		super();
		this.material_no = material_no;
		this.material_name = material_name;
		this.material_code = material_code;
		this.material_raw_material = material_raw_material;
		this.material_description = material_description;
		this.material_unit = material_unit;
		this.material_etc = material_etc;
		this.mstorage_no = mstorage_no;
		this.mstorage_stock = mstorage_stock;
		this.mstorage_code = mstorage_code;
		this.mstorage_plant_code = mstorage_plant_code;
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.sup_name = sup_name;
		this.sup_no = sup_no;
		this.product_no = product_no;
		this.material_in_no = material_in_no;
		this.material_in_date = material_in_date;
		this.mstorage_in_date = mstorage_in_date;
		this.material_in_cnt = material_in_cnt;
		this.state = state;
		this.start_date = start_date;
		this.end_date = end_date;
		this.purc_order_no = purc_order_no;
		this.purc_order_code = purc_order_code;
		this.purc_order_status = purc_order_status;
		this.purc_order_reg_date = purc_order_reg_date;
	}

	public int getMaterial_no() {
		return material_no;
	}

	public void setMaterial_no(int material_no) {
		this.material_no = material_no;
	}

	public String getMaterial_name() {
		return material_name;
	}

	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}

	public String getMaterial_code() {
		return material_code;
	}

	public void setMaterial_code(String material_code) {
		this.material_code = material_code;
	}

	public String getMaterial_raw_material() {
		return material_raw_material;
	}

	public void setMaterial_raw_material(String material_raw_material) {
		this.material_raw_material = material_raw_material;
	}

	public String getMaterial_description() {
		return material_description;
	}

	public void setMaterial_description(String material_description) {
		this.material_description = material_description;
	}

	public String getMaterial_unit() {
		return material_unit;
	}

	public void setMaterial_unit(String material_unit) {
		this.material_unit = material_unit;
	}

	public String getMaterial_etc() {
		return material_etc;
	}

	public void setMaterial_etc(String material_etc) {
		this.material_etc = material_etc;
	}

	public int getMstorage_no() {
		return mstorage_no;
	}

	public void setMstorage_no(int mstorage_no) {
		this.mstorage_no = mstorage_no;
	}

	public int getMstorage_stock() {
		return mstorage_stock;
	}

	public void setMstorage_stock(int mstorage_stock) {
		this.mstorage_stock = mstorage_stock;
	}

	public String getMstorage_code() {
		return mstorage_code;
	}

	public void setMstorage_code(String mstorage_code) {
		this.mstorage_code = mstorage_code;
	}

	public String getMstorage_plant_code() {
		return mstorage_plant_code;
	}

	public void setMstorage_plant_code(String mstorage_plant_code) {
		this.mstorage_plant_code = mstorage_plant_code;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getSup_name() {
		return sup_name;
	}

	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}

	public int getSup_no() {
		return sup_no;
	}

	public void setSup_no(int sup_no) {
		this.sup_no = sup_no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getMaterial_in_no() {
		return material_in_no;
	}

	public void setMaterial_in_no(int material_in_no) {
		this.material_in_no = material_in_no;
	}

	public String getMaterial_in_date() {
		return material_in_date;
	}

	public void setMaterial_in_date(String material_in_date) {
		this.material_in_date = material_in_date;
	}

	public String getMstorage_in_date() {
		return mstorage_in_date;
	}

	public void setMstorage_in_date(String mstorage_in_date) {
		this.mstorage_in_date = mstorage_in_date;
	}

	public int getMaterial_in_cnt() {
		return material_in_cnt;
	}

	public void setMaterial_in_cnt(int material_in_cnt) {
		this.material_in_cnt = material_in_cnt;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Integer getPurc_order_no() {
		return purc_order_no;
	}

	public void setPurc_order_no(Integer purc_order_no) {
		this.purc_order_no = purc_order_no;
	}

	public String getPurc_order_code() {
		return purc_order_code;
	}

	public void setPurc_order_code(String purc_order_code) {
		this.purc_order_code = purc_order_code;
	}

	public Integer getPurc_order_status() {
		return purc_order_status;
	}

	public void setPurc_order_status(Integer purc_order_status) {
		this.purc_order_status = purc_order_status;
	}

	public String getPurc_order_reg_date() {
		return purc_order_reg_date;
	}

	public void setPurc_order_reg_date(String purc_order_reg_date) {
		this.purc_order_reg_date = purc_order_reg_date;
	}

	@Override
	public String toString() {
		return "IncomingDTO [material_no=" + material_no + ", material_name=" + material_name + ", material_code="
				+ material_code + ", material_raw_material=" + material_raw_material + ", material_description="
				+ material_description + ", material_unit=" + material_unit + ", material_etc=" + material_etc
				+ ", mstorage_no=" + mstorage_no + ", mstorage_stock=" + mstorage_stock + ", mstorage_code="
				+ mstorage_code + ", mstorage_plant_code=" + mstorage_plant_code + ", emp_no=" + emp_no + ", emp_name="
				+ emp_name + ", sup_name=" + sup_name + ", sup_no=" + sup_no + ", product_no=" + product_no
				+ ", material_in_no=" + material_in_no + ", material_in_date=" + material_in_date
				+ ", mstorage_in_date=" + mstorage_in_date + ", material_in_cnt=" + material_in_cnt + ", state=" + state
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", purc_order_no=" + purc_order_no
				+ ", purc_order_code=" + purc_order_code + ", purc_order_status=" + purc_order_status
				+ ", purc_order_reg_date=" + purc_order_reg_date + "]";
	}

	
}
