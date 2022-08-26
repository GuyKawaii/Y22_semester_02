package opgaver;

import java.util.Scanner;

public class TouchGrass {
  private Scanner scanner = new Scanner(System.in);
  private double maxGrassHeight;
  private double currentGrassHeight;
  
  public void grassPrompt() {
    do {
      System.out.println("current grass height?");
      currentGrassHeight = Double.parseDouble(scanner.nextLine());
  
      System.out.println("max grass height?");
      maxGrassHeight = Double.parseDouble(scanner.nextLine());
      
      System.out.printf("there are %d. days until the grass has to be cut%n",
          (int) Math.floor((maxGrassHeight-currentGrassHeight)/0.8));
      
    } while (true);
  }
  
  public static void main(String[] args) {
    new TouchGrass().grassPrompt();
  }
}
  
