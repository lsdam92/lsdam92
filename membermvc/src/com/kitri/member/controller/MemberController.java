package com.kitri.member.controller;

import javax.servlet.http.*;

import com.kitri.member.model.*;
import com.kitri.member.model.service.MemberService;

public class MemberController {

	private static MemberController memberController;
	
	static{
		memberController = new MemberController();
	}
	
	private MemberController() {
		
	}
	
	public static MemberController getMemberController() {
		return memberController;
	}
	
	public String register(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
		MemberDetailDto memberDetailDto = new MemberDetailDto();
		memberDetailDto.setName(request.getParameter("name"));
		memberDetailDto.setId(request.getParameter("id"));
		memberDetailDto.setPass(request.getParameter("pass"));
		memberDetailDto.setEmailid(request.getParameter("emailid"));
		memberDetailDto.setEmaildomain(request.getParameter("emaildomain"));
		memberDetailDto.setTel1(request.getParameter("tel1"));
		memberDetailDto.setTel2(request.getParameter("tel2"));
		memberDetailDto.setTel3(request.getParameter("tel3"));
		memberDetailDto.setZipcode(request.getParameter("zipcode"));
		memberDetailDto.setAddress(request.getParameter("address"));
		memberDetailDto.setAddressDetail(request.getParameter("address_detail"));
		
		int cnt = MemberServiceImpl.getMemberService().registerMember(memberDetailDto);
		if(cnt != 0) {
//			java는 대소문자 구분
			request.setAttribute("userInfo", memberDetailDto);
			path = "user/member/registerok.jsp";
		}else {
			path = "user/member/registerfail.jsp";
		}
		return path;
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {
		String path="/index.jsp";
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDto memberDto = MemberServiceImpl.getMemberService().loginMember(id, pass);
		if(memberDto != null) {
			///////////////////////Cookie////////////////////
			String idsv = request.getParameter("idsave");
			if("idsave".equals(idsv)) {
			Cookie cookie = new Cookie("kid_inf", id);
			cookie.setDomain("localhost");
			cookie.setPath(request.getContextPath());
			cookie.setMaxAge(60*60*24*365*50);
			response.addCookie(cookie);
			}else {
				Cookie cookie[] = request.getCookies();
				if(cookie != null){
					for(Cookie c : cookie){
						if("kid_inf".equals(c.getName())){
							c.setDomain("localhost");
							c.setPath(request.getContextPath());
							c.setMaxAge(0);
							response.addCookie(c);
							break;
						}
					}
				}
			}
			///////////////////////Session////////////////////
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", memberDto);
			//////////////////////////////////////////////////
			path = "/user/login/loginok.jsp";
		}else {
			path = "/user/login/loginfail.jsp";
		}
		
		return path;
	}

	public String loginout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.setAttribute("userInfo", null);
//		session.removeAttribute("userInfo");
//		invalidate() session안의 모든것을 무효화/삭제-일괄삭제
		session.invalidate();
		return "/user/login/login.jsp";
	}
}
