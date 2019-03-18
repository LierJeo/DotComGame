import java.util.ArrayList;

public class SimpleDotComGame {
    public static void main(String[] argc){
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        
        SimpleDotCom theDotCom = new SimpleDotCom();
        int radomNum = (int)(Math.random()*5);
        ArrayList<String> locations = new ArrayList<String>();
        locations.add(Integer.toString(radomNum));
        locations.add(Integer.toString(radomNum + 1));
        locations.add(Integer.toString(radomNum + 2));
        theDotCom.setLocationCells(locations);

        boolean isAlive = true;
        while(isAlive){
            String guess = helper.getUserInput("enter a number");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;

            if(result.equals("kill")){
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }
    }
}