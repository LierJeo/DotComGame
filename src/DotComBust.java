import java.util.ArrayList;

public class DotComBust {
    
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> DotComList = new ArrayList<DotCom>();
    private int numOfGuess = 0;         //猜测次数

    private void SetUpGame(){
        DotCom dotCom1 = new DotCom();
        dotCom1.setName("Pets.com");
        DotCom dotCom2 = new DotCom();
        dotCom1.setName("eToys.com");
        DotCom dotCom3 = new DotCom();
        dotCom1.setName("Go2.com");
        DotComList.add(dotCom1);
        DotComList.add(dotCom2);
        DotComList.add(dotCom3);
        
        System.out.println("Your goal is to sink three dot games");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in fewest num of guusses");

        for(DotCom dotComToSet : DotComList){                       //循环DotComList数组
            ArrayList<String> newLocations = helper.placeDotCom(3);  //获取位置
            dotComToSet.setLocationCells(newLocations);
        }
    }

    private void startPlaying(){
        while(!DotComList.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
            CheckUserGuess(userGuess);
        }
        finishGame();
    }
    
    private void CheckUserGuess(String guess){
        numOfGuess++;
        String result = "miss";

        for(DotCom dotComToTest : DotComList){                  //需要遍历List中的所有DotCom
            result = dotComToTest.checkYourself(guess);         //检查是否命中
            if(result == "hit"){
                break;
            }
            if(result == "kill"){
                DotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }


    private void finishGame(){
        System.out.println("All DotCom are dead");
        System.out.println("You took " + numOfGuess + " guesses");
    }

    public static void main(String[] argc){
        DotComBust game = new DotComBust();
        game.SetUpGame();
        game.startPlaying();
    }

}