package com.shpp.p2p.cs.skurochka.assignment1;

import com.shpp.karel.KarelTheRobot;

public class SuperKarel extends KarelTheRobot {
    // Karel's left turn method.
    // Make 3 turns to the left.
    protected void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    // Karel's reverse rotation method.
    // Make 2 turns to the left.
    protected void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    // Go straight to the wall method.
    // The cycle is executed until there are no obstacles in front of Karel.
    // A step is executed in the cycle.
    protected void goToTheObstacle() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }
}
