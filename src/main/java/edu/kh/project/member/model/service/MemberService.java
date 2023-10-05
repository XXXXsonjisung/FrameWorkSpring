package edu.kh.project.member.model.service;

import edu.kh.project.member.model.dto.Member;

// Service Interface ��� ����

// 1. ������Ʈ�� ��Ģ���� �ο��ϱ� ���ؼ�

// 2. Ŭ�������� ���յ��� ��ȭ ��Ű�� ���ؼ� (��ü ������ ����)
// -> ���������� ���

// 3. Spring AOP ����� ���ؼ�
// -> AOP�� spring-proxy�� �̿��ؼ� �����ϴµ�
// �� �� Service �������̽��� �ʿ��ϴ�!

public interface MemberService {

	/* �α��� ����
	 * @param inputMember (email, pw)
	 * @return email pw�� ��ġ�ϴ� �ܿ����� �Ǵ� null
	 * 
	 */



	Member login(Member inputMember);
	
}
