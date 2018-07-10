package com.chinapnr.mg.sms.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:dev/config.properties")
@Component
public class SmsProperties {
	

	private String SMS_URL;
	private String SMS_USERID;
	private String SMS_USERNAME;
	private String SMS_PASSWORD;
	public String getSMS_URL() {
		return SMS_URL;
	}
	public void setSMS_URL(String sMS_URL) {
		SMS_URL = sMS_URL;
	}
	public String getSMS_USERID() {
		return SMS_USERID;
	}
	public void setSMS_USERID(String sMS_USERID) {
		SMS_USERID = sMS_USERID;
	}
	public String getSMS_USERNAME() {
		return SMS_USERNAME;
	}
	public void setSMS_USERNAME(String sMS_USERNAME) {
		SMS_USERNAME = sMS_USERNAME;
	}
	public String getSMS_PASSWORD() {
		return SMS_PASSWORD;
	}
	public void setSMS_PASSWORD(String sMS_PASSWORD) {
		SMS_PASSWORD = sMS_PASSWORD;
	}
	@Override
	public String toString() {
		return "SmsProperties [SMS_URL=" + SMS_URL + ", SMS_USERID=" + SMS_USERID
				+ ", SMS_USERNAME=" + SMS_USERNAME + ", SMS_PASSWORD="
				+ SMS_PASSWORD + "]";
	}
	
}
