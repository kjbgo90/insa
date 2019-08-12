package com.insa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.insa.service.InputService;
import com.insa.vo.CommonVo;
import com.insa.vo.FileVo;
import com.insa.vo.InsaVo;

@Controller
@RequestMapping(value="/input")
public class InputController {
	
	@Autowired
	private InputService inputService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String input(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<CommonVo> emailList = inputService.getEmailList();
		List<CommonVo> jobList = inputService.getJobList();
		List<CommonVo> sexList = inputService.getSexList();
		List<CommonVo> posList = inputService.getPosList();
		List<CommonVo> deptList = inputService.getDeptList();
		List<CommonVo> joinList = inputService.getJoinList();
		List<CommonVo> gartList = inputService.getGartList();
		List<CommonVo> mTypeList = inputService.getMtypeList();
		List<CommonVo> mLevelList = inputService.getMlevelList();
		List<CommonVo> kClassList = inputService.getKclassList();
		
		map.put("emailList", emailList);
		map.put("jobList", jobList);
		map.put("sexList", sexList);
		map.put("posList", posList);
		map.put("deptList", deptList);
		map.put("joinList", joinList);
		map.put("gartList", gartList);
		map.put("mTypeList", mTypeList);
		map.put("mLevelList", mLevelList);
		map.put("kClassList", kClassList);
		
		model.addAttribute("loadType", "regist");
		model.addAttribute("commonMap", map);
		
		return "/insa-form";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute InsaVo vo, 
						 @RequestParam("email_sel") String email_sel,
						 Model model) {
		System.out.println("regist : " + vo.toString());
		
		// 1. 이메일에 주소를 추가해준다.
		String email = vo.getEmail();
		List<CommonVo> emailList = inputService.getEmailList();
		for(int i = 0 ; i < emailList.size(); i++) {
			if(email_sel.equals(emailList.get(i).getCode())) {
				email += emailList.get(i).getName();
			}
		}
		vo.setEmail(email);
		
		// 2. 넘어온 값들을 데이터 베이스에 저장해준다.
		int result = inputService.registInsa(vo);
		
		// 3. 넘어온 파일들에 sabun 넣어줌
		if(result == 1) {
			if(!"".equals(vo.getProfile())) {
				inputService.updateFile(vo.getSabun(), vo.getProfile());
			}
			if(!"".equals(vo.getCmp_reg_image())) {
				inputService.updateFile(vo.getSabun(), vo.getCmp_reg_image());
			}
			if(!"".equals(vo.getCarrier())) {
				inputService.updateFile(vo.getSabun(), vo.getCarrier());
			}
		}
		
		model.addAttribute("sabun", vo.getSabun());
		
		return "redirect:/modify";
	}
	
	@ResponseBody
	@RequestMapping(value="/fileupload", method=RequestMethod.POST)
	public FileVo fileUpload(MultipartHttpServletRequest request) {
		MultipartFile file = request.getFile("file");
		String type = request.getParameter("type");
		
		FileVo fileVo = inputService.uploadFile(file, type);
		if(fileVo != null) {
			return fileVo;
		} else {
			return null;
		}
	}
}
