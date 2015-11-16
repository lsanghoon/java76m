package test01;

import java.util.Scanner;

public class scoreResult {

	static class Score {
		String name;
		int[] sub = new int[3];
		int sum;
		float aver;
	}
	
	public static void main(String[] args) {
		Score[] score = { new Score(), new Score(), new Score() };
		
		input(score);
		
		for (int i = 0; i < score.length; i++) {
			print(score[i]);
		}
	}

	public static void input(Score[] score) {
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < score.length; i++) {
			System.out.print("name : ");
			String name = scan.nextLine();
			System.out.print("kor : ");
			int kor = scan.nextInt();
			//System.out.print("mat : ");
			int mat = scan.nextInt();
			//System.out.print("eng : ");
			int eng = scan.nextInt();
			scan.nextLine();
			
			setInfo(score[i], name, kor, mat, eng);
		}
	}
	
	public static void setInfo (Score score, 
															String name, int kor, int mat, int eng) {
		score.name = name;
		score.sub[0] = kor;
		score.sub[1] = mat;
		score.sub[2] = eng;
		
		compute (score);
	}
	
	public static void compute (Score score) {
		score.sum = 0;
		for (int i = 0; i < score.sub.length; i++) {
			score.sum += score.sub[i];
		}
		score.aver = score.sum / (float)score.sub.length;
	}
	
	public static void print(Score score) {
		System.out.printf("%s: 국어: %d, 수학: %d, 영어: %d, 총계: %d, 평균: %.2f\n", 
				score.name, score.sub[0], score.sub[1], score.sub[2],
				score.sum, score.aver);
		System.out.println(score.name.toString());
	}
}
