package com.randreucetti.advent.day2;

import java.util.Arrays;
import java.util.Collections;

/**
 * @see <a href="http://adventofcode.com/day/2<">http://adventofcode.com/day/2</a>
 */
public class WrappingPaper {
    public static int getArea(int l, int w, int h) {
        int area = 2 * l * w + 2 * w * h + 2 * l * h;
        int slack = Collections.min(Arrays.asList(l * w, w * h, h * l));
        return area + slack;
    }

    public static int getRibbonLen(int l, int w, int h) {
        int ribbon = 2 * Collections.min(Arrays.asList(l + w, w + h, l + h));
        int bow = l * w * h;
        return ribbon + bow;
    }
}
