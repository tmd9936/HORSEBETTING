package game;

import java.util.Random;

public class Horse {

	int condition,speed,health;
	Random random = new Random();
	public Horse() {}
	
	public Horse(int c, int s, int h) {
		condition = c;
		speed = s;
		health = h;
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

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public String toString() {
		return "Horse [condition=" + condition + ", speed=" + speed + ", health=" + health + ", random=" + random + "]";
	}
	
	
}
