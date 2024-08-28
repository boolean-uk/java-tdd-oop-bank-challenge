package com.booleanuk.core.idgenerator;

public class IdGenerator {

    // Resource: https://www.freecodecamp.org/news/static-variables-in-java/
    private static int currentAC = 0;
    private static int currentRE = 0;
    private static int currentTR = 0;

    private IdPrefix prefix;
    private String id;

    public IdGenerator() {
        // Reset
        currentAC = 0;
        currentRE = 0;
        currentTR = 0;
    }

    private void setId(int currentNumber) {
        this.id = prefix + "_" + currentNumber;
    }

    public String getId() {
        return this.id;
    }

    public String createId(IdPrefix prefix) {

        // TODO: Duplication, could be improved?

        this.prefix = prefix;

        if (prefix == IdPrefix.AC) {
            currentAC++;
            setId(currentAC);
        } else if (prefix == IdPrefix.RE) {
            currentRE++;
            setId(currentRE);
        } else if (prefix == IdPrefix.TR) {
            currentTR++;
            setId(currentTR);
        }

        return this.id;
    }
}
