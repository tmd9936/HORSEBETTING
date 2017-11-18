package frameText;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import vo.Horse;

public class HorseFrame extends JFrame {
	Random random = new Random();
	int[] ar = new int[5];
	Move move = new Move();

	ArrayList<Horse> horseArr = new ArrayList<>();

	public HorseFrame(User user) {
		setTitle("경마 게임");
		setSize(1800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyPanel myPanel = new MyPanel();
		add(myPanel);
		// myPanel.setBackground(Color.PINK);

		setVisible(true);
	}

	class MyPanel extends JPanel {
		boolean end = false;

		public MyPanel() {
			super();
			horseInit();
			class MyThread extends Thread {
				public void run() {
					while (true) {
						try {
							horseUpdate();
							repaint();
							Thread.sleep(10);
							if (end == true) {
								//TODO 유저한테 돈 넣는 기능 넣기
								Thread.sleep(2000);
								dispose();
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}
			Thread t = new MyThread();
			t.start();
		}
		
		//TODO 배팅하는 함수 만들기
		
		public void horseInit() {
			//TODO 배팅하는 함수 넣기
			
			horseArr.add(
					new Horse("horse2.png", 100, "1", random.nextInt(5), random.nextInt(10) + 5, random.nextInt(5)));
			horseArr.add(
					new Horse("horse2.png", 200, "2", random.nextInt(5), random.nextInt(10) + 5, random.nextInt(5)));
			horseArr.add(
					new Horse("horse2.png", 300, "3", random.nextInt(5), random.nextInt(10) + 5, random.nextInt(5)));
			horseArr.add(
					new Horse("horse2.png", 400, "4", random.nextInt(5), random.nextInt(10) + 5, random.nextInt(5)));
			horseArr.add(
					new Horse("horse2.png", 500, "5", random.nextInt(5), random.nextInt(10) + 5, random.nextInt(5)));
			int ar = 0;
			for (int i = 0; i < horseArr.size(); i++) {
				 ar = horseArr.get(i).getSpeed() + horseArr.get(i).getCondition() + move.condition_patch()
						+ horseArr.get(i).getHealth() + move.health_patch();
				horseArr.get(i).setAr(ar);
				System.out.print("speed : "+horseArr.get(i).getSpeed()+" condition : "+horseArr.get(i).getCondition()
						+" health : "+horseArr.get(i).getHealth());
				System.out.println(" ar : "+ar);
			}
		}

		public void horseUpdate() {
			for (int i = 0; i < horseArr.size(); i++) {
				horseArr.get(i).update();
			}
			for (Horse horse : horseArr) {
				horse.setCnt(horse.getCnt() + 1);
			}
		}

		///////////////////// 그리기 함수 모음////////////////////////////////
		// 그려주는 객체
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(new ImageIcon("background2.png").getImage(), 0, 0, null);

			drawHorseWheel(g); // 말 바퀴수 체크
			checkFinish(g);

			for (int i = 0; i < horseArr.size(); i++) {
				horseArr.get(i).draw(g);
			}
		}

		public void drawHorseWheel(Graphics g) {
			// 말의 바퀴수 체크후 그리기
			for (int i = 0; i < horseArr.size(); i++) {
				g.setColor(Color.RED);
				Font font2 = new Font("Serif", Font.BOLD, 20);
				g.setFont(font2);
				g.drawString(i + 1 + "번마 : " + horseArr.get(i).getNumOfWheels() + "바퀴", 0, 500 + i * 30);
			}
		}

		public void checkFinish(Graphics g) {
			// 말의 바퀴수를 체크하면서 완주 한 말이 있나 확인
			int wheels = 10; // 완주 바퀴수
			for (int i = 0; i < horseArr.size(); i++) {
				if (horseArr.get(i).getNumOfWheels() == wheels) {
					end = true;

					g.setColor(Color.BLACK);
					Font font2 = new Font("Serif", Font.BOLD, 150);
					g.setFont(font2);
					g.drawString(i + 1 + "번마의 승리!!", 600, 250);
					
					//TODO 이겼으면 돈넣기 지면 없음
					
					break;
				}

			}
		}
		///////////////////// 그리기 함수 모음//////////////////////

	}
}
