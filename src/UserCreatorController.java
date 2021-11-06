import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class UserCreatorController {



    public ArrayList<String> fileReading(){
    try {
        File myFile = new File("myMembers.txt");
        Scanner myReader = new Scanner(myFile);
        ArrayList<String> myArray = new ArrayList<>();
        while(myReader.hasNextLine()){
            myArray.add(myReader.nextLine());
        }
        myReader.close();
        return myArray;
    }
    catch (FileNotFoundException e){
        System.out.println("Error, file not found. (UserCreatorController try statement -reading)");
    return null;
    }

    }

    public void fileWriting(String myString){
        try {
            File myFile = new File("myMembers.txt");
            FileWriter myWriter = new FileWriter((myFile), true);
            myWriter.write(myString);
            myWriter.write("\n");
            myWriter.close();

        }
        catch (IOException e){
            System.out.println("Error, file not found. (UserCreatorController try statement -writing)");

        }

    }

    public boolean memberDeletion(String userInput){
        boolean methodState = false;
        ArrayList<String> myArray = new ArrayList<>();
        for (String i : fileReading()) {
            String[] arrOfStr = i.split("@");
            if(arrOfStr[0].equals(userInput)){
                methodState = true;
            } else {
                myArray.add(i);
            }
            if (methodState){
                fileOverwriting(myArray);
            }
    }
    return methodState;
    }



    public void fileOverwriting(ArrayList<String> myArray){
        try {
            File myFile = new File("myMembers.txt");
            FileWriter myWriter = new FileWriter((myFile));
            for(String i : myArray) {
                myWriter.write(i);
                myWriter.write("\n");
            }
            myWriter.close();

        }
        catch (IOException e){
            System.out.println("Error, file not found. (UserCreatorController try statement -overwriting)");

        }
    }

}
