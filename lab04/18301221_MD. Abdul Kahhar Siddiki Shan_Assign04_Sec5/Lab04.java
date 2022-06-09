import java.util.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Lab04 {
    public static void main(String [] args){
        try{
            File f = new File("E:\\SEMESTER\\Spring- 21\\CSE420 Compiler Design\\Lab solution\\lab04\\18301221_MD. Abdul Kahhar Siddiki Shan_Assign04_Sec5\\input.txt");
            Scanner sc = new Scanner(f);
            Pattern p = Pattern.compile("(public|protected|private)(\\s(static))* \\w+ \\w*\\(.*\\)");
            System.out.println("Methods:");
            while(sc.hasNext()) {
                String input = sc.nextLine();
                Matcher m = p.matcher(input);
                int startIndex = 0;
                if (m.find()) {
                    startIndex =  m.start();
                    String line = input.substring(startIndex);
                    //System.out.println(line);

                    String [] array = line.split(" ");
                    int array_index = 0;

                    if(array[1].equals("int") || array[1].equals("void"))
                        array_index = 1;
                    if(array[2].equals("int") || array[2].equals("void"))
                        array_index = 2;

                    Pattern p1 = Pattern.compile("\\w*\\(.*\\)");
                    Matcher m1 = p1.matcher(input);
                    if(m1.find()){
                        startIndex = m1.start();
                        String found = input.substring(startIndex);
                        String k1 = "main(String [] args)";
                        if (!found.equals(k1))
                            System.out.println(found+"  return type: "+array[array_index] );

                    }
                }//end of m.find()
            }//end of while
        }//end of try

        catch(Exception e){
            System.out.println(e);
        }
    }
}
