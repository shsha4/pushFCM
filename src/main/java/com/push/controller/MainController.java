package com.push.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.push.model.FcmDTO;
import com.push.service.PushService;
import com.push.util.FcmUtil;

@Controller
public class MainController {
	
	@Autowired
	private PushService service;
	
	@RequestMapping(value = "/inputPush", method = RequestMethod.POST)
	public @ResponseBody String inputPush(FcmDTO fcm) {
		
		System.out.println(fcm.toString());
		
		int update = service.pushInsert(fcm);
		System.out.println("update 확인 : " + (update == 1? "성공" : "실패"));
		
		JsonObject result = new JsonObject();
		Gson gson = new Gson();
		if(update == 1){
			result.addProperty("result", "success");
			return gson.toJson(result);
		}else{
			result.addProperty("result", "failed");
			return gson.toJson(result);
		}
	}
	
	@Scheduled(cron="0 0/1 * * * ?")
	public void pushFcm(){
		System.out.println("Cron 실행");
		String title = "귀가 시간 알림";
		String content = "안심 불빛과 함께 안전 귀가 하세요";
		
		List<String> fcmList = service.pushList();
		
		for(int i = 0; i < fcmList.size(); i++){
			if(!fcmList.get(i).equals("null")){
				FcmUtil fcm = new FcmUtil();
				fcm.send_FCM(fcmList.get(i), title, content);
			}
		}
	}
}
