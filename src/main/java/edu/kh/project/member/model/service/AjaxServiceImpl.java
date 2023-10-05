package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.AjaxDAO;

@Service // �������� ��� + bean ���
public class AjaxServiceImpl implements AjaxService{
	
	@Autowired
	private AjaxDAO dao;

	// �г������� ��ȭ��ȣ ��ȸ
	@Override
	public String selectMemberTel(String nickname) {
		
		
		return dao.selectMemberTel(nickname);
	}
	
}
