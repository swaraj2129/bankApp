package main;
import registeration.AfterLogin;
import registeration.FileReadController;
import registeration.ManualDisplayView;
import registeration.Register;
import PropertiesFileRead.FileRead;

import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private final static Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        Main start = new Main();
        ArrayList<Register> reg = new ArrayList<>();
        ArrayList<AfterLogin> loginArray = new ArrayList<>();

        Scanner sc= new Scanner(System.in);

        int sel;
        do {
            logger.info("Select 1 for manual input\nSelect 2 for input from file");
            sel = sc.nextInt();
            if (sel == 1) {
                start.manualOptionDisplay(reg,loginArray);
            } else if (sel == 2) {
                start.fileOptionDisplay(reg,loginArray);
            } else {
                logger.info("INCORRECT OPTION SELECTED");
            }
        }while (sel<2);


    }
    private void fileOptionDisplay(ArrayList<Register> reg,ArrayList<AfterLogin>loginArray) {
        FileReadController controller = new FileReadController();
        controller.fileRead(reg,loginArray);
    }

    private void manualOptionDisplay(ArrayList<Register> reg,ArrayList<AfterLogin>loginArray) {
        ManualDisplayView userView =  new ManualDisplayView();
        userView.display(reg,loginArray);
    }
}