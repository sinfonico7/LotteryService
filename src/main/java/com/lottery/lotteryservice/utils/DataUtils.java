package com.lottery.lotteryservice.utils;

import java.util.concurrent.ThreadLocalRandom;

public class DataUtils {

    public static int  randomValue(int min,int maxInclusive){
        return ThreadLocalRandom.current().nextInt(min, maxInclusive + 1);
    }
}
