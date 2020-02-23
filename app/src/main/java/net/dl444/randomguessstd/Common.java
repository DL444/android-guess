package net.dl444.randomguessstd;

import java.util.Random;

class Common {
    static  {
        random = new Random(System.currentTimeMillis());
    }

    public static int getRandomNumber() {
        return random.nextInt(9999) + 1;
    }

    private static Random random;
}
