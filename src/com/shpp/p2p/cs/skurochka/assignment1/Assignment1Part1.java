package com.shpp.p2p.cs.skurochka.assignment1;

public class Assignment1Part1 extends SuperKarel {
    // Karel's launch method.
    public void run() throws Exception {
        //The method of going to the newspaper from the start.
        goToTheNewspaper();
        //Newspaper lifting method.
        pickUpNewspaper();
        //The method of returning Karel to the starting position.
        turnToTheStartingPoint();
    }

    /*
     * The method of returning Karel to the starting position.
     * First, Karel turns back.
     * Then he walks straight to the wall.
     * Then he turns to the right.
     * Again he walks straight until he reaches the wall.
     * Then he turns to the right, which is his starting position.
     */
    private void turnToTheStartingPoint() throws Exception {
        turnAround();
        goToTheObstacle();
        turnRight();
        goToTheObstacle();
        turnRight();
    }

    /*
     * Newspaper lifting method.
     * Karel simply picks up Beeper.
     */
    private void pickUpNewspaper() throws Exception {
        pickBeeper();
    }

    /*
     * The method of going to the newspaper from the start.
     * At first, Karel goes straight to the wall.
     * Then he turns to the left.
     * Then Karel walks until he has the wall on his left.
     * Then he turns left. Then Karel walks until he comes across Beeper.
     * */
    private void goToTheNewspaper() throws Exception {
        goToTheObstacle();
        turnRight();
        while (leftIsBlocked()) {
            move();
        }
        turnLeft();
        while (noBeepersPresent()) {
            move();
        }
    }
}
