class Solution {
    boolean helper(int[] piles,int i,int j,int stone1, int stone2,boolean one){
        if(i>j){
            if(stone1>stone2){
                return true;
            }
            return false;
        }
    
        if(one){
            return helper(piles,i+1,j,stone1+piles[i],stone2,false) || helper(piles,i,j-1,stone1+ piles[j],stone2,false);
        }else{
             return helper(piles,i+1,j,stone1,stone2+piles[i],false) &&  helper(piles,i,j-1,stone1,stone2 + piles[j],false);
        }



    }
    public boolean stoneGame(int[] piles) {
        return helper(piles,0,0,0,0,true);
    }
}