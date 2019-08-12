package com.insa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insa.dao.ModifyDao;
import com.insa.vo.FileVo;
import com.insa.vo.InputInfoVo;
import com.insa.vo.InsaVo;

@Service
public class ModifyService {
	
	@Autowired
	private ModifyDao modifyDao;
	
	public InsaVo getInsaVoBySabun(int sabun) {
		return modifyDao.selectInsaVoBySabun(sabun);
	}

	public FileVo getFileVoBySaveName(String saveName) {
		return modifyDao.selectFileVoBySaveName(saveName);
	}

	public int deleteFile(String saveName) {
		return modifyDao.deleteFileBySaveName(saveName);
	}

	public int modifyInsaByInsaVo(InsaVo vo) {
		return modifyDao.updateInsaByInsaVo(vo);
	}

	public List<InputInfoVo> getInputInfo(int sabun) {
		return modifyDao.selectInputInfoBySabun(sabun);
	}
}
