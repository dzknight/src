package www.silver.dao;



import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.vo.MemberVO;


@Repository  
public class MemberDAOImpl implements IF_MemberDAO{
	@Inject
	private SqlSession sqlSession;
	@Override
	public void insertMember(MemberVO mvo) {
		// TODO Auto-generated method stub
		sqlSession.insert("www.silver.dao.IF_MemberDAO.insertOne", mvo);
	}
	@Override
	public MemberVO selectOne(String id) {
		// TODO Auto-generated method stub
		MemberVO m=sqlSession.selectOne("www.silver.dao.IF_MemberDAO.selectOne",id);
		return m;
	}



}
