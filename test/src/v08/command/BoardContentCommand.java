package v08.command;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import v08.dao.BoardDao;
import v08.domain.Board;

// Command규칙 적용
public class BoardContentCommand implements Command{
	BoardDao boardDao;

	byte[] buffer = new byte[8192];
	int cursor;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public void execute(HashMap<String,Object> params) {
		ArrayList<Board> list = boardDao.selectList();
		Scanner scanner = (Scanner)params.get("scanner");

		System.out.print("게시물 번호? ");
		int no = Integer.parseInt(scanner.nextLine());

		Board board = null;
		for (int i = 0; i < list.size(); i++) {
			board = list.get(i);	// 제네릭을 적용했기 때문에 타입캐스팅 할 필요가 없다.
			if (board == null)
				continue;
			else if (i == no){
				System.out.printf("Title: %s\t\t\tDate: %s\n", 
						board.getTitle(),
						board.getWriter());

				String txt = board.getContent();
				int k =1;
				try {
					buffer = txt.getBytes("UTF-8");
					cursor = txt.getBytes("UTF-8").length;
					for (int j = 0; j <= cursor; j++) {
						System.out.println(cursor);
						String str = new String(buffer, j , j, "UTF-8");
						k++;
						System.out.printf("%s", str);
						if (j % 5 == 0)
							System.out.println();
					}

				} 
				catch (Exception e) {
					System.out.println("인코딩에러");
				}
			}
		}
	}

}
