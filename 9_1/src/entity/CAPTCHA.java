package entity;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CAPTCHA {
	private int HEIGHT=60;
	private int WIDTH=180;
	private int HEIGHTs=40;
	private int WIDTHs=40;
	private String string;
	private BufferedImage image;

	public String getString() {
		return string;
	}

	public BufferedImage getImage() {
		return image;
	}

	private String randomStr(){
		String chars = "1234567890";
		return String.valueOf(chars.charAt((int) (Math.random() * chars.length())));
	}

	private BufferedImage getImg(String str){
		BufferedImage bi = new BufferedImage(WIDTHs,HEIGHTs,BufferedImage.TYPE_INT_ARGB);
		Graphics2D canvas = bi.createGraphics();
		canvas.setColor(Color.BLACK);
		canvas.setFont(new Font("Arial", 10, 50));
		canvas.drawString(str, 0, 40);
		return bi;
	}

	public CAPTCHA(){
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		Graphics2D canvas = image.createGraphics();
		AffineTransform at=new AffineTransform();
		StringBuffer stringb = new StringBuffer("01234");
		for(int i=0;i<5;i++){
			at.translate(10+30*i, 10);
			at.rotate((Math.random()-0.5));
			String s=randomStr();
			stringb.setCharAt(i, s.charAt(0));
			canvas.drawImage(getImg(s), at,null);
			at.setToIdentity();
		}
		string=stringb.toString();
	}
}
