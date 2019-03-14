

public class DotComGameTestDrive {
	public static void main(String[] args) {
 -
		
		SimpleDotCom dot = new SimpleDotCom();
		
		int[] loactions = {2,3,4};
		dot.setLocationCells(loactions);
		
		String userGuess = "2";
		String result = dot.checkYourself(userGuess);
		String testResult = "failed";
		if(result.equals("hit")){
			testResult = "passed";
		}
		System.out.println(testResult);

	}
}