package edu.kh.project.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.project.member.model.service.AjaxService;

@Controller // ��û/���� ���� + bean ���
public class AjaxController {
	
	@Autowired
	private AjaxService service;
	
	
	// ** �г������� ��ȭ��ȣ ��ȸ
	@GetMapping("/selectMemberTel")
	@ResponseBody
	public String selectMemberTel(String nickname) {
							// ������Ʈ���� ����ִ� �Ķ����

		
		// return �����̷�Ʈ / ������ -> ���ο� ȭ�� ���� (�����)
		
		// return ������ -> �����͸� ��û�� ������ ��ȯ (�񵿱��)

		// @ResponseBody
		// -> Controller�� ����� �����͸� ��ȯ�� �� ����ϴ� ������̼� 
	
		
		
		return service.selectMemberTel(nickname);
	}
	
	

}
