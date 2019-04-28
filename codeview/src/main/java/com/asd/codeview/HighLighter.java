package com.asd.codeview;

import android.graphics.Color;
import java.util.regex.Pattern;
/**
 * Created by TOSHIBA on 6/25/2018.
 */
class HighLighter {
    Pattern pattern;
    int color;

    public  HighLighter (Pattern pattern) {
        this.pattern = pattern;
    }

    public void setColor(int color){
        this.color =color;
    }
}
