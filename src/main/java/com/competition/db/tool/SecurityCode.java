package com.competition.db.tool;



import java.util.Arrays;

public class SecurityCode {
	/**
	 * 验证码难度级别，simple只包含数字，medium包含数字和小写英文，hard包含数字和大小写英文
	 * @author 笨蛋
	 *
	 */
	public enum SecurityCodeLevel{simple,medium,hard};
	/**
	 * 产生验证码，4位中等难度
	 * @return String 验证码
	 */
	public static String getSecurityCode(){
		return getSecurityCode(4,SecurityCodeLevel.medium,false);
	}
	/**
	 * 产生长度和难度任意的验证码
	 * @param length 长度
	 * @param level 难度级别
	 * @param isCanRepeat 是否能够出现重复字符，如果为true，则可能出现5575这样包含3个5，为false则不允许出现	 
	 * @return String验证码
	 */
	public static String getSecurityCode(int length,SecurityCodeLevel level,boolean isCanRepeat){
		int len=length;		//随机抽取len个字符
		
		//字符集合
		char[] codes={'1','2','3','4','5','6','7','8','9',
				                       'a','b','c','d','e','f','g','h','i',
				                       'j','k','m','n','p','q','r','s','t',
				                       'u','v','w','x','y','z','A','B','C',
				                       'D','E','F','G','H','I','J','K','L',
				                       'M','N','P','Q','R','S','T','U','V',
				                       'W','X','Y','Z'};
		//根据不同难度截取字符数组
		if(level==SecurityCodeLevel.simple){
			codes=Arrays.copyOfRange(codes, 0, 9);
		}else if(level==SecurityCodeLevel.medium){
			codes=Arrays.copyOfRange(codes, 0, 33);
		}
		
		//字符集合长度
		int n=codes.length;
		//抛出运行时异常
		if(len>n&&isCanRepeat==false){
			throw new RuntimeException(
						String.format("调用SecurityCode.getSecurityCode(%1$s,%2$s,%3$s)出现异常，当isCanRepeat为%3$s时，传入参数%1$s不能大于%4$s", len,level,isCanRepeat,n)
					);
		}
		
		//存放抽取出来的字符
		char[] result = new char[len];
		
		//判断是否出现重复的字符
		if(!isCanRepeat){
			for(int i=0;i<result.length;i++){
				//索引0andn-1
				int r =(int)(Math.random()*n);
				
				//将result中的第i个元素设置为codes[r]存放的数值
				result[i]=codes[r];
				//必须确保不会再次抽取到相同字符，将最后一个字符放在r为，并将长度减1
				codes[r]=codes[n-1];
			}
			}else{
				for(int i=0;i<result.length;i++){
					//索引0andn-1
					int r =(int)(Math.random()*n);
					
					//将result中的第i个元素设置为codes[r]存放的数值
					result[i]=codes[r];
					//必须确保不会再次抽取到相同字符，将最后一个字符放在r为，并将长度减1
					codes[r]=codes[n-1];
					n--;
				}
			}
		
		return String.valueOf(result);
	}
}
