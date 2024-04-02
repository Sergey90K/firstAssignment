package com.shpp.p2p.cs.skurochka.assignment1;

public class Assignment1Part4 extends SuperKarel {
    // Karel's launch method.
    public void run() throws Exception {
        // The method of checking all possible boundary conditions and their fulfillment.
        checkAndMeetTheBoundaryConditions();
        // Starting a loop that performs a sequence of actions if there are no obstacles in front of Karel.
        while (frontIsClear()) {
            // The method of building the first line of the chessboard.
            lineStartingAtTheFirstCell();
            // The method of jumping to the beginning of the constructed line.
            goBackAlongTheLine();
            // The method of going to the next line.
            moveToTheNextLine();
            // The method of building the second line of the chessboard.
            lineStartingAtTheSecondCell();
            // The method of jumping to the beginning of the constructed line.
            goBackAlongTheLine();
            // The method of going to the next line.
            moveToTheNextLine();
        }
    }

    /*
     * The method of checking all possible boundary conditions and their fulfillment.
     * It consists of three method.
     * The method of checking whether the world consists of a single cell.
     * The method of checking whether the world width of a single cell exceeds the width of the cell.
     * The method of checking if the height of the world does not exceed one cell.
     */
    private void checkAndMeetTheBoundaryConditions() throws Exception {
        caseOfMinimalWorld();
        caseOfHighWorld();
        caseOfWideWorld();
    }

    /*
     * The method of building the first line of the chessboard.
     * First, one beeper is placed.
     * Then a cycle is started in which a sequence of actions is performed until there are no obstacles in front of Karel.
     * One step is performed in the cycle.
     * Then the condition is checked whether there are no obstacles in front of Karel.
     * If there are no obstacles, then one step is performed.
     * After that, one beeper is placed.
     */
    private void lineStartingAtTheFirstCell() throws Exception {
        putBeeper();
        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
    }

    /*
     * The method of jumping to the beginning of the constructed line.
     * A check is made to see if Karel is looking east.
     * If so, the sequence of actions continues.
     * Karel turns back around.
     * Then he walks straight towards the obstacle.
     * Karel turns to the right.
     */
    private void goBackAlongTheLine() throws Exception {
        if (facingEast()) {
            turnAround();
            goToTheObstacle();
            turnRight();
        }
    }

    /*
     * The method of going to the next line.
     * The condition is checked, if there is no obstacle in front of Karel, then the sequence of actions is performed.
     * One step is performed.
     * Then Karel turns to the right.
     */
    private void moveToTheNextLine() throws Exception {
        if (frontIsClear()) {
            move();
            turnRight();
        }
    }

    /*
     * The method of jumping to the beginning of the constructed line.
     * A loop is started that runs until there are no obstacles in front of Karel, which performs a sequence of actions.
     * Makes one step.
     * Places one beeper.
     * The condition is checked if there is no obstacle in front of Karel.
     * If there is no obstacle, one step is performed.
     */
    private void lineStartingAtTheSecondCell() throws Exception {
        while (frontIsClear()) {
            move();
            putBeeper();
            if (frontIsClear()) {
                move();
            }
        }
    }

    /*
     * The method of checking whether the world consists of a single cell.
     * It checks whether there are obstacles in front, to the left and to the right of the Karel.
     * If so, it is additionally checked whether there are any beepers under the Karel.
     * If there is no beeper under it, a single beeper is placed.
     */
    private void caseOfMinimalWorld() throws Exception {
        if (frontIsBlocked() && leftIsBlocked() && rightIsBlocked()) {
            if (noBeepersPresent()) {
                putBeeper();
            }
        }
    }

    /*
     * The method of checking whether the world width of a single cell exceeds the width of the cell.
     * The condition is checked to see if there are obstacles in front of Karel and on the right, and no obstacles on the left.
     * If the condition is met, then a left turn is made.
     * Then the method "lineStartingAtTheFirstCell()" is executed, which builds the first line of the chessboard.
     */
    private void caseOfHighWorld() throws Exception {
        if (frontIsBlocked() && leftIsClear() && rightIsBlocked()) {
            turnLeft();
            lineStartingAtTheFirstCell();
        }
    }

    /*
     * The method of checking if the height of the world does not exceed one cell.
     * Checks if there are no obstacles in front of the Karel, and if there are obstacles on the right and left.
     * If the condition is met, then the "lineStartingAtTheFirstCell()" method is executed,
     *  which builds the first line of the chessboard.
     */
    private void caseOfWideWorld() throws Exception {
        if (frontIsClear() && leftIsBlocked() && rightIsBlocked()) {
            lineStartingAtTheFirstCell();
        }
    }

/*
//    The code that implements a different construction logic is saved for your own use only.
//    It is available for informational purposes only.

    private void solutionOptimizedForEquilateralWorlds() throws Exception {
        drawCentralDiagonal();
        finishDrawingHalfOfTheBoard();
        goToDiagonalStart();
        finishDrawingHalfOfTheBoard();
    }

    private void finishDrawingHalfOfTheBoard() throws Exception {
        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeperOnTheDiagonal();
                returnDiagonally();
            }
        }
    }

    private void goToDiagonalStart() throws Exception {
        turnLeft();
        goToTheObstacle();
        turnLeft();
    }

    private void drawCentralDiagonal() throws Exception {
        putBeeperOnTheDiagonal();
        returnDiagonally();
    }

    private void returnDiagonally() throws Exception {
        turnRight();
        while (frontIsClear()) {
            move();
            turnRight();
            move();
            turnLeft();
        }
        turnLeft();
    }

    private void putBeeperOnTheDiagonal() throws Exception {
        if (noBeepersPresent()) {
            putBeeper();
        }
        while (frontIsClear() && leftIsClear()) {
            move();
            turnLeft();
            if (frontIsClear()) {
                move();
                turnRight();
                if (noBeepersPresent()) {
                    putBeeper();
                }
            }
        }
    }
*/
}