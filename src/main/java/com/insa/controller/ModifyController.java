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

import com.insa.service.InputService;
import com.insa.service.ModifyService;
import com.insa.vo.CommonVo;
import com.insa.vo.FileVo;
import com.insa.vo.InputInfoVo;
import com.insa.vo.InsaVo;

@Controller
@RequestMapping(value="/modify")
public class ModifyController {

	@Autowired
	private ModifyService modifyService;
	
	@Autowired
	private InputService inputService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String modify(@RequestParam(value = "sabun") int sabun,
						 Model model) {
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
		
		InsaVo insaVo = modifyService.getInsaVoBySabun(sabun);
		System.out.println("modify : " + insaVo.toString());
		
		/* email 주소 처리 */
		String email = insaVo.getEmail();
		String[] words = email.split("@");
		String emailAddr = "@" + words[1];
		String email_sel = "";
		
		insaVo.setEmail(words[0]);
		for(int i = 0 ; i < emailList.size(); i++) {
			if(emailAddr.equals(emailList.get(i).getName())) {
				email_sel = emailList.get(i).getCode();
			}
		}
		
		model.addAttribute("loadType", "modify");
		model.addAttribute("insaVo", insaVo);
		model.addAttribute("commonMap", map);
		model.addAttribute("email_sel", email_sel);
		
		return "/insa-form";
	}
	
	@ResponseBody
	@RequestMapping(value = "getfileorgname", method = RequestMethod.POST)
	public String getFileOrgName(@RequestParam(value = "saveName") String saveName) {
		
		FileVo fileVo = new FileVo();
		
		fileVo = modifyService.getFileVoBySaveName(saveName);
		
		return fileVo.getOrgName();
	}
	
	@RequestMapping(value="/insamodify", method=RequestMethod.POST)
	public String insamodify(@ModelAttribute InsaVo vo, 
						 @RequestParam("email_sel") String email_sel,
						 Model model) {
		System.out.println("insamodify : " + vo.toString());
		
		// 0. 저장되어있는 값을 가져온다.
		InsaVo prevInsaVo = modifyService.getInsaVoBySabun(vo.getSabun());
		
		// 1. 이메일에 주소를 추가해준다.
		String email = vo.getEmail();
		List<CommonVo> emailList = inputService.getEmailList();
		for(int i = 0 ; i < emailList.size(); i++) {
			if(email_sel.equals(emailList.get(i).getCode())) {
				email += emailList.get(i).getName();
			}
		}
		vo.setEmail(email);
		
		// 2. 새로운 파일이 들어왔으면 해당 파일에 sabun 넣어주고 예전 파일은 DB에서 삭제한다.
		if(!vo.getProfile().equals(prevInsaVo.getProfile())) {
			inputService.updateFile(vo.getSabun(), vo.getProfile());
			if(prevInsaVo.getProfile() != null) {
				modifyService.deleteFile(prevInsaVo.getProfile());
			}
		}
		if(!vo.getCmp_reg_image().equals(prevInsaVo.getCmp_reg_image())) {
			inputService.updateFile(vo.getSabun(), vo.getCmp_reg_image());
			if(prevInsaVo.getCmp_reg_image() != null) {
				modifyService.deleteFile(prevInsaVo.getCmp_reg_image());
			}
		}
		if(!vo.getCarrier().equals(prevInsaVo.getCarrier())) {
			inputService.updateFile(vo.getSabun(), vo.getCarrier());
			if(prevInsaVo.getCarrier() != null) {
				modifyService.deleteFile(prevInsaVo.getCarrier());
			}
		}
		
		
		// 3. 넘어온 값들을 데이터 베이스에 수정해준다.
		modifyService.modifyInsaByInsaVo(vo);
		
		
		model.addAttribute("sabun", vo.getSabun());
		
		return "redirect:/modify";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getinputinfo", method=RequestMethod.GET )
	public List<InputInfoVo> jqGridGetInputInfo(@RequestParam("sabun") int sabun) {
		List<InputInfoVo> list = modifyService.getInputInfo(sabun);
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/inputinfoedit", method=RequestMethod.POST )
	public InputInfoVo editInputInfo(@ModelAttribute InputInfoVo inputInputVo) {
		System.out.println(inputInputVo.toString());
		
		return inputInputVo;
	}
	
	@ResponseBody
	@RequestMapping(value = "/inputinfoadd", method=RequestMethod.POST )
	public InputInfoVo addInputInfo(@ModelAttribute InputInfoVo inputInputVo) {
		System.out.println(inputInputVo.toString());
		
		return inputInputVo;
	}
	
	@ResponseBody
	@RequestMapping(value = "/inputinfodel", method=RequestMethod.POST )
	public void delInputInfo(@ModelAttribute InputInfoVo inputInputVo) {
		System.out.println(inputInputVo.toString());
		
	}
}
