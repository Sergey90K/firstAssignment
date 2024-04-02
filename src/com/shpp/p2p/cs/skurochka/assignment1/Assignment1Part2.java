package com.shpp.p2p.cs.skurochka.assignment1;

public class Assignment1Part2 extends SuperKarel {
    // Karel's launch method.
    public void run() throws Exception {
        // Start the action sequence until there are no obstacles in front of Carl.
        while (frontIsClear()) {
            // The method of building a column from the bottom.
            buildPillarFromDown();
            // Returning down after building a pillar.
            returnToTheBeginning();
            // Move to the next pillar construction site.
            toGoToTheNextStop();
        }
        // The method of building the last column that is located at the end of the world.
        buildTheLastPilar();
    }

    /*
     * The method of building a column from the bottom.
     * First, Karel turns to the left.
     * Then the robot starts and performs a sequence of actions until there is no obstacle in front of Karel.
     * The loop checks whether there is a beeper under the Karel, and if there is not, it will be added to this cell.
     * Then one step is completed.
     * After the loop is completed, it checks whether there is a beeper under Karel, and if there is not, it will be added to this cell.
     */
    private void buildPillarFromDown() throws Exception {
        turnLeft();
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
            }
            move();
        }
        if (noBeepersPresent()) {
            putBeeper();
        }
    }

    /*
     * Returning down after building a pillar.
     * Karel turns back around.
     * Karel walks straight into the obstacle.
     * Then he turns left.
     */
    private void returnToTheBeginning() throws Exception {
        turnAround();
        goToTheObstacle();
        turnLeft();
    }

    /*
     * Move to the next pillar construction site.
     * A cycle is started that will execute internal actions 4 times.
     * The cycle checks whether there are any obstacles in front of Karel,
     * and if there is no obstacle, one step is performed.
     */
    private void toGoToTheNextStop() throws Exception {
        for (int i = 0; i < 4; i++) {
            if (frontIsClear()) {
                move();
            }
        }
    }

    /*
     * The method of building the last column that is located at the end of the world.
     * All events of the 'buildPillarFromDown()' method are executed.
     * First, Karel turns to the left.
     * Then the robot starts and performs a sequence of actions until there is no obstacle in front of Karel.
     * The loop checks whether there is a beeper under the Karel, and if there is not, it will be added to this cell.
     * Then one step is completed.
     * After the loop is completed, it checks whether there is a beeper under Karel, and if there is not, it will be added to this cell.
     */
    private void buildTheLastPilar() throws Exception {
        buildPillarFromDown();
    }

/*
//    The code that implements a different construction logic is saved for your own use only.
//    It is available for informational purposes only.

    private void solutionForEqualColumns() throws Exception {
        goToTheBasePillar();
        while (leftIsBlocked() && frontIsClear()) {
            createPillarAndReturn();
        }
        createPillarAndReturn();
    }

    private void createPillarAndReturn() throws Exception {
        buildPillarFromTop();
        goToTheBasePillar();
        goToTheNextPillar();
    }

    private void buildPillarFromTop() throws Exception {
        turnRight();
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
            }
            move();
            if (noBeepersPresent()) {
                putBeeper();
            }
        }
        turnLeft();
    }

    private void goToTheBasePillar() throws Exception {
        turnLeft();
        goToTheObstacle();
        turnRight();
    }

    private void goToTheNextPillar() throws Exception {
        if (frontIsClear()) {
            move();
        }
        while (leftIsClear()) {
            move();
        }
    }
*/
}