package com.kitri.member.model;


import java.util.*;


import com.kitri.member.model.dao.MemberDaoImpl;
import com.kitri.member.model.service.MemberService;
public class MemberServiceImpl implements MemberService {
//	싱글톤패턴{
//	2.
	private static MemberService memberService;
//	3.
	static {
		memberService = new MemberServiceImpl();
	}

	// 외부에서 호출불가능하다
//	1.
	private MemberServiceImpl() {

	}

//	4.
	public static MemberService getMemberService() {
		return memberService;
	}

//}
	@Override
	public String idCheck(String id) {
		int cnt = MemberDaoImpl.getMemberDao().idCheck(id);
//		System.out.println("cnt : " + cnt);
		String result = "";
		result += "<idcount>\n";
		result += "<cnt>" + cnt + "</cnt>\n";
		result += "</idcount>";
		return result;
	}

	@Override
	public String zipSearch(String doro) {
		String result = "";
		List<ZipcodeDto> list = MemberDaoImpl.getMemberDao().zipSearch(doro);
		result += "<ziplist>\n";
		for (ZipcodeDto zipDto : list) {
			result += " <zip>\n";
			result += "	<zipcode>" + zipDto.getZipcode() + "</zipcode>\n";
			result += "	<address><![CDATA[" + zipDto.getSido() + " " + zipDto.getGugun() + " " + zipDto.getUpmyon()
					+ " " + zipDto.getDoro() + " " + zipDto.getBuildingNumber() + " " + zipDto.getSigugunBuildingName()
					+ "]]></address>\n";
			result += " </zip>";
		}
		result += "</ziplist>";
		return result;
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		return MemberDaoImpl.getMemberDao().registerMember(memberDetailDto);
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		
		return MemberDaoImpl.getMemberDao().loginMember(map);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
