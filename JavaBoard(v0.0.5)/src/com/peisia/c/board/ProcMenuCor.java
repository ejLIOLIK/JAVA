package com.peisia.c.board;

import com.peisia.c.board.data.Data;
import com.peisia.c.board.data.Post;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcMenuCor {
	
	static void run() {
		
		Cw.wn("수정임");
		String cmd = Ci.r("수정할 글 번호");

		for(Post p: Data.posts) {
			if(cmd.equals(p.instanceNo+"")){
				p.infoForRead();
			}			
		}
		
		String cmd2 = Ci.r("[1.글제목/2.글내용/3.작성자]");
		String TempCor = "";

		switch (cmd2) {
		case "1":
			while (true) {
				TempCor = Ci.rl("글제목");
				if (TempCor.length() > 0) {
					for (Post p : Data.posts) {
						if (cmd.equals(p.instanceNo + "")) {
							p.title = TempCor;
						}
					}
					Cw.wn("글 수정됨");
					break;
				} else {
					Cw.wn("장난x");
				}
			}
			break;
		case "2":
			while (true) {
				TempCor = Ci.rl("글내용");
				if (TempCor.length() > 0) {
					for (Post p : Data.posts) {
						if (cmd.equals(p.instanceNo + "")) {
							p.content = TempCor;
						}
					}
					Cw.wn("글 수정됨");
					break;
				} else {
					Cw.wn("장난x");
				}
			}
			break;
		case "3":
			while (true) {
				TempCor = Ci.r("작성자");
				if (TempCor.length() > 0) {
					for (Post p : Data.posts) {
						if (cmd.equals(p.instanceNo + "")) {
							p.writer = TempCor;
						}
					}
					Cw.wn("글 수정됨");
					break;
				} else {
					Cw.wn("장난x");
				}
			}
			break;
		default:
			Cw.wn("장난x");
		}
	}
		
		
	
	
}
