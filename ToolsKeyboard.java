package com.grandtools.mobile;
import android.inputmethodservice.InputMethodService;import android.view.*;import android.view.inputmethod.InputConnection;import android.widget.*;
public class ToolsKeyboard extends InputMethodService {
 LinearLayout base;
 void key(LinearLayout row,String label,String value,int weight){Button b=Ui.button(this,label);LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(0,54,weight);p.setMargins(2,2,2,2);row.addView(b,p);b.setOnClickListener(v->{InputConnection ic=getCurrentInputConnection();if(ic==null)return;if(value.equals("DEL"))ic.deleteSurroundingText(1,0);else if(value.equals("ENTER"))ic.commitText("\n",1);else ic.commitText(value,1);});}
 @Override public View onCreateInputView(){base=Ui.column(this);base.setPadding(3,4,3,4);LinearLayout quick=new LinearLayout(this);base.addView(quick);for(int i=0;i<4;i++)key(quick,"★"+(i+1),Ui.command(this,i),1);String[] rows={"qwertyuiop","asdfghjkl","zxcvbnm"};for(String r:rows){LinearLayout line=new LinearLayout(this);base.addView(line);for(char ch:r.toCharArray())key(line,String.valueOf(ch),String.valueOf(ch),1);}LinearLayout last=new LinearLayout(this);base.addView(last);key(last,"⌫","DEL",1);key(last,"Пробел"," ",4);key(last,"↵","ENTER",1);return base;}
}
