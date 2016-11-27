import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by itslehcim on 11/23/2016.
 */
public class Project2 {

    public static void main(String args[]){

        BufferedReader inFile;
        String line;

        //looks for file called project2.txt
        try(FileReader file = new FileReader("project2.txt")){
            //reads entire file
            inFile = new BufferedReader(file);
            //separates file by line
            while((line = inFile.readLine())!= null){
                ///print original line
                //send line to inToPost
                System.out.println(line);
                inToPost text = new inToPost(line);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
