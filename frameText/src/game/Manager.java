package game;

import java.util.*;

public class Manager {
	Scanner scan = new Scanner(System.in);
	Horse hhh = new Horse();
	Move move = new Move();
	Random random = new Random();
	//ArrayList<Human> list = new ArrayList<>();
	ArrayList<Horse> horse = new ArrayList<>();
	//Human h = new Human();
	int a;
	int arrival = 0;

	int[] ar = new int[5];

	public void horse() {
		horse.add(new Horse(random.nextInt(10), random.nextInt(50) + 20, random.nextInt(10)));
		horse.add(new Horse(random.nextInt(10), random.nextInt(50) + 20, random.nextInt(10)));
		horse.add(new Horse(random.nextInt(10), random.nextInt(50) + 20, random.nextInt(10)));
		horse.add(new Horse(random.nextInt(10), random.nextInt(50) + 20, random.nextInt(10)));
		horse.add(new Horse(random.nextInt(10), random.nextInt(50) + 20, random.nextInt(10)));

		for (int i = 0; i < ar.length; i++) {
			ar[i] = horse.get(i).getSpeed() + horse.get(i).getCondition() + move.condition_patch()
					+ horse.get(i).getHealth() + move.health_patch();
			// System.out.println(ar[i]);
		}
	}

	public void gameStart() {
		Game();
		start();
	}

	public void Game() {

		while(true)
		{
			horse();
			for (int i = 0; i < ar.length; i++) {
				System.out.println(
						i + 1 + "踰덈쭏 而⑤뵒�뀡 : " + horse.get(i).getCondition() + " " + "嫄닿컯 : " + horse.get(i).getHealth());
			}
			System.out.println("紐뉖쾲 留먯쓣 �꽑�깮 �븯�떆寃좎뒿�땲源�?");
			a = scan.nextInt();
			if(a>0 && a<6)
				break;
		}
		/*
		 * for (int i = 0; i < ar.length; i++) { System.out.println(ar[i]); }
		 */

	}

	public void start() {
		int[] arr = new int[5];

		while (true) {
			clean();
			System.out.println("吏꾪뻾");
			System.out.println();
			System.out.println();
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < arr[i]; j++) {
					System.out.print("-");
				}
				System.out.print(i+1 + "腰�");
				System.out.println();
			}

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < arr.length; i++) {
				arr[i] += ar[i] / 30 + random.nextInt(10);
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > 137) {
					clean();
					System.out.println(i+1 + "踰� 留먯씠 �슦�듅�븯���뒿�땲�떎.");
					return;
				}
			}
		}
	}

	public void clean() {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
	}
}
