package com.peisia.c.board;

import com.peisia.c.board.data.Data;
import com.peisia.c.board.data.Post;
import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcMenuDel {
	static void run() {
		Cw.wn("삭제임");
		String cmd = Ci.r("삭제할 글 번호");
		
		int temp = 0;
		
		for(int i=0;i<Data.posts.size();i++) {
			if(cmd.equals(Data.posts.get(i).instanceNo+"")) {
				temp = i ;
			} 
		}
		
		Data.posts.remove(temp);
	}
}
