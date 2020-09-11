package com.push.dao;

import java.util.List;

import com.push.model.FcmDTO;

public interface PushDAO {
	public int pushInsert(FcmDTO fcm);
	public List<String> pushList();
}
