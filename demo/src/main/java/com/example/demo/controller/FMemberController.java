package com.example.demo.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.MemberEntity;
import com.example.demo.service.MemberService;
import com.example.demo.service.SecurityService;

@Controller
@RequestMapping("/member/*")
public class FMemberController {

	@Autowired private MemberService memberService;
	@Autowired private SecurityService securityService;
	
	
	@RequestMapping(value ="/member_regist",method=RequestMethod.GET)
	public void member_regist(Model model) {
		
	}
	
	@RequestMapping(value ="/memberSave",method=RequestMethod.POST)
	@ResponseBody
	public HashMap memberJoin(@RequestBody HashMap map,Model model) throws Exception {
		
		MemberEntity entity = memberService.memberJoin(map);
		String result = "";
		if (entity != null) {
			result = "success";
		}
		
		HashMap resultMap = new HashMap();
		resultMap.put("result", result);
		
		return resultMap;
	}
	
	@RequestMapping(value ="/idCheck",method=RequestMethod.POST)
	@ResponseBody
	public HashMap memberIdCheck(@RequestBody HashMap map,Model model) throws Exception {
		
		Integer mbrCnt = memberService.memberCheck(String.valueOf(map.get("email")));
		String result = "";
		if (mbrCnt <= 0) {
			result = "success";
		} else {
			result = "fail";
		}
		
		HashMap resultMap = new HashMap();
		resultMap.put("result", result);
		
		return resultMap;
	}
	
	@RequestMapping(value = "/member_login",method=RequestMethod.GET)
	public void member_login(Model model) {
		
	}
	
	@RequestMapping(value = "/doLogin", method=RequestMethod.POST)
	@ResponseBody
	public HashMap doLogin(@RequestBody HashMap<String, String> user) throws Exception {

		HashMap  map = new HashMap<>();
		if (memberService.memberCheck(user.get("email")) > 0) {
			if (memberService.checkUserInfo(user).equals("true")) {
				String token = securityService.createToken(String.valueOf(user.get("email")), (2 * 1000 * 60));
				
				map.put("token", token);
				map.put("email", user.get("email"));
				map.put("result", "success");
			} else {
				map.put("token", "");
				map.put("result","fail");
			}
		} else {
			map.put("token", "");
			map.put("result","fail");
		}
		return map;			
	}
	
	@ResponseBody
	@RequestMapping(value = "/get/token", method=RequestMethod.POST)
    public Map<String, Object> getSubject(@RequestParam("token") String token) {
        String subject = securityService.getSubject(token);
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("result", subject);
        return map;
    }
	
}
