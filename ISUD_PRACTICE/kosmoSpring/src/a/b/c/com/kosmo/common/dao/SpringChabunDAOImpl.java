package a.b.c.com.kosmo.common.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;

@Repository
public class SpringChabunDAOImpl implements SpringChabunDAO {
	Logger logger = LogManager.getLogger(SpringChabunDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public KosmoProductVO getProductChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getProductChabun"); // getProductChabun
	}

}
