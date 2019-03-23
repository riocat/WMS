package com.gt.wms.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gt.wms.util.SettingValue;

@Controller
@RequestMapping("/rescource")
public class ResourceController {

	Logger logger = LoggerFactory.getLogger(ResourceController.class);

	@Autowired
	private SettingValue setting;

	@RequestMapping("/checkImg")
	public void checkImg(HttpServletResponse response, HttpSession session) {
		response.setContentType("iamge/png");
		Random ran = new Random();
		int checkKey = ran.nextInt(9000) + 1000;
		session.setAttribute("ckeckCode", checkKey+"");
		BufferedImage bfi = new BufferedImage(setting.checkImageWidth, setting.checkImageHeight,
				BufferedImage.TYPE_INT_RGB);
		Graphics gra = bfi.getGraphics();
		int Rint = ran.nextInt(256);
		int Gint = ran.nextInt(256);
		int Bint = ran.nextInt(256);
		gra.setColor(new Color(Rint, Gint, Bint));
		gra.fillRect(0, 0, setting.checkImageWidth, setting.checkImageHeight);
		gra.setColor(new Color(Math.abs(255 - Rint), Math.abs(255 - Gint), Math.abs(255 - Bint)));
		gra.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		gra.drawString(new Integer(checkKey).toString(), setting.checkImageWidth / 3, setting.checkImageHeight * 2 / 3);
		try {
			ImageIO.write(bfi, "PNG", response.getOutputStream());
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
