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
import org.springframework.web.bind.annotation.ResponseBody;

import com.insa.service.InputService;
import com.insa.service.SearchService;
import com.insa.vo.CommonVo;
import com.insa.vo.SearchResultVo;
import com.insa.vo.SearchVo;

@Controller
@RequestMapping(value="/search")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@Autowired
	private InputService inputService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String search(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<CommonVo> joinList = inputService.getJoinList();
		List<CommonVo> jobList = inputService.getJobList();
		List<CommonVo> posList = inputService.getPosList();
		
		map.put("joinList", joinList);
		map.put("jobList", jobList);
		map.put("posList", posList);
		
		model.addAttribute("commonMap", map);
		
		return "/search";
	}
	
	@ResponseBody
	@RequestMapping(value="insasearch", method=RequestMethod.POST)
	public List<SearchResultVo> insaSearch(@ModelAttribute SearchVo searchVo) {
		System.out.println(searchVo.toString());
		
		return searchService.getSearchResultBySearchVo(searchVo);
	}
}
