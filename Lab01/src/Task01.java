import java.util.*;
import java.io.File;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.LinkedHashSet;

public class Task01{
    public static void main (String [] args){

        String kw="abstract|assert|boolean|break|catch|char|continue|default|do|double|else|float|for|if|implements|import|" +
                        "int|long|package|private|public|return|static|throw|throws|try|var|void|while";

        String id = "[A-Za-z][A-Za-z0-9_]*";
        String mo = "\\+|-|\\*|/|=";
        String lo = ">|<|=>|==|=<";
        String nv = "[-+]?[0-9]*\\.?[0-9]+";
        String ot = ".*[{|}|;|,|/(|/)].*";

        Set<String> keyWords = new HashSet<String>();
        Set<String> identifiers = new HashSet<String>();
        Set<String> mathOperators = new HashSet<String>();
        Set<String> logicalOperators = new HashSet<String>();
        Set<String> numericalValues = new HashSet<String>();
        Set<String> others = new HashSet<String>();

        try{
            File input = new File("E:\\SEMESTER\\Spring- 21\\CSE420 Compiler Design\\420LAB01\\input.txt");
            Scanner sc = new Scanner(input);

            String st="";
            while(sc.hasNextLine()){

                String st1 = "";
                st1+= sc.nextLine();
                String array[] = st1.split("");

                for(int i = 0; i<array.length; i++){
                    String temp =""+array[i];

                    if(temp.matches(mo)){
                        mathOperators.add(temp);
                        st+= " ";
                    }

                    else if(temp.equals("\t"))
                        st += "";

                    else if(temp.matches(lo)) {
                        logicalOperators.add(temp);
                        st+= " ";
                    }

                    else if(temp.matches(ot)){
                        others.add(temp);
                        st+= " ";
                    }

                    else
                        st+= temp;

                }
            }//end of while

            String array1[] = st.split(" ");

            for(int i = 0; i<array1.length; i++){
                String temp1 = array1[i];

                if(temp1.matches(kw))
                        keyWords.add(temp1);

                else if(temp1.matches(nv))
                    numericalValues.add(temp1);

                else if(temp1.matches(id))
                    identifiers.add(temp1);

            }

            System.out.print("Keywords: ");
            System.out.println(keyWords.toString());

            System.out.print("Identifiers: ");
            System.out.println(identifiers.toString());

            System.out.print("Math Operators: ");
            System.out.println(mathOperators.toString());

            System.out.print("Logical Operators: ");
            System.out.println(logicalOperators.toString());

            System.out.print("Numerical Values: ");
            System.out.println(numericalValues.toString());

            System.out.print("Others: ");
            System.out.println(others.toString());

        }// end of try
        catch (Exception e) {
            System.out.println("Empty!");
        }

    }
}