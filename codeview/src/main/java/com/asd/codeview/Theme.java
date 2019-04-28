package com.asd.codeview;

import android.content.Context;
import android.support.v4.content.ContextCompat;

public class Theme {
    private int backgroundColor;
    private int keywordsColor;
    private int numberColor;
    private int specialCharColors;
    private int printStatmentsColor;
    private int annotationsColor;
    private int lineColor;
    private int codeColor;
    public Theme(Context context){
        setBackgroundColor(ContextCompat.getColor(context,R.color.background));
        setkeywordsColor(ContextCompat.getColor(context,R.color.keyword));
        setNumberColor(ContextCompat.getColor(context,R.color.number));
        setSpecialCharColors(ContextCompat.getColor(context,R.color.special));
        setPrintStatmentsColor(ContextCompat.getColor(context,R.color.string));
        setAnnotationsColor(ContextCompat.getColor(context,R.color.anootation));
        setLineColor(ContextCompat.getColor(context,R.color.lines));
        setCodeColor(ContextCompat.getColor(context,R.color.code));
    }
    public Theme(Context context,int backgroundColor, int keywordsColor, int numberColor, int specialCharColors, int printStatmentsColor, int annotationsColor,int lineColor,int codeColor){
        setBackgroundColor(backgroundColor);
        setkeywordsColor(keywordsColor);
        setNumberColor(numberColor);
        setSpecialCharColors(specialCharColors);
        setPrintStatmentsColor(printStatmentsColor);
        setAnnotationsColor(annotationsColor);
        setLineColor(lineColor);
        setCodeColor(codeColor);
    }
    public void setBackgroundColor(int color){
        backgroundColor=color;
    }
    public void setkeywordsColor(int color){
        keywordsColor=color;
    }
    public void setNumberColor(int color){
        numberColor=color;
    }
    public void setSpecialCharColors(int color){
        specialCharColors=color;
    }
    public void setPrintStatmentsColor(int color){
        printStatmentsColor=color;
    }
    public void setAnnotationsColor(int color){
        annotationsColor=color;
    }
    public void setLineColor(int color){
        lineColor=color;
    }
    public void setCodeColor(int color){
        codeColor=color;
    }

    public int getBackgroundColor(){
        return backgroundColor;
    }
    public int getKeywordsColor(){
        return keywordsColor;
    }
    public int getNumberColor(){
        return numberColor;
    }
    public int getSpecialCharColors(){
        return specialCharColors;
    }
    public int getPrintStatmentsColor(){
        return printStatmentsColor;
    }
    public int getAnnotationsColor(){
        return annotationsColor;
    }
    public int getLineColor(){
        return lineColor;
    }
    public int getCodeColor(){
        return codeColor;
    }
}
