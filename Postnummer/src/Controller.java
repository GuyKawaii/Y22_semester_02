import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public static void run(){
        ArrayList<PostInfo> postInfos = new ArrayList<>();

        try {
            Scanner fileScan = new Scanner(new File("C:\\Users\\DHI-LAP\\IdeaProjects\\Postnummer\\src\\liste.csv"));
            fileScan.useDelimiter("\t|\n");

            while (fileScan.hasNext()){
                String postNummer = fileScan.next();
                String by = fileScan.next();

                postInfos.add(new PostInfo(postNummer,by));
            }

        } catch (Exception e){

        }

        Scanner input = new Scanner(System.in);

        System.out.println("Enter postnummer:");

        String postNummerInput = input.nextLine();

        for (int i = 0; i < postInfos.size(); i++) {
            if (postInfos.get(i).getPostNummer().equals(postNummerInput)){
                System.out.println(i+1);
                System.out.println(postInfos.get(i).getBy());
        }
        }
    }
}
