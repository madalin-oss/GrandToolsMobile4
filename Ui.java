package com.grandtools.mobile;
import android.content.*;import android.graphics.Color;import android.graphics.Typeface;import android.graphics.drawable.GradientDrawable;import android.view.*;import android.widget.*;
public class Ui {
 static final int BG=0xff101522,CARD=0xff1d2638,ACCENT=0xff48d7c4,TEXT=0xfff0f4ff;
 static GradientDrawable shape(int color,int radius){GradientDrawable d=new GradientDrawable();d.setColor(color);d.setCornerRadius(radius);return d;}
 static LinearLayout column(Context c){LinearLayout l=new LinearLayout(c);l.setOrientation(1);l.setPadding(16,16,16,16);l.setBackgroundColor(BG);return l;}
 static TextView text(Context c,String s,int size){TextView t=new TextView(c);t.setText(s);t.setTextColor(TEXT);t.setTextSize(size);t.setPadding(8,12,8,12);return t;}
 static Button button(Context c,String s){Button b=new Button(c);b.setText(s);b.setTextColor(BG);b.setAllCaps(false);b.setBackground(shape(ACCENT,18));return b;}
 static String[] names={"Приветствие","Предупреждение","Телепорт","Ответ в репорт"};
 static String[] defaults={"Здравствуйте! Чем могу помочь?","Пожалуйста, соблюдайте правила сервера.","/tp ","Здравствуйте! Ваш репорт принят."};
 static String command(Context c,int i){return c.getSharedPreferences("commands",0).getString("c"+i,defaults[i]);}
}
