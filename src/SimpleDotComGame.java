public class SimpleDotComGame {
    public static void main(String[] argc){
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        
        SimpleDotCom theDotCom = new SimpleDotCom();
        int radomNum = (int)(Math.random()*5);
        int[] loactions = {radomNum, radomNum +1, radomNum + 2};
        theDotCom.setLocationCells(loactions);

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