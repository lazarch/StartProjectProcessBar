package main;

import javax.swing.*;
import java.util.Objects;
import java.util.logging.Logger;

import static utils.ConstantForAll.LS;
import static utils.UtilsForAll.*;

public class Main {
    private static Logger logger;

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Logger logger = setupLogger();
        if (logger == null){
            JOptionPane.showMessageDialog(null, "Ошибка установки логгера программы!" + LS +
                                                "Программа будет принудительно закрыта.");
            utils.UtilsForAll.exitFromProgram();
        }
        if (!setupProgramSettings(logger)){
            JOptionPane.showMessageDialog(null, "Ошибка файла настроек программы!" + LS +
                    "Программа будет принудительно закрыта.");
            utils.UtilsForAll.exitFromProgram();
        }

        ProcessBarFrame frameProcessBar = new ProcessBarFrame();
        Thread someThread = null;

        if (args.length == 0) {
            System.exit(0);
        } else if (Objects.equals(args[0], "-first")) {
            TaskFirstFunction taskFirstFunction = new TaskFirstFunction(logger, frameProcessBar);
            someThread = new Thread(taskFirstFunction);
        }
        if (someThread != null) {
            someThread.start();
        }

        frameProcessBar.setVisible(true);
    }
}
