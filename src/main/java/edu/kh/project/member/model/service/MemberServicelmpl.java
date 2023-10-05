package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service // ����Ͻ� ����(������ ����, DAO ȣ��, Ʈ����� ����)ó���ϴ� Ŭ���� ���
		// + Bean���� ����ϴ� ������̼�
public class MemberServicelmpl implements MemberService{

	// @Autowired : �ۼ��� �ʵ��
	// Bean���� ��ϵ� ��ü �� Ÿ���� ��ġ�ϴ� Bean�� 
	// �ش� �ʵ忡 �ڵ� ����(Injection) �ϴ� ������̼�.
	// ** DI(Dependency Injection, ������ ����)
	// -> ��ü�� ���� ������ �ʰ�, Spring�� ����� ������(Spring�� ����)
	
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired // bean���� ��ϵ� ��ü �� Ÿ���� ��ġ�ϴ� ��ü�� DI
	private BCryptPasswordEncoder bcrypt;

	
	@Override
	public Member login(Member inputMember) {
		
		System.out.println("��ȣȭ Ȯ�� 1:" + bcrypt.encode( inputMember.getMemberPw() ) );
		System.out.println("��ȣȭ Ȯ�� 2:" + bcrypt.encode( inputMember.getMemberPw() ) );
		System.out.println("��ȣȭ Ȯ�� 3:" + bcrypt.encode( inputMember.getMemberPw() ) );
		System.out.println("��ȣȭ Ȯ�� 4:" + bcrypt.encode( inputMember.getMemberPw() ) );
		System.out.println("��ȣȭ Ȯ�� 5:" + bcrypt.encode( inputMember.getMemberPw() ) );
		
		
		// dao �޼��� ȣ��
		Member loginMember = dao.login(inputMember);
		
		if(loginMember != null) {
			
			// �Է��� pw, ��ȣȭ�� pw ������ Ȯ��
			
			// ���� ���
			if(bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
				
				// ��й�ȣ�� �������� �ʱ� ���ؼ� �α��� �������� ����
				loginMember.setMemberPw(null);
			} else { // �ٸ� ���
				loginMember = null;
			}
			
		}
		
		
		
		return loginMember;
		
	}
		
}
	

