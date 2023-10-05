package edu.kh.project.common;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


// ���� ó���� ��Ʈ�ѷ� (������Ʈ ����)
@ControllerAdvice
public class ExceptionController extends HttpServlet{
	
	
	@ExceptionHandler(Exception.class)
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
	
	@ExceptionHandler(SQLException.class)
	public String exceptionHandler2(Exception e, Model model) {
		
		// Exception e : ���� ������ ����ִ� ��ü
		// Model model : ������ ���޿� ��ü (request scope �⺻)
		
		e.printStackTrace(); // ���� ����/�߻� �޼��� Ȯ��

        model.addAttribute("e", e); // ����  �߻� �� forward�Ǵ� �������� e�� ������. (request scope�� �����ϴ�)
		
        // ������ ���ؼ� ?
        // View Resolver�� prefix, suffix�� �ٿ� JSP ��θ� �����
        // return "/WEB-INF/views/common/error.jsp"
		
        return "common/error";

}
	
	@ExceptionHandler(IOException.class)
	public String exceptionHandler3(Exception e, Model model) {
		
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
