package kr.co.chill.purchaseorder;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseorderDAOImpl implements PurchaseorderDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PurchaseorderDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.purchaseorderMapper.list");
	}

	@Override
	public List<PurchaseorderDTO> listSearch(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.purchaseorderMapper.listSearch", map);
	}

	@Override
	public PurchaseorderDTO detailOrderInfo(String purc_order_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.purchaseorderMapper.detailOrderInfo", purc_order_code);
	}

	@Override
	public List<PurchaseorderDTO> detailOrderList(String purc_order_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.purchaseorderMapper.detailOrderList", purc_order_code);
	}
	
	
}
