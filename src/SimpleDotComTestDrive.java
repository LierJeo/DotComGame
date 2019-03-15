
public class SimpleDotComTestDrive {
    public static void main(String[] argc){
        SimpleDotCom dot = new SimpleDotCom();

        int[] locations = {2,3,5};
        dot.setLocationCells(locations);

        String userGuess = "2";
        String result = dot.checkYourself(userGuess);

        String testResult = "failed";
        if(result.equals("hit")){
            testResult = "passed";        
        }
        System.out.println(testResult);
    }

}
