package com.insa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insa.dao.InputDao;
import com.insa.dao.SearchDao;
import com.insa.vo.CommonVo;
import com.insa.vo.SearchResultVo;
import com.insa.vo.SearchVo;

@Service
public class SearchService {
	
	@Autowired
	private SearchDao searchDao;
	
	@Autowired
	private InputDao inputDao;

	public List<SearchResultVo> getSearchResultBySearchVo(SearchVo searchVo) {
		int cnt = 0;
		String first = "";
		
		if(searchVo.getSabun() == 0) {
			cnt++;
		}
		if("".equals(searchVo.getName())) {
			cnt++;
		}
		if("00".equals(searchVo.getJoin_gbn_code())) {
			cnt++;
		}
		if("00".equals(searchVo.getPut_yn())) {
			cnt++;
		}
		if("00".equals(searchVo.getPos_gbn_code())) {
			cnt++;
		}
		if("".equals(searchVo.getJoin_day())) {
			cnt++;
		}	
		if("".equals(searchVo.getRetire_day())) {
			cnt++;
		}
		if("00".equals(searchVo.getJob_type())) {
			cnt++;
		}
		
		if(searchVo.getSabun() != 0) {
			first = "sabun";
		} else {
			if(!"".equals(searchVo.getName())) {
				first = "name";
			} else {
				if(!"00".equals(searchVo.getJoin_gbn_code())) {
					first = "join_gbn_code";
				}else {
					if(!"00".equals(searchVo.getPut_yn())) {
						first = "put_yn";
					}else {
						if(!"00".equals(searchVo.getPos_gbn_code())) {
							first = "pos_gbn_code";
						}else {
							if(!"".equals(searchVo.getJoin_day())) {
								first = "join_day";
							}else {
								if(!"".equals(searchVo.getRetire_day())) {
									first = "retire_day";
								}else {
									if(!"00".equals(searchVo.getJob_type())) {
										first = "job_type";
									}
								}
							}
						}
					}
				}
			}
		}
		
		searchVo.setNull_cnt(cnt);
		searchVo.setFirst_sql_name(first);
		
		System.out.println("SearchService : " + searchVo.toString());
		
		List<SearchResultVo> list = searchDao.selectSearchResultBySearchVo(searchVo);
		
		/*후처리 필요함 직위 코드 => 이름*/
		List<CommonVo> posList = inputDao.getCommonList("직위");
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < posList.size(); j++) {
				if(posList.get(j).getCode().equals(list.get(i).getPos_gbn_code())) {
					list.get(i).setPos_name(posList.get(j).getName());
				}
			}
		}
		
		return list;
	}
	
}
