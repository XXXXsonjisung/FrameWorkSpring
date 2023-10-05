package edu.kh.project.member.controller;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;

@Controller // ��û/���� Ŭ���� + bean ���(Spring �����ϴ� ��ü)
@RequestMapping("/member") //����� �ּ� �պκ� �ۼ�, member�� �����ϴ� ��û�� �ش� ��Ʈ�ѷ����� ó��
@SessionAttributes({"loginMember"}) // Model�� �̸�(key)�� ������ session���� �߰�
public class MemberController {
	
	// ��ϵ� Bean �߿��� �ʵ�� Ÿ���� ��ġ�ϴ� Bean ����
	// -> MemberService�� ������ MemberServiceImpl�� Bean ����
	@Autowired
	private MemberService service;
	
	

	// �α��� : /member/login
	// �α׾ƿ� : /member/logout
	
	// /member/login
	
	// @RequestMapping : ��û �ּҿ� �´� Ŭ����/�޼��� ����
	// @RequestMapping("��û�ּ�") -> GET / POST ���� X, �ּҸ� ������ ���������� GET��û�� ���
	// @RequestMapping(value="/login", method=RequestMethod.GET/POST) -> GET / POST ����� ����

	
	
	//@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req) {
	
		// �Ķ���� ���� ��� 1 : HttpServletRequest�� �̿��ϴ� ���
		// -> Controller �޼��忡 �Ű������� HttpServletRequest�� �ۼ�
	
		// �Ű������� ������ ��� ������ ����
		// Spring �����ϴ� Argument Resolver(�Ű������ذ��)�� �ڵ�����
		// �������ְ� �ذ�����.
		
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		// ***********redirect ���! *******************
		// "redirect:��û�ּ�"
		return "redirect:/";
	
}
	// @PostMapping : @RequestMapping �ڽ�����
	//				Post ��� ��û�� �����ϴ� ������̼�
	//@PostMapping("/login")
	public String login(/*@RequestParam("inputEmail")*/ String inputEmail,
						/*@RequestParam("inputPw")*/ String inputPw) {
						
		// �Ķ���� ���� ��� 2 : @RequestParam ������̼� �̿�(+�������)
		 
		// @RequestParam ������̼�
		// - request��ü�� �̿��� �Ķ���� ���� ������̼�
		// - �Ű����� ���� ������̼� �ۼ��ϸ�, �Ű������� ���� ���Ե�.
		
		// ** �Ķ������ name �Ӽ�����
		// 	�Ű��������� ������ @RequestParam ���� ����! **
		
		// @RequestParam(value="name", required="fasle", defaultValue="1")
		// [�Ӽ�]
		// value : ���� ���� input �±��� name �Ӽ���
		
		// required : �Էµ� name �Ӽ��� �Ķ���� �ʼ� ���� ����(�⺻�� true)
		// -> required = true�� �Ķ���Ͱ� �������� �ʴ´ٸ� 400 Bad Request ���� �߻�
		// -> required = true�� �Ķ���Ͱ� null�� ��쿡�� 400 Bad Request

		// defaultValue : �Ķ���� �� ��ġ�ϴ� name �Ӽ� ���� ���� ��쿡 ������ �� ����.
		// -> required = false�� ��� ���
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		
		
		return "redirect:/";
	}
	
	//@PostMapping("/login")
	public String login(@ModelAttribute Member inputMember) {
		
		// �Ķ���� ���� ��� 3 : @ModelAttribute �̿��� ���
		
		// - DTO(�Ǵ� VO)�� ���� ����ϴ� ������̼�
		
		// - ���� ���� �Ķ������ name �Ӽ� ����
		// 	 ���� ���Ǵ� DTO�� �ʵ��� ���ٸ�
		// 	 �ڵ����� setter�� ȣ���ؼ� �ʵ忡 ���� ���� 
		
		System.out.println(inputMember);

		// ** @ModelAttribute ��� �� ���� ���� **
		// - DTO�� �⺻ �����ڰ� �ʼ��� �����ؾ� �Ѵ�
		// - DTO�� setter�� �ʼ��� �����ؾ� �Ѵ�
		
		// ** @ModelAttribute ������̼��� ������ �����ϴ� ! **
		
		// ** @ModelAttribute�� �̿��� ���� �ʵ忡 ���õ� ��ü��
		// 	Ŀ��� ��ü ��� �θ���.
		
		
		// Member [memberEmail = user123, memberPw = pass123.. ]
		
		
		return "redirect:/";
		
	}
	
	
	/* �� �α��� �޼��� */
	
	@PostMapping("/login")
	public String login(Member inputMember, Model model,
							@RequestHeader("referer") String referer,
							RedirectAttributes ra,
							@RequestParam(value="saveId", required=false) String saveId,
							HttpServletResponse resp
							) {
		
		
		// @RequestHeader(value="referer") String referer
		// -> ��û HTTP header���� "referer" (���� �ּ�) ���� ����
		// �Ű� ���� String referer�� ����
			
		
		// Model : ������ ���޿� ��ü
		// -> �����ͷ� K : V �������� ��� ����
		// -> �⺻������ request scope
		// -> @SessionAttributes ������̼ǰ� �Բ� ��� �� session scope
		
		// @RequestParam(value="saveId", required=false)
		// -> name �Ӽ����� saveId�� �Ķ���͸� ���޹޾Ƽ� ����
		// required ���ۼ� �� �⺻ �� true
		// required = false : �ʼ� �ƴ�(null ���)
		
		
		//�α��� ���� ȣ��
		Member loginMember = service.login(inputMember);
		
		// DB ��ȸ ��� Ȯ��
		//System.out.println(loginMember);
		
		// �α��� ����� ���� ��Ÿ�̷�Ʈ ��θ� �ٸ��� ����
		String path = "redirect:";
		
		if(loginMember != null) { // �α��� ������
			path += "/";	// ������������ �ٸ���Ʈ
			
			// session loginMember �߰�
			// Servlet : HttpSession.setAttribute(key, value)
			// Spring : Model + @SessionAttributes
			
			// 1) model�� �α����� ȸ�� ���� �߰�
			model.addAttribute("loginMember", loginMember);
			// -> ����� request scope
			
			// 2) Ŭ���� ���� @SessionAttributes �߰�
			// -> ���� session scope
			
			
			// *****************************
			
			// �ƾƵ� ���� (Cookie)
			
			/* Cookie��!
			 * - Ŭ���̾�Ʈ ��(������)���� �����ϴ� ����
			 * 
			 * - ��Ű���Ͽ� ��ϵ� �ּ� ��û �� ����
			 *   �ڵ����� ��û�� ÷�εǾ��ִ� ������ ���޵�.
			 *   
			 * - ������ ���޵� ��Ű��
			 *   �� �߰�, ���� ���� ���� ������ ��
			 *   �ٽ� Ŭ���̾�Ʈ���� ��ȯ
			 * 
			 * 
			 * 
			 */
			
			// ��Ű ����(�ش� ��Ű�� ���� �����͸� k:v�� ����)
			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
			
			if(saveId != null) { // üũ�� �Ǿ��� ��
				
				// �� ��(30��) ���� �����Ǵ� ��Ű ���� 
				cookie.setMaxAge(60*60*24*30);  // �ʴ��� ����
				
				
			} else { // üũ�� �ȵǾ��� ��
				
				// 0�� ���� �����Ǵ� ��Ű ����
				// -> ������ ��Ű�� �����Ǿ��־��ٸ� �ش� ��Ű�� ����
				cookie.setMaxAge(0);
				
			}
			
			
			// Ŭ���̾�Ʈ�� � ��û�� �Ҷ� ��Ű�� ÷�ε��� ���(�ּ�) ����
			cookie.setPath("/"); // localhost: /���� ��� �ּ�
								// ex) / , /member/login, /member/logout ��
								// ��� ��û�� ��Ű�� ÷��
			
			
			// ���� ��ü(HttpServletResponse) �� �̿��ؼ�
			// ������� ��Ű�� Ŭ���̾�Ʈ���� ����
			resp.addCookie(cookie);
			
			
		}else { //�α��� ����
			path += referer;
		
			// message �߰� (���̵� �Ǵ� ��й�ȣ ����ġ)
			
			/* redirect(���û) ��
			 * ���� ��û(request)�� �������
			 * ���ο� ��û(request)�� ����� �Ǿ�
			 * redirect�� ������������ ���� ��û�� �������� �ʴ´�!
			 * -> ���� �ϰ� ������ ��¿�� ���� session scope�� �̿�
			 * 
			 * RedirectAttribues�� ���������� ����
			 * - �����̷�Ʈ �� �����͸� request scope�� ������ �� �ְ��Ѵ� ��ü
			 * 
			 * ���� �� : request scope
			 * 
			 * ���� �� : session scope�� ��� �̵�
			 * 
			 * ���� �� : request scope�� ����
			 * 
			 * 
			 * */
			
			// addFlashAttribute : ��� session �� �߰�
			ra.addFlashAttribute("message", "���̵� �Ǵ� ��й�ȣ ����ġ");
			
		}
		
		
		return path;
	
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status/*HttpSession session*/) {
		
		// SessionStatus : ���� ���¸� �����ϴ� ��ü
		
		//session.invalidate(); // ���� ��ȿȭ
		status.setComplete();
		
		return "redirect:/";
		
	}
	
	/*
	 *  ������ ���� ó�� ���(3����, �ߺ� ��� ����)
	 *  
	 *  1 ���� : �޼��� ������ ó��
	 *  		-> try - catch / throws
	 *  
	 *  2 ���� : Ŭ���� ������ ó��
	 *  		-> @ExceptionHandler
	 *  
	 *  3 ���� : ���α׷� ����(����)
	 *  		-> @ControllerAdvice
	 * 
	 */

	
	// ���� Ŭ�������� �߻��ϴ� ��� ���ܸ� ��Ƽ� ó��
	//@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		
		// Exception e : ���� ������ ����ִ� ��ü
		// Model model : ������ ���޿� ��ü (request scope �⺻)
		
		e.printStackTrace(); // ���� ����/�߻� �޼��� Ȯ��

        model.addAttribute("e", e); // ����  �߻� �� forward�Ǵ� �������� e�� ������. (request scope�� �����ϴ�)
		
        // ������ ���ؼ� ?
        // View Resolver�� prefix, suffix�� �ٿ� JSP ��θ� �����
        // return "/WEB-INF/views/common/error.jsp"
		
        return "common/error";
	
        
	}
	
}