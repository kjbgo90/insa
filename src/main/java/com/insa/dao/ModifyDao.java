package com.insa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insa.vo.FileVo;
import com.insa.vo.InputInfoVo;
import com.insa.vo.InsaVo;

@Repository
public class ModifyDao {

	@Autowired
	private SqlSession sqlSession;
	
	public InsaVo selectInsaVoBySabun(int sabun) {
		return sqlSession.selectOne("modify.selectInsaVoBySabun", sabun);
	}

	public FileVo selectFileVoBySaveName(String saveName) {
		return sqlSession.selectOne("modify.selectFileVoBySaveName", saveName);
	}

	public int deleteFileBySaveName(String saveName) {
		return sqlSession.delete("modify.deleteFileBySaveName", saveName);
	}

	public int updateInsaByInsaVo(InsaVo vo) {
		return sqlSession.update("modify.updateInsaByInsaVo", vo);
	}

	public List<InputInfoVo> selectInputInfoBySabun(int sabun) {
		return sqlSession.selectList("modify.selectInputInfoBySabun", sabun);
	}
}
