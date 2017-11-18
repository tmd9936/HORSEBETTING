package vo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Horse extends GraphicObject {
	Random random = new Random();
	private int width = 120;
	private int height = 75;
	private int numOfWheels = 0;
	int cnt = 0;
	int ar = 0; //최종 랜덤 속도

	private int condition, speed, health;
	String hNum;

	public Horse(String name, int y) {
		super(name, y);
	}

	public Horse(String name, int y, String hNum, int condition, int speed, int health) {
		super(name, y);
		x = 0;
		this.y = y;
		this.hNum = hNum;
		this.condition = condition;
		this.speed = speed;
		this.health = health;
	}
	
	

	public int getAr() {
		return ar;
	}

	public void setAr(int ar) {
		this.ar = ar;
	}

	public int getNumOfWheels() {
		return numOfWheels;
	}

	public void setNumOfWheels(int numOfWheels) {
		this.numOfWheels = numOfWheels;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void update() {
		ar = (int)(ar /30);
		
		x += random.nextInt(ar+1)+random.nextInt(15);
		if (x > 1700) {
			x = 0;
			numOfWheels++;
		}
	}

	public void draw(Graphics g) {
		g.setClip(x, y, width, height);

		int t = 20;
		int p = 14;
		if (cnt / t % p == 0) {
			g.drawImage(img, x - (width * 0), y, null);
		} else if (cnt / t % p == 1) {
			g.drawImage(img, x - (width * 1), y, null);
		} else if (cnt / t % p == 2) {
			g.drawImage(img, x - (width * 2), y, null);
		} else if (cnt / t % p == 3) {
			g.drawImage(img, x - (width * 3), y, null);
		} else if (cnt / t % p == 4) {
			g.drawImage(img, x - (width * 4), y, null);
		} else if (cnt / t % p == 5) {
			g.drawImage(img, x - (width * 0), y - 80, null);
		} else if (cnt / t % p == 6) {
			g.drawImage(img, x - (width * 1), y - 80, null);
		} else if (cnt / t % p == 7) {
			g.drawImage(img, x - (width * 2), y - 80, null);
		} else if (cnt / t % p == 8) {
			g.drawImage(img, x - (width * 3), y - 80, null);
		} else if (cnt / t % p == 9) {
			g.drawImage(img, x - (width * 4), y - 80, null);
		} else if (cnt / t % p == 10) {
			g.drawImage(img, x - (width * 0), y - 160, null);
		} else if (cnt / t % p == 11) {
			g.drawImage(img, x - (width * 1), y - 160, null);
		} else if (cnt / t % p == 12) {
			g.drawImage(img, x - (width * 2), y - 160, null);
		} else if (cnt / t % p == 13) {
			g.drawImage(img, x - (width * 3), y - 160, null);
		} else if (cnt / t % p == 14) {
			g.drawImage(img, x - (width * 4), y - 160, null);
		}
		
		g.setColor(Color.BLUE);
		Font font2 = new Font("Serif", Font.BOLD, 20);
		g.setFont(font2);
		g.drawString(hNum, x + 50, y + 40);

	}
}
