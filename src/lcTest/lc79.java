package lcTest;

import org.junit.Test;

//单词搜索
public class lc79 {
    @Test
    public void test(){
        long l = System.currentTimeMillis();
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String w = "ABCESEEEFS";
        if (exist(board,w)) {
            System.out.println(true);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }
    /*
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == words[0]){
                    set.clear();
                    if (myPath(board,words,i,j,0,set))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean myPath(char[][] board,char[] words,int x,int y,int len,Set<String> myset){
        //System.out.println(myset.toString());
        if (len==words.length){
            return true;
        }
        if (x>=board.length||y>=board[0].length||x<0||y<0)
            return false;
        if (words[len]==board[x][y]&&!myset.contains(x+""+y)){ //一致
            myset.add(x+""+y);
            if(!myPath(board,words,x-1,y,len+1,myset)&&
                    !myPath(board,words,x+1,y,len+1,myset)&&
                    !myPath(board,words,x,y-1,len+1,myset)&&
                    !myPath(board,words,x,y+1,len+1,myset)){
                myset.remove(x+""+y);
                return false;
            }
            return true;
        }
        else {
            return false;
        }
    }*/


    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == words[0]){
                    int[][] marks = new int[board.length][board[0].length];
                    if (myPath(board,words,i,j,0,marks))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean myPath(char[][] board,char[] words,int x,int y,int len,int[][] marks) {
        if (len==words.length){
            return true;
        }
        if (x>=board.length||y>=board[0].length||x<0||y<0)
            return false;

        if (words[len]==board[x][y]&&marks[x][y]==0){ //一致
            marks[x][y]=1;
            if(!myPath(board,words,x-1,y,len+1,marks)&&
                    !myPath(board,words,x+1,y,len+1,marks)&&
                    !myPath(board,words,x,y-1,len+1,marks)&&
                    !myPath(board,words,x,y+1,len+1,marks)){
                marks[x][y]=0;
                return false;
            }
            return true;
        }
        else {
            return false;
        }
    }
}
