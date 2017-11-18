package vo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

class GraphicObject {
	BufferedImage img = null;
	int x = 0, y = 0;

	public GraphicObject(String name, int y) {
		try {
			img = ImageIO.read(new File(name));
			this.y = y;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
			// TODO: handle exception
		}
	}

	public void update() {
	}

	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
}
