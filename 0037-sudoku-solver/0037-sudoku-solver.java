class Solution {
  public boolean solveSudoku(char[][] b) {
    for (int r=0;r<9;r++){
      for (int c=0;c<9;c++){
        if (b[r][c]=='.'){
          for (char d='1';d<='9';d++){
            if (isValid(b,r,c,d)){
              b[r][c]=d;
              if (solveSudoku(b)) return true;
              b[r][c]='.';
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  public boolean isValid(char[][] b,int r,int c,char d){
    for (int k=0;k<9;k++){
      if (b[r][k]==d||b[k][c]==d||b[(r/3)*3+k/3][(c/3)*3+k%3]==d) return false;
    }
    return true;
  }
}
