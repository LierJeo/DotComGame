import java.util.ArrayList;

public class DotCom {

    private ArrayList<String> locationCells;
    private String Name;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    /**
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.Name = name;
    }

    public String checkYourself(String userGuess) {
        String result = "miss";
        int index = locationCells.indexOf(userGuess);

        if(index >= 0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result = "kill";
                System.out.println("You sunk " + Name + ".");
            } else{
                result = "hit";
            }
        }

        System.out.println(result);
        return result;
    }
}