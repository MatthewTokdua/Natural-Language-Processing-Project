import java.util.ArrayList;
import java.util.Scanner;

public class BestMoveNLP {

  //String ArrayLists and arrays
  private ArrayList<String> cardRolls = new ArrayList<String>();
  private ArrayList<String> cardRolls2 = new ArrayList<String>();
  private String[] geb = FileReader.toStringArray("gebura.txt");
  private String[] keter = FileReader.toStringArray("keter.txt");
  private String[] xiao = FileReader.toStringArray("xiao.txt");
  private String[] kim = FileReader.toStringArray("kim.txt");
  private String[] rat = FileReader.toStringArray("rat.txt");
  private String[] argalia = FileReader.toStringArray("argalia.txt");
  //one int for the user prompt
  private int twiceSubPrompt = 0;
  
  /**
   * assigns argalia values to cardRolls2
  */
  public BestMoveNLP() {
    cleanData(argalia,cardRolls2);
  }
  
  /**
   * method to separte min and max values
   * @param String[] data the data that is being cleaned
   * @param ArrayList<String> rolls which rolls to assign the data to
   */
  public void cleanData(String[] data, ArrayList<String> rolls){
    String[][] temp = new String[2][data.length];
    for (int i=0;i<data.length;i++){
      String[] temp2 = data[i].split(" ");
      temp[0][i] = temp2[0];
      temp[1][i] = temp2[1];
      rolls.add(temp[0][i]);
      rolls.add(temp[1][i]);
    }
  }


  
  /**
   * method to calculate rolls
   * @param int min the minimum roll possible
   * @return Integer returns the final roll as an integer
   */
  public Integer calcRolls(int min){
    int diff = Integer.parseInt(cardRolls.get(min+1)) - Integer.parseInt(cardRolls.get(min));
    int rand = (int) (Math.random() * (diff));
    int roll = Integer.parseInt(cardRolls.get(min)) + (diff - rand);
    return roll;
  }

  /**
   * method to calculate the best page to use
   * @return String returns the rolls in the format used by the .txt files
   */
  public String calcHighestAvgRolls(){
    ArrayList<Integer> avgRolls = new ArrayList<Integer>();
    ArrayList<Integer> high = new ArrayList<Integer>();
    int min = Integer.MIN_VALUE;
    String result = "";
    for (int i=0;i<cardRolls.size();i+=2){
      avgRolls.add(Integer.MIN_VALUE);
      avgRolls.add((calcRolls(i) + calcRolls(i) + calcRolls(i) + calcRolls(i) + calcRolls(i)) / 5);
      high.add(Integer.parseInt(cardRolls.get(i)));
      high.add(Integer.parseInt(cardRolls.get(i+1)));
    }
    for (int i3=0;i3<avgRolls.size();i3++){
        if (avgRolls.get(i3) > min){
          result = String.valueOf(high.get(i3-1)) + " " + String.valueOf(high.get(i3));
          min = avgRolls.get(i3);
        }
    }
    return result;
  }

  /**
   * method to calculate which roll Argalia will use
   * @return String returns the rolls in the format used by the .txt files
   */
  public String calcArgalia(){
    int rand = ((int) (Math.random() * (cardRolls2.size())));
    if (rand % 2 == 0){
      return cardRolls2.get(rand) + " " + cardRolls2.get(rand+1);
    }else return cardRolls2.get(rand-1) + " " + cardRolls2.get(rand);
  }

  /**
   * Starts the app and gets user input
   */
  public void prompt() {
    Scanner input = new Scanner(System.in);
    while (twiceSubPrompt == 0){
      subPrompt();
    }
    input.close();
  }

  //
  public void subPrompt(){
    Scanner input = new Scanner(System.in);
    System.out.println("Which pack would you like to use? gebura, keter, xiao, kim, or rat?");
    String userInput = input.nextLine();
    if (userInput.equals("gebura")){
      cleanData(geb,cardRolls);
      System.out.println("Ok!");
      System.out.println("Argalia is using this page: " + calcArgalia());
      System.out.println("You have these pages: ");
      for (int i=0;i<cardRolls.size();i++){
        if (i % 2 == 0){
          System.out.print(cardRolls.get(i) + " ");
        }else System.out.print(cardRolls.get(i) + "  ");
      }
      System.out.println("");
      System.out.println("You should use this page: " + calcHighestAvgRolls());
      twiceSubPrompt++;
    }else if (userInput.equals("keter")){
      cleanData(keter,cardRolls);
      System.out.println("Ok!");
      System.out.println("Argalia is using this page: " + calcArgalia());
      System.out.println("You have these pages: ");
      for (int i=0;i<cardRolls.size();i++){
        if (i % 2 == 0){
          System.out.print(cardRolls.get(i) + " ");
        }else System.out.print(cardRolls.get(i) + "  ");
      }
      System.out.println("");
      System.out.println("You should use this page: " + calcHighestAvgRolls());
      twiceSubPrompt++;
    }else if (userInput.equals("xiao")){
      cleanData(xiao,cardRolls);
      System.out.println("Ok!");
      System.out.println("Argalia is using this page: " + calcArgalia());
      System.out.println("You have these pages: ");
      for (int i=0;i<cardRolls.size();i++){
        if (i % 2 == 0){
          System.out.print(cardRolls.get(i) + " ");
        }else System.out.print(cardRolls.get(i) + "  ");
      }
      System.out.println("");
      System.out.println("You should use this page: " + calcHighestAvgRolls());
      twiceSubPrompt++;
    }else if (userInput.equals("kim")){
      cleanData(kim,cardRolls);
      System.out.println("Ok!");
      System.out.println("Argalia is using this page: " + calcArgalia());
      System.out.println("You have these pages: ");
      for (int i=0;i<cardRolls.size();i++){
        if (i % 2 == 0){
          System.out.print(cardRolls.get(i) + " ");
        }else System.out.print(cardRolls.get(i) + "  ");
      }
      System.out.println("");
      System.out.println("You should use this page: " + calcHighestAvgRolls());
      twiceSubPrompt++;
    }else if (userInput.equals("rat")){
      cleanData(rat,cardRolls);
      System.out.println("Why. -_-");
      System.out.println("Argalia is using this page: " + calcArgalia());
      System.out.println("You have these pages: ");
      for (int i=0;i<cardRolls.size();i++){
        if (i % 2 == 0){
          System.out.print(cardRolls.get(i) + " ");
        }else System.out.print(cardRolls.get(i) + "  ");
      }
      System.out.println("");
      System.out.println("PLEASE use this page: " + calcHighestAvgRolls());
      twiceSubPrompt++;
    }else {
      System.out.println("Maybe you inputed something wrong?\n" + "Please try again.");
    }
  }
}