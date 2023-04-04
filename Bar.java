import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Bar {

    public static void main(String[] args) {
        try{
            Entry entry = new Bar().new Entry(args[0]);
            entry.parser();
            entry.draw();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public class Entry{
        private ArrayList<String> inputList = new ArrayList<>();
        private int n;

        private int m;
        private int k;
        private int beginIndex;

        public Entry(String inputFile) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String temp;
            while((temp = reader.readLine()) != null){
                inputList.add(temp);
            }
        }

        public void parser() throws Exception{
            for(int i = 0; i < inputList.size(); ++i){
                String line = inputList.get(i);
                if(i == 0){
                    String[] mugSize = line.split(" ");
                    n  = Integer.parseInt(mugSize[0]);
                    m  = Integer.parseInt(mugSize[1]);
                    if(n <2 || n > 100){
                        throw new IllegalArgumentException();
                    }
                    if(m <3 || m > 100){
                        throw new IllegalArgumentException();
                    }
                } else if(i == n+1) {
                    k = Integer.parseInt(line);
                    if(k < 0 || k > Math.min(n - 1, 89)){
                        throw new IllegalArgumentException();
                    }
                } else if(i > n+1) {
                    String[] coctailes = line.split(" ");
                    if(coctailes[0].length() < 1 || coctailes[0].length() > 10){
                        throw new IllegalArgumentException();
                    }
                    if(!(coctailes[2].charAt(0) > 32 && coctailes[2].charAt(0) < 127)){
                        throw new IllegalArgumentException();
                    }
                    beginIndex += Integer.parseInt(coctailes[1]);
                }
            }
        }

        public void draw(){
            beginIndex = n - beginIndex;
            String currentDrink = inputList.get(n + 1 + k);
            String[] arr = currentDrink.split(" ");
            char drinkChar = currentDrink.charAt(currentDrink.length() - 1);
            int drinkLines = Integer.parseInt(arr[1]);
            int printedDrinkLines = 0;
            for(int i = 1; i < n; ++i){
                char[] strToChar = inputList.get(i).toCharArray();
                int j = 0;
                while(strToChar[j] == '.' || strToChar[j] == '\\' || strToChar[j] == '|' || strToChar[j] == '/'){
                    System.out.print(strToChar[j]);
                    ++j;
                }
                if(i >= beginIndex){
                    while(strToChar[j] == ' '){
                        System.out.print(drinkChar);
                        ++j;
                    }
                    ++printedDrinkLines;
                    if(printedDrinkLines == drinkLines && i != n - 1){
                        --k;
                        currentDrink = inputList.get(n + 1 + k);
                        arr = currentDrink.split(" ");
                        drinkChar = currentDrink.charAt(currentDrink.length() - 1);
                        drinkLines = Integer.parseInt(arr[1]);
                        printedDrinkLines = 0;

                    }
                }
                while(j < strToChar.length){
                    System.out.print(strToChar[j]);
                    ++j;
                }
                System.out.println();
            }
            System.out.println(inputList.get(n));
        }
    }
}