package com.shpp.p2p.cs.skurochka.assignment1;

public class Assignment1Part3 extends SuperKarel {
    // Karel's launch method.
    public void run() throws Exception {
        // Checking the boundary conditions (If the world is one cell wide). If so, the beeper is set.
        if (frontIsBlocked() && rightIsBlocked()) {
            putBeeper();
        } else {
            // The method of installing beepers diagonally.
            createDiagonal();
            // Moves to another corner from which a diagonal pass will be made.
            moveToAnotherCorner();
            // Perform a diagonal pass with Karel until you step on a beeper.
            findTheIntersectionOfTheDiagonals();
            // A method that lowers the Karel down to mark the middle of the world.
            markTheMiddle();
            // The method of returning Karel to the starting point.
            backToTheStart();
            // The method of removing diagonal beepers.
            removeDiagonalMarks();
        }
    }

    /*
     * The method of installing beepers diagonally.
     * A loop is started that performs a sequence of actions until there are no obstacles in front of Karel.
     * The first step is a beeper.
     * Then one step is performed.
     * Karel turns to the left.
     * One more step is taken.
     * Then he turns to the right.
     * After the cycle of these actions is completed, one beeper is placed.
     */
    private void createDiagonal() throws Exception {
        while (frontIsClear()) {
            putBeeper();
            move();
            turnLeft();
            move();
            turnRight();
        }
        putBeeper();
    }

    /*
     * Moves to another corner from which a diagonal pass will be made.
     * First, the Karel backward turn is performed.
     * Then the Karel goes straight to the obstacle.
     * Then the Karel performs a backward turn.
     */
    private void moveToAnotherCorner() throws Exception {
        turnAround();
        goToTheObstacle();
        turnAround();
    }

    /*
     * Perform a diagonal pass with Karel until you step on a beeper.
     * A loop is launched that performs a sequence of actions until there is no beeper under Karel.
     * The loop first executes one step.
     * Then the condition is checked whether there is no beeper under Karel.
     * If there is no beeper, then a right turn is performed.
     * Then one step is executed.
     * After that, Karel turns to the left.
     */
    private void findTheIntersectionOfTheDiagonals() throws Exception {
        while (noBeepersPresent()) {
            move();
            if (noBeepersPresent()) {
                turnRight();
                move();
                turnLeft();
            }
        }
    }

    /*
     * A method that lowers the Karel down to mark the middle of the world.
     * First, Karel turns to the right.
     * Then Karel goes straight to the obstacle.
     * At the end, he puts a beeper to mark the middle.
     */
    private void markTheMiddle() throws Exception {
        turnRight();
        goToTheObstacle();
        putBeeper();
    }

    /*
     * The method of returning Karel to the starting point.
     * First, Karel turns to the right.
     * Then he goes straight to the obstacle.
     * At the end, Karel turns back.
     */
    private void backToTheStart() throws Exception {
        turnRight();
        goToTheObstacle();
        turnAround();
    }

    /*
     * The method of removing diagonal beepers.
     * A loop is started that performs a sequence of actions until there are no obstacles in front of Karel and a beeper under him.
     * First, Karel picks up the beeper.
     * Then he takes one step.
     * Then he turns to the left.
     * Then he takes one step.
     * Karel turns to the right.
     * After the cycle is completed, the condition is checked to see if there is a beeper under Karel,
     * and if so, it is removed.
     */
    private void removeDiagonalMarks() throws Exception {
        while (frontIsClear() && beepersPresent()) {
            pickBeeper();
            move();
            turnLeft();
            move();
            turnRight();
        }
        if (beepersPresent()) {
            pickBeeper();
        }
    }
}
