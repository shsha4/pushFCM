package com.push.util;

import java.io.FileInputStream;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;

@Component
public class FcmUtil {
	public void send_FCM(String tokenId, String title, String content){
		try {
			//Firebase 초기 세팅
			//Firebase Json 키 값 불러오기
			FileInputStream refreshToken = new FileInputStream("/usr/local/tomcat8/webapps/push/resources/fcm/ansimpush-firebase-adminsdk-n80ua-a0a795cf0e.json");
			
			//options 설정
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(refreshToken))
					.setDatabaseUrl("https://ansimpush.firebaseio.com")
					.build();

			//Firebase 처음 호출시에만 initializing 처리
			if(FirebaseApp.getApps().isEmpty()){
				FirebaseApp.initializeApp(options);
			}
			
			//안드로이드 디바이스 토큰 값 넣기
			String registrationToken = tokenId;
			
			//message 작성
			Message msg = Message.builder()
					.setAndroidConfig(AndroidConfig.builder()
							.setTtl(3600 * 1000)
							.setPriority(AndroidConfig.Priority.NORMAL)
							.setNotification(AndroidNotification.builder()
									.setTitle(title)
									.setBody(content)
									.setIcon("stock_ticker_update")
									.setColor("#f45342")
									.build())
							.build())
					.setToken(registrationToken)
					.build();
			
			//message FirebaseMessaging에 보내기
			String response = FirebaseMessaging.getInstance().send(msg);
			
			//결과 출력
			System.out.println("Successfully send message : " + response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
