package com.insa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insa.vo.SearchResultVo;
import com.insa.vo.SearchVo;

@Repository
public class SearchDao {
	
	@Autowired
	private SqlSession sqlSession;

	public List<SearchResultVo> selectSearchResultBySearchVo(SearchVo searchVo) {
		return sqlSession.selectList("search.selectSearchResultListBySearchVo", searchVo);
	}
	
}
