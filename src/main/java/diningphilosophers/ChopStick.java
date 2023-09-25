package diningphilosophers;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {

    private static int stickCount = 0;

    private boolean iAmFree = true;
    private final int myNumber;
    private final Lock verrou = new ReentrantLock();

    public ChopStick() {
        myNumber = ++stickCount;
    }

    public boolean Trytake(int delay) throws InterruptedException {
        if (verrou.tryLock()) {
                System.out.println("Stick " + myNumber + " Taken");
                return true;
        } else {
            return false;
        }
    }

    public void release() {
        try {
            System.out.println("Stick " + myNumber + " Released");
        } finally {
            verrou.unlock();
        }
    }


    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
