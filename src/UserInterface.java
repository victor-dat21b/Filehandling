import java.util.Scanner;
public class UserInterface {




    public static void main(String[] args) {
        new UserInterface().runTime();
    }


    public void runTime(){
        UserCreatorController myController = new UserCreatorController();
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the member handling program.");
        boolean programFlag = true;
        while (programFlag) {
            System.out.println("Do you wish to add member, remove member, look at the current members, or exit?\n" +
                    "Use the commands: add, remove, show members, exit.");
            String userInput = in.nextLine();



            if (userInput.equals("exit")) {
                programFlag = false;




            } else if (userInput.equals("add")) {
                StringBuilder myBuilder = new StringBuilder();
                System.out.println("To add a new member, you will now be asked to enter ID, name and password. Character @ and empty field not allowed. If used, you will be prompted to rewrite.");
                do {
                    System.out.println("What is the members ID?");
                    userInput = in.nextLine();
                }
                while((userInput.contains("@"))|| (userInput.isEmpty()) || (userInput.equals(" ")));
                myBuilder.append(userInput + "@");

                do {
                    System.out.println("What is the members name?");
                    userInput = in.nextLine();
                }
                while((userInput.contains("@"))|| (userInput.isEmpty()) || (userInput.equals(" ")));
                myBuilder.append(userInput + "@");

                do {
                    System.out.println("What is the members password?");
                    userInput = in.nextLine();
                }
                while((userInput.contains("@"))|| (userInput.isEmpty()) || (userInput.equals(" ")));
                myBuilder.append(userInput);
                myController.fileWriting(myBuilder.toString());
                System.out.println("New user added to file!");



            } else if (userInput.equals("remove")) {
                System.out.println("Type the ID of the member you wish to remove. To go back to the menu type back.");
                userInput = in.nextLine();
                if (userInput.equals("back")){
                }else {
                    try {
                        if (myController.memberDeletion(userInput)) {
                            System.out.println("Member successfully deleted.");
                        } else {
                            System.out.println("Member not found and could therefore not be deleted.");
                        }
                    }
                    catch(Exception e) {
                    }
                }


            } else if (userInput.equals("show members")) {
                try {
                    for (String i : myController.fileReading()) {
                        String[] arrOfStr = i.split("@");
                        System.out.println("Id: " + arrOfStr[0]);
                        System.out.println("Username: " + arrOfStr[1]);
                        System.out.println("Password: " + arrOfStr[2] + "\n");
                    }
                }
                catch (Exception e){
                }





            } else{
                System.out.println("Wrong input. Try again.");
            }




        }
    }



}
