package com.competition.db.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpValidator {
	
	public static boolean isEmail(String str){
		String regex="[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-Z0-9]-*{1,}\\.){1,3}[a-zA-Z\\-]{1,})";
		return match(regex,str);
	}

	private static boolean match(String regex, String str) {
		// TODO Auto-generated method stub
			Pattern pattern = Pattern.compile(regex);
		Matcher matcher =pattern.matcher(str);
		return matcher.matches();
	}
}
