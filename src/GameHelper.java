import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;






/* 
游戏“地图”为7×7矩阵，实际代码中“地图”存储在in[49]的数组中
如下图
7×7矩阵示例，单数号的DotCom垂直分布
  1  2  3  4  5  6  7 
a 1  2  3  4  5  6  7
b 8  9  10 11 12 13 14
c 15 16 17 18 19 20 21
d
e
f
g

首先在0~49中随机一个数作为起点，DotCom编号为单数时，location每次加7，达到垂直效果


*/





public class GameHelper{

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;


    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.println(prompt + "  ");

        try{
            BufferedReader is = new BufferedReader(
                new InputStreamReader(System.in));
                inputLine = is.readLine();
                if(inputLine.length() == 0){
                    return null;
                }
        }
        catch(IOException e){
            System.out.println("IOException " + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<String>();

        String[] alphacoords = new String[comSize];     
        String temp = null;
        int[] coords = new int[comSize];                            //用来存储随机结果
        int attempts = 0;
        boolean success = false;
        int location = 0;                                           //目前起点

        comCount++;
        int incr = 1;                                               //水平增量
        if((comCount % 2 ) == 1){                                   //单数号的DotCom垂直分布
            incr = gridLength;
        }

        while(!success & attempts++ < 200){
            location = (int)(Math.random() * gridSize);             //在0~49内随机
            System.out.println(" try " + location);
            int x = 0;
            success = true;
            while(success && x <comSize){
                if(grid[location] == 0){                            //随机出来的坐标是否已被使用
                    coords[x++] = location;                         //记录坐标
                    location += incr;
                    if(location >= gridSize){                       //当DC垂直时才有可能超出下边界
                        success = false;
                    }
                    if(x>0 && (location % gridLength) == 0){        //当DC水平时才能超出右边界
                        success = false;
                    }
                }else{
                    System.out.println(" used " + location);
                    success = false;
                }
            }
        }

        int x = 0;
        int row = 0;
        int column = 0;
    
        while(x < comSize){
            grid[coords[x]] = 1;
            row = (int)(coords[x] / gridLength);                    //计算第几行
            column = coords[x] % gridLength;                        //第几列
            temp = String.valueOf(alphabet.charAt(column));         //列用avcdefg表示，
                                                                    //此时temp里只有一个字母

            alphaCells.add(temp.concat(Integer.toString(row)));     //temp后添加数字（行数）
            x++;
            System.out.println("  coord " + x + " = " + alphaCells.get(x-1));
        }

        return alphaCells;


    }

}