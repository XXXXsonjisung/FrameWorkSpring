package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // DB ���� �ǹ� + bean ���� ���
public class AjaxDAO {

	@Autowired // bean �߿��� Ÿ����
	private SqlSessionTemplate sqlSession;

	
	// �г������� ��ȭ��ȣ ��ȸ
	public String selectMemberTel(String nickname) {
		
		
		return sqlSession.selectOne("ajaxMapper.selectMemberTel", nickname);
	}
	
	
	
}
