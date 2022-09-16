import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public static void run() {
        ArrayList<PostInfo> postInfos = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        // load csv
        try {
            Scanner file = new Scanner(new File("src/liste.csv"));
            file.useDelimiter(";|\n");

            while (file.hasNext()) {
                String postNummer = file.next();
                String by = file.next();

                postInfos.add(new PostInfo(postNummer, by));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.print("Enter postnummer:");
        String postNummerInput = input.nextLine();

        for (int i = 0; i < postInfos.size(); i++) {
            if (postInfos.get(i).getPostNummer().equals(postNummerInput)) {
                System.out.println(i + 1);
                System.out.println(postInfos.get(i).getBy());
            }
        }
    }

    public static void main(String[] args) {
        Controller.run();
    }
}
