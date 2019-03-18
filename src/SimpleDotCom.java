import java.util.ArrayList;

public class SimpleDotCom {

    private ArrayList<String> locationCells;
    
    
    public void setLocationCells(ArrayList<String> locs){
        locationCells = locs;
    }

    public String checkYourself(String userGuess){
        String result = "miss";

        int index = locationCells.indexOf(userGuess);

        if(index >= 0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result = "kill";
            } else{
                result = "hit";
            }
        }

        System.out.println(result);
        return result;
    }
}