import java.util.*;

public class Lab02 {
    public static void main(String[] args) {
        Scanner var = new Scanner(System.in);

        System.out.println("Please enter the number");
        int n = var.nextInt();

        String s [] = new String[n];

        for (int i = 0; i < s.length; i++) {
            System.out.println("Please enter address:");
            s[i] = var.next();
        }

        Stack<Integer> Web = new Stack<Integer>();
        Stack<Integer> Mail = new Stack<Integer>();

        int checker = 0;
        for (int i = 0; i<n; i++) {

            if (s[i].startsWith("www.") && s[i].endsWith(".com")) {
                String web1 [] = s[i].split("\\.");
                char w [] = web1[1].toCharArray();

                for (int j = 0; j < web1.length; j++) {
                    int a = (int) w[j];
                    if ((a > 64 && a < 91) || (a > 96 && a < 123) || (a > 47 && a < 58))
                        checker=0;
                    else
                        checker++;

                    if (checker == 0)
                        Web.push(i);
                    else
                        checker = 0;

                }
            }//end of web checker

            else if(s[i].contains("@") && s[i].endsWith(".com")) {
                Mail.push(i);
            }

        }
        System.out.print("Mail, ");
        for(int k =1; k<=Mail.size(); k++){// print Mail
            System.out.print(Mail.pop()+1);
        }

        System.out.println();

        System.out.print("Web, ");
        for(int j = 1; j<Web.size(); j++){//Print web input
            System.out.print(Web.pop()+1);
        }
    }
}