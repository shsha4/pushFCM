package com.push.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.dao.PushDAO;
import com.push.model.FcmDTO;

@Service
public class pushServiceImpl implements PushService{

	@Autowired
	private PushDAO pushDao;

	@Override
	public int pushInsert(FcmDTO fcm) {
		return pushDao.pushInsert(fcm);
	}

	@Override
	public List<String> pushList() {
		return pushDao.pushList();
	}

}
