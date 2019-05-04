package com.asd.codeview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * SyntaxCode. paint color at edittext.
 * it customized from Syntax-View-Android
 * orginal is made by Badranh.
 * https://github.com/Badranh/Syntax-View-Android
 */
public class CodeView extends ScrollView {
    private EditText code;
    private TextView line;
    private LinearLayout bg;
    private Theme theme;
    private int fontPX=50;
    private int leftPX=50;
    private int W=0,H=0;

    private  HighLighter  keywords = new  HighLighter (
            Pattern.compile(
                    "\\b(include|package|transient|strictfp|void|char|short|int|long|double|float|const|static|volatile|byte|boolean|class|interface|native|private|protected|public|final|abstract|synchronized|enum|instanceof|assert|if|else|switch|case|default|break|goto|return|for|while|do|continue|new|throw|throws|try|catch|finally|this|extends|implements|import|true|false|null)\\b"));
    private  HighLighter  annotations = new  HighLighter (
            Pattern.compile(
                    "@Override|@Callsuper|@Nullable|@Suppress|@SuppressLint|super"));
    private  HighLighter  numbers = new  HighLighter (
            Pattern.compile("(\\b(\\d*[.]?\\d+)\\b)")
    );
    private  HighLighter  special = new  HighLighter (
            Pattern.compile("[;#]")
    );
    private  HighLighter  printStatments = new  HighLighter (
            Pattern.compile("\"(.+?)\"")
    );
    private  HighLighter [] schemes = {keywords, numbers, special, printStatments, annotations};
    public CodeView(Context context) {
        super(context);
        theme=new Theme(context);
        initialize(context);
    }
    public CodeView(Context context,AttributeSet attrs) {
        super(context,attrs);
        theme=new Theme(context);
        initialize(context);
    }
    public CodeView(Context context, int BackgroundColor, int keywordsColor, int NumberColor, int specialCharColors, int printStatmentsColor, int annotationsColor,int lineColor,int codeColor) {
        super(context);
        theme=new Theme(context, BackgroundColor, keywordsColor, NumberColor, specialCharColors,printStatmentsColor, annotationsColor,lineColor,codeColor);
        initialize(context);
    }
    private void initialize(Context context) {
        inflate(context, R.layout.layout, this);
        bg=findViewById(R.id.bg);
        line=findViewById(R.id.line_text);
        code=findViewById(R.id.body_text);
        Point p=new Point();
        WindowManager manager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        display.getSize(p);
        W=p.x;
        H=p.y;

        setBgColor(theme.getBackgroundColor());
        setKeywordsColor(theme.getKeywordsColor());
        setNumbersColor(theme.getNumberColor());
        setSpecialCharsColor(theme.getSpecialCharColors());
        setPrintStatmentsColor(theme.getPrintStatmentsColor());
        setAnnotationsColor(theme.getAnnotationsColor());

        line.setTextSize(TypedValue.COMPLEX_UNIT_PX,fontPX);
        code.setTextSize(TypedValue.COMPLEX_UNIT_PX,fontPX);
        code.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            //check code lines every change.
            @Override
            public void afterTextChanged(Editable s) {
                drawLine(s.toString());
                paint(s);
            }
        });
        setTheme();
    }
    public void insertText(String text)
    {
        int s = Math.max(code.getSelectionStart(), 0);
        int e = Math.max(code.getSelectionEnd(), 0);
        code.getText().replace(Math.min(s, e), Math.max(s, e), text, 0, text.length());
        if(text.equals("( )")||text.equals("[]")||text.equals("< >")||text.equals(";\n")) {
            code.setSelection(s+1);
        }
        if(text.equals("{\n\n}")) {
            code.setSelection(s+2);
        }
    }
    public void drawLine(String str){
        String nstr = "1\n";
        int count = 2;
        String[] lines = str.split("\n");
        leftPX=(int)(Math.log10(lines.length+1)+1)*fontPX;
        for (int i = 0; i < lines.length; i++) {
            int len=lines[i].length()*fontPX;
            while(len+leftPX>W){
                nstr+='\n';
                len-=W-leftPX;
            }
            nstr += String.valueOf(count) + '\n';
            count++;
        }

        line.setWidth(leftPX);
        line.setText(nstr);
    }
    public void paint(Editable s){
        removeSpans(s, ForegroundColorSpan.class);
        for ( HighLighter  scheme : schemes) {
            for (Matcher m = scheme.pattern.matcher(s); m.find(); ) {
                s.setSpan(new ForegroundColorSpan(scheme.color),
                        m.start(),
                        m.end(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }
    //remove old highlighting
    public void removeSpans(Editable e, Class<? extends CharacterStyle> type) {
        CharacterStyle[] spans = e.getSpans(0, e.length(), type);
        for (CharacterStyle span : spans) {
            e.removeSpan(span);
        }
    }
        //the user will be able to change color of the view as he wishes
    public void setBgColor(int color) {
         code.setBackgroundColor(color);
    }

    public void setKeywordsColor(int color) {
        keywords.setColor(color);
    }

    public void setNumbersColor(int color) {
        numbers.setColor(color);
    }

    public void setSpecialCharsColor(int color) {
        special.setColor(color);
    }

    public void setCodeTextColor(int color) {
        code.setTextColor(color);
    }

    public void setAnnotationsColor(int color) {
        annotations.setColor(color);
    }

    public void setPrintStatmentsColor(int color) {
        printStatments.setColor(color);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("onConfigurationChanged" , "onConfigurationChanged");
        int t=W;
        W=H;
        H=t;
        try {
            drawLine(code.getText().toString());
        }catch (Exception e){
        }
    }
    private boolean checkValidity(String s) {
        Stack stackCheck = new Stack();
        char[] valid = s.toCharArray();
        for (int i = 0; i < valid.length; i++) {
            if (valid[i] == '{' || valid[i] == '(') {
                stackCheck.push((valid[i]));
            }
            if (valid[i] == '}' || valid[i] == ')') {
                if (stackCheck.empty()) {
                    return false;
                } else {
                    if (!matchPair((char) stackCheck.peek(), valid[i])) {
                        return false;
                    }
                    stackCheck.pop();
                }
            }
        }
        if (stackCheck.size() == 1) {
            return false;
        }
        return true;
    }

    private boolean matchPair(char c1, char c2) {
        if (c1 == '(' && c2 == ')')
            return true;
        else if (c1 == '{' && c2 == '}')
            return true;
        else if (c1 == '[' && c2 == ']')
            return true;
        else
            return false;
    }
    public void setTheme(){
        bg.setBackgroundColor(theme.getBackgroundColor());
        line.setBackgroundColor(theme.getBackgroundColor());
        line.setTextColor(theme.getKeywordsColor());
        code.setBackgroundColor(theme.getBackgroundColor());
        code.setTextColor(theme.getCodeColor());
        code.setHintTextColor(theme.getCodeColor());
    }
    public boolean checkMyCode() {
        return checkValidity(code.getText().toString());
    }
    public void setText(String str){
        code.setText(str);
    }
    public String getText(){
        return code.getText().toString();
    }
}
