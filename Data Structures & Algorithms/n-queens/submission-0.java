class Solution {
    public List<List<String>> solveNQueens(int n) {
        

        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            curr.add(".".repeat(n));
        }

        ans.add(curr);

        List<List<String>> newAns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (List<String> board : ans) {
                if (board.get(i).contains("Q"))
                    continue;
                

                
                for (int j = 0; j < n; j++) {
                    boolean truth = false;
                    for (int k = 0; k < i; k++) {
                        if (board.get(k).charAt(j) == 'Q') {
                            truth = true;
                            break;
                        }
                            
                    }

                    if (truth) {
                        continue;
                    }

                    int newI = i-1;
                    int newJ = j-1;

                    while (newI > -1 && newJ > -1) {
                        if (board.get(newI).charAt(newJ) == 'Q') {
                            truth = true;
                            break;
                        }
                        newI--;
                        newJ--;
                    }

                    if (truth) {
                        continue;
                    }

                    newI = i-1;
                    newJ = j+1;

                    while (newI > -1 && newJ < n) {
                        if (board.get(newI).charAt(newJ) == 'Q') {
                            truth = true;
                            break;
                        }
                        newI--;
                        newJ++;
                    }

                    if (truth) {
                        continue;
                    }

                    List<String> nBoard = new ArrayList<String>(board);
                    String s = nBoard.get(i);
                    String newS = s.substring(0,j) + "Q" + s.substring(j+1);
                    nBoard.set(i, newS);
                    newAns.add(nBoard);

                }
            }

            ans = new ArrayList<>(newAns);
            newAns.clear();
            
        }

        return ans;
    }
}
