import java.util.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LAB03 {
    public static void main (String [] args){

        try{

            File f = new File("E:\\SEMESTER\\Spring- 21\\CSE420LAB-03\\src\\input.txt");
            Scanner sc = new Scanner(f);
            int count_expression = sc.nextInt();
            String [] RE_expressions = new String[count_expression];

            for(int i = 0; i<RE_expressions.length; i++){
                RE_expressions[i] = sc.next();
            }

            int count_example = sc.nextInt();
            String [] RE_examples = new String[count_example];

            for(int i = 0; i<RE_examples.length; i++){
                RE_examples[i] = sc.next();
            }

            for(int i = 0; i<RE_examples.length; i++){
                boolean t = false;
                String example = RE_examples[i];
                int count = 0;

                for(int j = 0; j<RE_expressions.length; j++){
                    String pattern = RE_expressions[j];
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(example);

                    if(m.find()) {
                        count = j + 1;
                        t = true;
                        break;
                    }
                }//end of RE_expressions loop

                if(t==true)
                    System.out.println("Yes, " + count);

                else
                    System.out.println("No, 0");
            }// end of RE_example loop

        }//end try
        catch (Exception e){
            System.out.println(e);
        }
    }
}
