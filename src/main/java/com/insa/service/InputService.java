package com.insa.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.insa.dao.InputDao;
import com.insa.vo.CommonVo;
import com.insa.vo.FileVo;
import com.insa.vo.InsaVo;

@Service
public class InputService {

	@Autowired
	private InputDao inputDao;
	
	public List<CommonVo> getEmailList() {
		String gubun = "email";
		
		return inputDao.getCommonList(gubun);
	}
	
	public List<CommonVo> getJobList() {
		String gubun = "직종";
		
		return inputDao.getCommonList(gubun);
	}
	public List<CommonVo> getSexList() {
		String gubun = "성별";
		
		return inputDao.getCommonList(gubun);
	}
	public List<CommonVo> getPosList() {
		String gubun = "직위";
		
		return inputDao.getCommonList(gubun);
	}
	public List<CommonVo> getDeptList() {
		String gubun = "부서";
		
		return inputDao.getCommonList(gubun);
	}
	public List<CommonVo> getJoinList() {
		String gubun = "입사구분";
		
		return inputDao.getCommonList(gubun);
	}
	public List<CommonVo> getGartList() {
		String gubun = "등급";
		
		return inputDao.getCommonList(gubun);
	}
	public List<CommonVo> getMtypeList() {
		String gubun = "군별";
		
		return inputDao.getCommonList(gubun);
	}
	public List<CommonVo> getMlevelList() {
		String gubun = "계급";
		
		return inputDao.getCommonList(gubun);
	}
	public List<CommonVo> getKclassList() {
		String gubun = "KOSA등급";
		
		return inputDao.getCommonList(gubun);
	}
	
	public FileVo uploadFile(MultipartFile file, String fileType) {
		
		String saveDir = "c:\\Users\\pino\\Desktop\\upload";
		String orgName = file.getOriginalFilename();
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		String filePath = saveDir + "\\" + saveName;
		long fileSize = file.getSize();
		
		FileVo fileVo = new FileVo();
		fileVo.setFileType(fileType);
		fileVo.setFilePath(filePath);
		fileVo.setOrgName(orgName);
		fileVo.setSaveName(saveName);
		fileVo.setFileSize(fileSize);
		
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(saveDir + "/" + saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);

			bout.write(fileData);

			if (bout != null) {
				bout.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int result = inputDao.insertFileByFileVo(fileVo); 
		if (result == 1){
			return fileVo;
		}
		else {
			System.out.println("파일 업로드 실패");
			return null;
		}
	}

	public int updateFile(int sabun, String saveName) {
		return inputDao.updateFile(sabun, saveName);
	}

	@Transactional
	public int registInsa(InsaVo vo) {
		int cntInsa = inputDao.selectCntInsa();
		int sabun;
		
		if(cntInsa == 0)
			sabun = 1;
		
		else {
			sabun = inputDao.selectMaxSabun() + 1;
		}
		vo.setSabun(sabun);
		
		return inputDao.insertInsaByInsaVo(vo);
	}

}
