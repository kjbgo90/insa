package com.insa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insa.vo.CommonVo;
import com.insa.vo.FileVo;
import com.insa.vo.InsaVo;

@Repository
public class InputDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<CommonVo> getCommonList(String gubun) {
		
		return sqlSession.selectList("input.selectCommonListByGubun", gubun);
	}

	public int insertFileByFileVo(FileVo fileVo) {
		return sqlSession.insert("input.insertFileByFileVo", fileVo);
	}

	public int selectCntInsa() {
		return sqlSession.selectOne("input.selectCntInsa");
	}

	public int selectMaxSabun() {
		return sqlSession.selectOne("input.selectMaxSabun");
	}

	public int updateFile(int sabun, String saveName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sabun", sabun);
		map.put("saveName", saveName);
		
		return sqlSession.update("input.updateFileBySabunAndOrgName", map);
	}

	public int insertInsaByInsaVo(InsaVo vo) {
		return sqlSession.insert("input.insertInsaByInsaVo", vo);
	}

}
