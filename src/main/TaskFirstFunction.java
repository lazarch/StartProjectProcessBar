package main;

import java.util.logging.Logger;

class TaskFirstFunction implements Runnable {
    private Logger logger;
    private ProcessBarFrame frameProceccBar;

    TaskFirstFunction(Logger logger, ProcessBarFrame frameProceccBar) {
        this.logger = logger;
        this.frameProceccBar = frameProceccBar;
    }

    private void go() throws ClassNotFoundException {
        for (int i = 10; i >0; i--) {
            try {
                frameProceccBar.getBarProcess().setString("...осталось "+i+" секунд");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        if (logger != null) {
            logger.info("TaskFirstFunction: start");
        }
        try {
            go();
            System.exit(0);
        } catch (ClassNotFoundException e) {
            logger.info(e.getMessage());
        }
    }
}
