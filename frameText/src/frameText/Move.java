package frameText;

import java.util.ArrayList;
import java.util.Random;

import vo.Horse;

public class Move {
	Horse h = new Horse("horse2.png",0);
	private int a, b;

	public int condition_patch() {

		switch (h.getCondition()) {
		case 0:
			a = h.getSpeed();
			break;
		case 1:
		case 2:
		case 3:
			a = h.getSpeed() + 3;
			break;
		case 4:
		case 5:
		case 6:
			a = h.getSpeed() + 6;
			break;
		case 7:
		case 8:
		case 9:
			a = h.getSpeed() + 9;
			break;
		case 10:
			a = h.getSpeed() + 15;
		default:
			break;
		}
		return h.getSpeed();
	}

	public int health_patch() {

		switch (h.getHealth()) {
		case 0:
			b = h.getSpeed()-18;
			break;
		case 1:
			b = h.getSpeed()-12;
			break;
		case 2:
			b = h.getSpeed()-9;
			break;
		case 3:
			b = h.getSpeed()-6;
			break;
		case 4:
			b = h.getSpeed()-3;
			break;
		case 5:
			b = h.getSpeed();
			break;
		case 6:
			b = h.getSpeed();
			break;
		case 7:
			b = h.getSpeed()+3;
			break;
		case 8:
			b = h.getSpeed()+6;
			break;
		case 9:
			b = h.getSpeed()+9;
			break;
		case 10:
			b = h.getSpeed()+15;
			break;

		default:
			break;
		}

		return h.getSpeed();
	}
	
}
