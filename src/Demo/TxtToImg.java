package Demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TxtToImg {

	/*
	 * public static void main(String[] args) {
	 * 
	 * String text = "Deepak Patil";
	 * 
	 * Because font metrics is based on a graphics context, we need to create a
	 * small, temporary image so we can ascertain the width and height of the final
	 * image
	 * 
	 * BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	 * Graphics2D g2d = img.createGraphics(); Font font = new Font("Arial",
	 * Font.PLAIN, 48); g2d.setFont(font); FontMetrics fm = g2d.getFontMetrics();
	 * int width = fm.stringWidth(text); int height = fm.getHeight(); g2d.dispose();
	 * 
	 * img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); g2d =
	 * img.createGraphics();
	 * g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
	 * RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
	 * g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	 * RenderingHints.VALUE_ANTIALIAS_ON);
	 * g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
	 * RenderingHints.VALUE_COLOR_RENDER_QUALITY);
	 * g2d.setRenderingHint(RenderingHints.KEY_DITHERING,
	 * RenderingHints.VALUE_DITHER_ENABLE);
	 * g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
	 * RenderingHints.VALUE_FRACTIONALMETRICS_ON);
	 * g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	 * RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	 * g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
	 * RenderingHints.VALUE_RENDER_QUALITY);
	 * g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
	 * RenderingHints.VALUE_STROKE_PURE); g2d.setFont(font); fm =
	 * g2d.getFontMetrics(); g2d.setColor(Color.BLACK); g2d.drawString(text, 0,
	 * fm.getAscent()); g2d.dispose(); try { ImageIO.write(img, "png", new
	 * File("/home/credentek/Deepak/New Start/Sample1.jpg"));
	 * 
	 * System.out.println("Image Created Successfully"); } catch (IOException ex) {
	 * ex.printStackTrace(); } }
	 */

	public static void main(String[] args) throws Exception {
		String text = "JavaInfinite";
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics2d = image.createGraphics();
		Font font = new Font("TimesNewRoman", Font.BOLD, 24);
		graphics2d.setFont(font);
		FontMetrics fontmetrics = graphics2d.getFontMetrics();
		int width = fontmetrics.stringWidth(text);
		int height = fontmetrics.getHeight();
		graphics2d.dispose();

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		graphics2d = image.createGraphics();
		graphics2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
				RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		graphics2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		graphics2d.setFont(font);
		fontmetrics = graphics2d.getFontMetrics();
		graphics2d.setColor(Color.GREEN);
		graphics2d.drawString(text, 0, fontmetrics.getAscent());
		graphics2d.dispose();
		try {
			ImageIO.write(image, "png", new File("/home/credentek/Deepak/New Start/Sample_2.jpg"));
			
			System.out.println("Image Created Successfully");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
