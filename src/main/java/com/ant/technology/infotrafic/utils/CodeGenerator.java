package com.ant.technology.infotrafic.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class CodeGenerator {

	public static String generatedCode() {
		String generatedString = RandomStringUtils.randomNumeric(4);

		return generatedString;
	}

}
