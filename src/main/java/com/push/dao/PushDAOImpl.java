package com.push.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.push.model.FcmDTO;

@Repository
public class PushDAOImpl implements PushDAO{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int pushInsert(FcmDTO fcm) {
		try {
			return sqlSession.update("pushInsert", fcm);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<String> pushList() {
		List<String> list = new ArrayList<>();
		try {
			return list = sqlSession.selectList("pushList");
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
	}
	
	
}
