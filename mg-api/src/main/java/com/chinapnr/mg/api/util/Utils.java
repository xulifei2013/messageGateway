package com.chinapnr.mg.api.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Utils {
	
	public static Long calabackThreadSleepmills=3000L;
	
	public static Long threadSleepmills=2000L;
	
	public static Integer threadSleepTimes=6;
	
	public static Integer RCCL_PAGE_SIZE=6;
	
	public static Map<String,String> bankNameToId=new HashMap<String,String>();

	public static Map<String,String> cashTypeEn=new HashMap<String,String>();
	
	public static Map<String,String> provNameToId=new HashMap<String,String>();
	public static Map<String,String> areaNameToId=new HashMap<String,String>();
	
	public static Map<String,String> checkPara=new HashMap<String,String>();
	
	private static final String PARA_VALUE_TRANSFER = "custId+transAmt+certType+certId+custName+cardId+bankId+mobilePhone";
	
	static{	
		
		checkPara.put("transfer", PARA_VALUE_TRANSFER);
		
		bankNameToId.put("中国工商银行", "01020000");
		bankNameToId.put("中国农业银行", "01030000");
		bankNameToId.put("中国银行", "01040000");
		bankNameToId.put("中国交通银行", "03010000");
		bankNameToId.put("中信银行", "03020000");
		bankNameToId.put("光大银行", "03030000");
		bankNameToId.put("民生银行", "03050000");
		bankNameToId.put("广发银行", "03060000");
		bankNameToId.put("招商银行", "03080000");
		bankNameToId.put("兴业银行", "03090000");
		bankNameToId.put("上海浦东发展银行", "03100000");
		bankNameToId.put("平安银行", "03134402");
		bankNameToId.put("富滇银行", "03135301");
		bankNameToId.put("上海农村商业银行", "04020031");
		bankNameToId.put("中国邮政储蓄银行", "04030000");
		bankNameToId.put("深圳发展银行", "03070000");
		bankNameToId.put("北京农商行", "04020011");
		bankNameToId.put("中国建设银行", "01050000");
		bankNameToId.put("交通银行", "03010000");
		bankNameToId.put("中国光大银行", "03030000");
		bankNameToId.put("华夏银行", "03040000");
		bankNameToId.put("上海银行", "03130031");
		bankNameToId.put("中国民生银行", "03050000");
		bankNameToId.put("浦东发展银行", "03100000");
		bankNameToId.put("北京银行", "03130011");
		bankNameToId.put("渤海银行", "03180000");
		bankNameToId.put("浙商银行", "03160000");
		bankNameToId.put("杭州银行", "03133301");
		bankNameToId.put("南京银行", "03133201");
		bankNameToId.put("北京农村商业银行", "04020011");
		bankNameToId.put("浙江民泰商业银行", "03133307");
		bankNameToId.put("浙江泰隆商业银行", "31330000");
		bankNameToId.put("恒丰银行", "03150000");
		cashTypeEn.put("T0", "02030000");
		cashTypeEn.put("T1", "02030010");
		provNameToId.put("北京", "0011");
		provNameToId.put("天津", "0012");
		provNameToId.put("河北", "0013");
		provNameToId.put("河北", "0013");
		provNameToId.put("河北", "0013");
		provNameToId.put("河北", "0013");
		provNameToId.put("河北", "0013");
		provNameToId.put("河北", "0013");
		provNameToId.put("河北", "0013");
		provNameToId.put("河北", "0013");
		provNameToId.put("河北", "0013");
		provNameToId.put("河北", "0013");
		provNameToId.put("河北", "0013");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("山西", "0014");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("内蒙古", "0015");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("辽宁", "0021");
		provNameToId.put("吉林", "0022");
		provNameToId.put("吉林", "0022");
		provNameToId.put("吉林", "0022");
		provNameToId.put("吉林", "0022");
		provNameToId.put("吉林", "0022");
		provNameToId.put("吉林", "0022");
		provNameToId.put("吉林", "0022");
		provNameToId.put("吉林", "0022");
		provNameToId.put("吉林", "0022");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("湖南", "0043");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广东", "0044");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("广西", "0045");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("黑龙江", "0023");
		provNameToId.put("上海", "0031");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("江苏", "0032");
		provNameToId.put("浙江", "0033");
		provNameToId.put("浙江", "0033");
		provNameToId.put("浙江", "0033");
		provNameToId.put("浙江", "0033");
		provNameToId.put("浙江", "0033");
		provNameToId.put("浙江", "0033");
		provNameToId.put("浙江", "0033");
		provNameToId.put("浙江", "0033");
		provNameToId.put("浙江", "0033");
		provNameToId.put("浙江", "0033");
		provNameToId.put("浙江", "0033");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("安徽", "0034");
		provNameToId.put("福建", "0035");
		provNameToId.put("福建", "0035");
		provNameToId.put("福建", "0035");
		provNameToId.put("福建", "0035");
		provNameToId.put("福建", "0035");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("海南", "0046");
		provNameToId.put("重庆", "0050");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("四川", "0051");
		provNameToId.put("贵州", "0052");
		provNameToId.put("贵州", "0052");
		provNameToId.put("贵州", "0052");
		provNameToId.put("贵州", "0052");
		provNameToId.put("贵州", "0052");
		provNameToId.put("贵州", "0052");
		provNameToId.put("贵州", "0052");
		provNameToId.put("贵州", "0052");
		provNameToId.put("贵州", "0052");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("云南", "0053");
		provNameToId.put("西藏", "0054");
		provNameToId.put("福建", "0035");
		provNameToId.put("福建", "0035");
		provNameToId.put("福建", "0035");
		provNameToId.put("福建", "0035");
		provNameToId.put("江西", "0036");
		provNameToId.put("江西", "0036");
		provNameToId.put("江西", "0036");
		provNameToId.put("江西", "0036");
		provNameToId.put("江西", "0036");
		provNameToId.put("江西", "0036");
		provNameToId.put("江西", "0036");
		provNameToId.put("江西", "0036");
		provNameToId.put("江西", "0036");
		provNameToId.put("江西", "0036");
		provNameToId.put("江西", "0036");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("山东", "0037");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("河南", "0041");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("湖北", "0042");
		provNameToId.put("西藏", "0054");
		provNameToId.put("西藏", "0054");
		provNameToId.put("西藏", "0054");
		provNameToId.put("西藏", "0054");
		provNameToId.put("西藏", "0054");
		provNameToId.put("西藏", "0054");
		provNameToId.put("陕西", "0061");
		provNameToId.put("陕西", "0061");
		provNameToId.put("陕西", "0061");
		provNameToId.put("陕西", "0061");
		provNameToId.put("陕西", "0061");
		provNameToId.put("陕西", "0061");
		provNameToId.put("陕西", "0061");
		provNameToId.put("陕西", "0061");
		provNameToId.put("陕西", "0061");
		provNameToId.put("陕西", "0061");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("甘肃", "0062");
		provNameToId.put("青海", "0063");
		provNameToId.put("青海", "0063");
		provNameToId.put("宁夏", "0064");
		provNameToId.put("宁夏", "0064");
		provNameToId.put("宁夏", "0064");
		provNameToId.put("宁夏", "0064");
		provNameToId.put("宁夏", "0064");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("新疆", "0065");
		provNameToId.put("香港", "2001");
		provNameToId.put("澳门", "2002");
		areaNameToId.put("北京", "1100");
		areaNameToId.put("天津", "1200");
		areaNameToId.put("石家庄", "1301");
		areaNameToId.put("保定", "1302");
		areaNameToId.put("沧州", "1303");
		areaNameToId.put("承德", "1304");
		areaNameToId.put("邯郸", "1305");
		areaNameToId.put("衡水", "1306");
		areaNameToId.put("廊坊", "1307");
		areaNameToId.put("秦皇岛", "1308");
		areaNameToId.put("唐山", "1309");
		areaNameToId.put("邢台", "1310");
		areaNameToId.put("张家口", "1311");
		areaNameToId.put("太原", "1401");
		areaNameToId.put("长治", "1402");
		areaNameToId.put("大同", "1403");
		areaNameToId.put("晋城", "1404");
		areaNameToId.put("离石", "1405");
		areaNameToId.put("临汾", "1406");
		areaNameToId.put("朔州", "1407");
		areaNameToId.put("忻州", "1408");
		areaNameToId.put("阳泉", "1409");
		areaNameToId.put("榆次", "1410");
		areaNameToId.put("运城", "1411");
		areaNameToId.put("晋中", "1412");
		areaNameToId.put("吕梁", "1413");
		areaNameToId.put("呼和浩特", "1501");
		areaNameToId.put("包头", "1502");
		areaNameToId.put("阿拉善", "1503");
		areaNameToId.put("巴彦淖尔", "1504");
		areaNameToId.put("赤峰", "1505");
		areaNameToId.put("呼伦贝尔", "1506");
		areaNameToId.put("乌海", "1507");
		areaNameToId.put("乌兰察布", "1508");
		areaNameToId.put("锡林郭勒", "1509");
		areaNameToId.put("兴安", "1510");
		areaNameToId.put("鄂尔多斯", "1511");
		areaNameToId.put("通辽", "1512");
		areaNameToId.put("沈阳", "2101");
		areaNameToId.put("大连", "2102");
		areaNameToId.put("鞍山", "2103");
		areaNameToId.put("本溪", "2104");
		areaNameToId.put("朝阳", "2105");
		areaNameToId.put("丹东", "2106");
		areaNameToId.put("抚顺", "2107");
		areaNameToId.put("阜新", "2108");
		areaNameToId.put("葫芦岛", "2109");
		areaNameToId.put("锦州", "2110");
		areaNameToId.put("辽阳", "2111");
		areaNameToId.put("盘锦", "2112");
		areaNameToId.put("铁岭", "2113");
		areaNameToId.put("营口", "2114");
		areaNameToId.put("长春", "2201");
		areaNameToId.put("白城", "2202");
		areaNameToId.put("白山", "2203");
		areaNameToId.put("吉林", "2204");
		areaNameToId.put("辽源", "2205");
		areaNameToId.put("四平", "2206");
		areaNameToId.put("松原", "2207");
		areaNameToId.put("通化", "2208");
		areaNameToId.put("延边", "2209");
		areaNameToId.put("孝感", "4212");
		areaNameToId.put("神农架", "4213");
		areaNameToId.put("天门", "4214");
		areaNameToId.put("宜昌", "4215");
		areaNameToId.put("三峡", "4216");
		areaNameToId.put("长沙", "4301");
		areaNameToId.put("常德", "4302");
		areaNameToId.put("郴州", "4303");
		areaNameToId.put("衡阳", "4304");
		areaNameToId.put("怀化", "4305");
		areaNameToId.put("娄底", "4306");
		areaNameToId.put("邵阳", "4307");
		areaNameToId.put("湘潭", "4308");
		areaNameToId.put("湘西", "4309");
		areaNameToId.put("益阳", "4310");
		areaNameToId.put("永州", "4311");
		areaNameToId.put("岳阳", "4312");
		areaNameToId.put("张家界", "4313");
		areaNameToId.put("株洲", "4314");
		areaNameToId.put("广州", "4401");
		areaNameToId.put("深圳", "4402");
		areaNameToId.put("潮州", "4403");
		areaNameToId.put("东莞", "4404");
		areaNameToId.put("佛山", "4405");
		areaNameToId.put("惠州", "4406");
		areaNameToId.put("江门", "4407");
		areaNameToId.put("揭阳", "4408");
		areaNameToId.put("茂名", "4409");
		areaNameToId.put("梅州", "4410");
		areaNameToId.put("清远", "4411");
		areaNameToId.put("汕头", "4412");
		areaNameToId.put("汕尾", "4413");
		areaNameToId.put("韶关", "4414");
		areaNameToId.put("阳江", "4415");
		areaNameToId.put("云浮", "4416");
		areaNameToId.put("湛江", "4417");
		areaNameToId.put("肇庆", "4418");
		areaNameToId.put("中山", "4419");
		areaNameToId.put("河源", "4420");
		areaNameToId.put("珠海", "4421");
		areaNameToId.put("南宁", "4501");
		areaNameToId.put("百色", "4502");
		areaNameToId.put("北海", "4503");
		areaNameToId.put("桂林", "4504");
		areaNameToId.put("河池", "4505");
		areaNameToId.put("柳州", "4506");
		areaNameToId.put("梧州", "4507");
		areaNameToId.put("玉林", "4508");
		areaNameToId.put("崇左", "4509");
		areaNameToId.put("防城港", "4510");
		areaNameToId.put("贵港", "4511");
		areaNameToId.put("贺州", "4512");
		areaNameToId.put("来宾", "4513");
		areaNameToId.put("钦州", "4514");
		areaNameToId.put("海口", "4601");
		areaNameToId.put("三亚", "4602");
		areaNameToId.put("白沙", "4603");
		areaNameToId.put("保亭", "4604");
		areaNameToId.put("昌江", "4605");
		areaNameToId.put("澄迈", "4606");
		areaNameToId.put("儋州", "4607");
		areaNameToId.put("哈尔滨", "2301");
		areaNameToId.put("大庆", "2302");
		areaNameToId.put("大兴安岭", "2303");
		areaNameToId.put("鹤岗", "2304");
		areaNameToId.put("黑河", "2305");
		areaNameToId.put("鸡西", "2306");
		areaNameToId.put("佳木斯", "2307");
		areaNameToId.put("牡丹江", "2308");
		areaNameToId.put("七台河", "2309");
		areaNameToId.put("齐齐哈尔", "2310");
		areaNameToId.put("双鸭山", "2311");
		areaNameToId.put("绥化", "2312");
		areaNameToId.put("伊春", "2313");
		areaNameToId.put("上海", "3100");
		areaNameToId.put("南京", "3201");
		areaNameToId.put("常州", "3202");
		areaNameToId.put("淮安", "3203");
		areaNameToId.put("连云港", "3204");
		areaNameToId.put("南通", "3205");
		areaNameToId.put("苏州", "3206");
		areaNameToId.put("宿迁", "3207");
		areaNameToId.put("泰州", "3208");
		areaNameToId.put("无锡", "3209");
		areaNameToId.put("徐州", "3210");
		areaNameToId.put("盐城", "3211");
		areaNameToId.put("扬州", "3212");
		areaNameToId.put("镇江", "3213");
		areaNameToId.put("胥浦", "3214");
		areaNameToId.put("杭州", "3301");
		areaNameToId.put("宁波", "3302");
		areaNameToId.put("湖州", "3303");
		areaNameToId.put("嘉兴", "3304");
		areaNameToId.put("金华", "3305");
		areaNameToId.put("绍兴", "3306");
		areaNameToId.put("台州", "3307");
		areaNameToId.put("温州", "3308");
		areaNameToId.put("舟山", "3309");
		areaNameToId.put("衢州", "3310");
		areaNameToId.put("丽水", "3311");
		areaNameToId.put("合肥", "3401");
		areaNameToId.put("安庆", "3402");
		areaNameToId.put("蚌埠", "3403");
		areaNameToId.put("巢湖", "3404");
		areaNameToId.put("池州", "3405");
		areaNameToId.put("滁州", "3406");
		areaNameToId.put("阜阳", "3407");
		areaNameToId.put("淮北", "3408");
		areaNameToId.put("淮南", "3409");
		areaNameToId.put("黄山", "3410");
		areaNameToId.put("六安", "3411");
		areaNameToId.put("马鞍山", "3412");
		areaNameToId.put("铜陵", "3414");
		areaNameToId.put("芜湖", "3415");
		areaNameToId.put("宣城", "3416");
		areaNameToId.put("亳州", "3417");
		areaNameToId.put("宿州", "3418");
		areaNameToId.put("福州", "3501");
		areaNameToId.put("厦门", "3502");
		areaNameToId.put("龙岩", "3503");
		areaNameToId.put("南平", "3504");
		areaNameToId.put("宁德", "3505");
		areaNameToId.put("定安", "4608");
		areaNameToId.put("东方", "4609");
		areaNameToId.put("乐东", "4610");
		areaNameToId.put("临高", "4611");
		areaNameToId.put("陵水", "4612");
		areaNameToId.put("琼海", "4613");
		areaNameToId.put("琼中", "4614");
		areaNameToId.put("屯昌", "4615");
		areaNameToId.put("万宁", "4616");
		areaNameToId.put("文昌", "4617");
		areaNameToId.put("五指山", "4618");
		areaNameToId.put("洋浦", "4619");
		areaNameToId.put("重庆", "5000");
		areaNameToId.put("成都", "5101");
		areaNameToId.put("巴中", "5102");
		areaNameToId.put("达州", "5103");
		areaNameToId.put("德阳", "5104");
		areaNameToId.put("广安", "5105");
		areaNameToId.put("广元", "5106");
		areaNameToId.put("乐山", "5107");
		areaNameToId.put("凉山", "5108");
		areaNameToId.put("眉山", "5109");
		areaNameToId.put("绵阳", "5110");
		areaNameToId.put("南充", "5111");
		areaNameToId.put("内江", "5112");
		areaNameToId.put("攀枝花", "5113");
		areaNameToId.put("遂宁", "5114");
		areaNameToId.put("雅安", "5115");
		areaNameToId.put("宜宾", "5116");
		areaNameToId.put("自贡", "5117");
		areaNameToId.put("泸州", "5118");
		areaNameToId.put("阿坝", "5119");
		areaNameToId.put("甘孜", "5120");
		areaNameToId.put("资阳", "5121");
		areaNameToId.put("贵阳", "5201");
		areaNameToId.put("安顺", "5202");
		areaNameToId.put("毕节", "5203");
		areaNameToId.put("六盘水", "5204");
		areaNameToId.put("铜仁", "5205");
		areaNameToId.put("遵义", "5206");
		areaNameToId.put("黔东南", "5207");
		areaNameToId.put("黔南", "5208");
		areaNameToId.put("黔西南", "5209");
		areaNameToId.put("昆明", "5301");
		areaNameToId.put("西双版纳", "5302");
		areaNameToId.put("保山", "5303");
		areaNameToId.put("楚雄", "5304");
		areaNameToId.put("大理", "5305");
		areaNameToId.put("德宏", "5306");
		areaNameToId.put("红河", "5307");
		areaNameToId.put("丽江", "5308");
		areaNameToId.put("临沧", "5309");
		areaNameToId.put("怒江", "5310");
		areaNameToId.put("曲靖", "5311");
		areaNameToId.put("思茅", "5312");
		areaNameToId.put("文山", "5313");
		areaNameToId.put("玉溪", "5314");
		areaNameToId.put("昭通", "5315");
		areaNameToId.put("中甸", "5316");
		areaNameToId.put("迪庆州", "5317");
		areaNameToId.put("拉萨", "5401");
		areaNameToId.put("莆田", "3506");
		areaNameToId.put("泉州", "3507");
		areaNameToId.put("三明", "3508");
		areaNameToId.put("漳州", "3509");
		areaNameToId.put("南昌", "3601");
		areaNameToId.put("抚州", "3602");
		areaNameToId.put("赣州", "3603");
		areaNameToId.put("吉安", "3604");
		areaNameToId.put("景德镇", "3605");
		areaNameToId.put("九江", "3606");
		areaNameToId.put("萍乡", "3607");
		areaNameToId.put("上饶", "3608");
		areaNameToId.put("新余", "3609");
		areaNameToId.put("宜春", "3610");
		areaNameToId.put("鹰潭", "3611");
		areaNameToId.put("济南", "3701");
		areaNameToId.put("青岛", "3702");
		areaNameToId.put("滨州", "3703");
		areaNameToId.put("德州", "3704");
		areaNameToId.put("东营", "3705");
		areaNameToId.put("菏泽", "3706");
		areaNameToId.put("济宁", "3707");
		areaNameToId.put("莱芜", "3708");
		areaNameToId.put("聊城", "3709");
		areaNameToId.put("临沂", "3710");
		areaNameToId.put("日照", "3711");
		areaNameToId.put("泰安", "3712");
		areaNameToId.put("威海", "3713");
		areaNameToId.put("潍坊", "3714");
		areaNameToId.put("烟台", "3715");
		areaNameToId.put("枣庄", "3716");
		areaNameToId.put("淄博", "3717");
		areaNameToId.put("郑州", "4101");
		areaNameToId.put("安阳", "4102");
		areaNameToId.put("焦作", "4103");
		areaNameToId.put("鹤壁", "4104");
		areaNameToId.put("开封", "4105");
		areaNameToId.put("洛阳", "4106");
		areaNameToId.put("南阳", "4107");
		areaNameToId.put("平顶山", "4108");
		areaNameToId.put("三门峡", "4109");
		areaNameToId.put("商丘", "4110");
		areaNameToId.put("新乡", "4111");
		areaNameToId.put("信阳", "4112");
		areaNameToId.put("许昌", "4113");
		areaNameToId.put("周口", "4114");
		areaNameToId.put("驻马店", "4115");
		areaNameToId.put("漯河", "4116");
		areaNameToId.put("濮阳", "4117");
		areaNameToId.put("济源", "4118");
		areaNameToId.put("武汉", "4201");
		areaNameToId.put("鄂州", "4202");
		areaNameToId.put("恩施", "4203");
		areaNameToId.put("黄冈", "4204");
		areaNameToId.put("黄石", "4205");
		areaNameToId.put("荆门", "4206");
		areaNameToId.put("荆州", "4207");
		areaNameToId.put("十堰", "4208");
		areaNameToId.put("随州", "4209");
		areaNameToId.put("咸宁", "4210");
		areaNameToId.put("襄樊", "4211");
		areaNameToId.put("阿里", "5402");
		areaNameToId.put("昌都", "5403");
		areaNameToId.put("林芝", "5404");
		areaNameToId.put("那曲", "5405");
		areaNameToId.put("日喀则", "5406");
		areaNameToId.put("山南", "5407");
		areaNameToId.put("西安", "6101");
		areaNameToId.put("安康", "6102");
		areaNameToId.put("宝鸡", "6103");
		areaNameToId.put("汉中", "6104");
		areaNameToId.put("商洛", "6105");
		areaNameToId.put("铜川", "6106");
		areaNameToId.put("渭南", "6107");
		areaNameToId.put("咸阳", "6108");
		areaNameToId.put("延安", "6109");
		areaNameToId.put("榆林", "6110");
		areaNameToId.put("兰州", "6201");
		areaNameToId.put("白银", "6202");
		areaNameToId.put("定西", "6203");
		areaNameToId.put("东风", "6204");
		areaNameToId.put("合作", "6205");
		areaNameToId.put("嘉峪关", "6206");
		areaNameToId.put("金昌", "6207");
		areaNameToId.put("酒泉", "6208");
		areaNameToId.put("矿区", "6209");
		areaNameToId.put("临夏", "6210");
		areaNameToId.put("陇南", "6211");
		areaNameToId.put("平凉", "6212");
		areaNameToId.put("庆阳", "6213");
		areaNameToId.put("天水", "6214");
		areaNameToId.put("武威", "6215");
		areaNameToId.put("张掖", "6216");
		areaNameToId.put("甘南州", "6217");
		areaNameToId.put("西宁", "6301");
		areaNameToId.put("海东", "6302");
		areaNameToId.put("银川", "6401");
		areaNameToId.put("中卫", "6402");
		areaNameToId.put("固原", "6403");
		areaNameToId.put("石嘴山", "6404");
		areaNameToId.put("吴忠", "6405");
		areaNameToId.put("乌鲁木齐", "6501");
		areaNameToId.put("阿克苏", "6502");
		areaNameToId.put("阿勒泰", "6503");
		areaNameToId.put("巴州", "6504");
		areaNameToId.put("博州", "6505");
		areaNameToId.put("昌吉", "6506");
		areaNameToId.put("哈密", "6507");
		areaNameToId.put("和田", "6508");
		areaNameToId.put("喀什", "6509");
		areaNameToId.put("克拉玛依", "6510");
		areaNameToId.put("马兰", "6511");
		areaNameToId.put("石河子", "6512");
		areaNameToId.put("塔城", "6513");
		areaNameToId.put("吐鲁番", "6514");
		areaNameToId.put("伊犁", "6515");
		areaNameToId.put("克州", "6516");
		areaNameToId.put("阿拉尔", "6517");
		areaNameToId.put("五家渠", "6518");
		areaNameToId.put("香港", "9901");
		areaNameToId.put("澳门", "9902");
		areaNameToId.put("台湾", "9903");
	}

	public static String getTodayStr(){
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	public static boolean isNullOrBlack(Object obj){
		if(obj == null || "".equals(obj)){
			return true;
		}else if("".equals(obj.toString().trim())){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNullOrBlack(String obj){
		if(obj == null || "".equals(obj)){
			return true;
		}else if("".equals(obj.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	public static String getOrderId(){
		return ""+System.currentTimeMillis()+(int)((Math.random()*9+1)*100000);
	}
	
	public static String getObjToStr(String obj){
		return obj==null?"":obj;
		
	}
	
	public static String getObjToStr(Object obj){
		return obj==null?"":obj.toString();
	}
	
	public static String getIntToStr(Object obj){
		return obj==null?"0":String.valueOf(obj);
	}
	
	public static String getObjToStr(Object obj,String def){
		return obj==null?(def==null?"":def):obj.toString();
	}
	
	public static BigDecimal getStrToNum(Object obj){
		if(isNullOrBlack(obj)){
			return BigDecimal.ZERO;
		}else{
			return new BigDecimal(obj.toString());
		}
	}

	public static String getNumToStr(BigDecimal transAmt) {
		return transAmt==null?"0":transAmt.toString();
	}
	
	public static String checkParaNotNull(Map<String, String> paraMap,String paramStr) {
		if(paramStr==null||paraMap==null||paraMap.isEmpty()){
			return null;
		}
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("rspCode", "010");
		result.put("rspCodeDesc", "is null or black");
		StringBuilder sb=new StringBuilder();
    	String [] arr_str=paramStr.split("\\+");
    	for(int i=0;i<arr_str.length;i++){
    		if(paraMap.containsKey(arr_str[i])){
    			if(isNullOrBlack(paraMap.get(arr_str[i]))){
    				sb.append(arr_str[i]+"|");
    			}
    		}    		
    	}
    	if(sb.length()!=0){
    		result.put("rspCodeDesc",sb.toString()+" is null or black");
    		return JsonProcessUtil.beanToJson(result);
    	}
		return null;
	}
	
	// 金额验证
	public static boolean isNumber(String str) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
		java.util.regex.Matcher match = pattern.matcher(str);
		if (match.matches() == false) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 金额格式
	 * @param amt
	 * @return
	 */
    public static String amtFormat(String amt) {
        if (amt == null||"".equals(amt)) {
            return "0.00";
        }
        return new DecimalFormat("0.00").format(new Double(amt));
    }
	
//	public static void main(String[] args){
//		System.out.println(" amtFormat:"+amtFormat("0a"));
//	}

}
