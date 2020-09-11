package com.push.service;

import java.util.List;

import com.push.model.FcmDTO;

public interface PushService {
	public int pushInsert(FcmDTO fcm);
	public List<String> pushList();
}
