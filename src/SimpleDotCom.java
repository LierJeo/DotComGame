public class SimpleDotCom {

    int[] locationCells;
    int numOfHit = 0;
    
    public void setLocationCells(int[] locs){
        locationCells = locs;
    }

    public String checkYourself(String userGuess){
        int guess = Integer.parseInt(userGuess);
        String result = "miss";

        for(int cell : locationCells){
            if(guess == cell){
                result = "hit";
                numOfHit++;
                break;
            }
        }
        if(numOfHit == locationCells.length){
            result = "kill";
        }

        System.out.println(result);
        return result;
    }
}