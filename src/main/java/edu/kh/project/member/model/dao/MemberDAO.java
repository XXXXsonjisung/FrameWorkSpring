package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // Persistence Layer, ���Ӽ� ���� Ŭ����
			// (DB���� Ŭ����) + Bean ���
public class MemberDAO {
	
	// DAO�� DB�� �����ϱ� ���� Connection�� ���������� �ʿ��ϴ�
	// + Mybatis ���Ӽ� �����ӿ�ũ�� �̿��Ϸ��� Connection�� �̿��ؼ� ������� ��ü
	// SqlSessionTemplate�� ���
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** �α��� DAO
	 * @param inputMember
	 * @return ȸ�� ���� �Ǵ� null
	 */
	public Member login(Member inputMember) {
		
		// ���̹�Ƽ���� �̿��ؼ� 1�� ��ȸ(selectOne)
		
		// sqlSession.selectOne("namespace��.id��", ������ ��);
		// -> namespace�� ��ġ�ϴ� Mapper����
		// id�� ��ġ�ϴ� SQL ������ ���� ��
		// ����� 1�� ��ȯ
		
		
		return sqlSession.selectOne("memberMapper.login", inputMember);
	}

}
