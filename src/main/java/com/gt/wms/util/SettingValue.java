package com.gt.wms.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SettingValue {
	
	@Value("${checkImageWidth}")
	public int checkImageWidth;
	
	@Value("${checkImageHeight}")
	public int checkImageHeight;
	
//	@Value("${imageType}")
//	public int imageType;
	
}
