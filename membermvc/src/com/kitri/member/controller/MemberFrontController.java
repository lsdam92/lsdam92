package com.kitri.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberServiceImpl;
import com.kitri.util.MoveUrl;
import com.kitri.util.SiteConstance;

@WebServlet("/user")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	service객체는 controller에서 단 하나만 생성해야한다.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		
		
		String path = "/index.jsp";
		
		// ** act가 null일때 null pointer error가 남!
		//if(act.equals("mvjoin")) {
		//	}
		
		// ** 값을 받아낼 때는 이 방법이 효율적!
		if("mvjoin".equals(act)) {
			MoveUrl.redirect(request, response, "/membermvc/user/member/member.jsp");			
		} else if("mvlogin".equals(act)) {
			MoveUrl.redirect(request, response, "/membermvc/user/login/login.jsp");						
		} else if("idcheck".equals(act)) {
			String sid = request.getParameter("sid");
			String resultXML = MemberServiceImpl.getMemberService().idCheck(sid);
			
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(resultXML);
		} else if("zipsearch".equals(act)) {
			String doro = request.getParameter("doro");
//			System.out.println("검색 도로명 : " + doro);
			String resultXML = MemberServiceImpl.getMemberService().zipSearch(doro);
//			System.out.println(resultXML);
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(resultXML);
		} else if("register".equals(act)) {
			path = MemberController.getMemberController().register(request, response);
			MoveUrl.forward(request, response, path);
		} else if("login".equals(act)) {
			path = MemberController.getMemberController().login(request, response);
			MoveUrl.redirect(request, response, path);
		} else if("loginout".equals(act)) {
			path = MemberController.getMemberController().loginout(request, response);
			MoveUrl.redirect(request, response, path);
		}
		
		// get은 클라이언트가 호출할 때마다 돌아감
		
		// 클라이언트의 요구를 분석할 땐 if문이 가장 나음
		// =>각 요구에 맞는 메소드 정의 방법은 어차피, doget에서 호출해야하기 때문에 결국 if문을 써야함
		// ==> 나중에 spring을 쓰면, if문 대신 각각 요구에 맞는 메소드 정의해서 사용할 수 있음
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.ENCODE);
		doGet(request, response);
	}

}