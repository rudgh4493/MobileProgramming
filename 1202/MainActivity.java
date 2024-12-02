package com.example.a1202;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

//009 04 05 06 07 08 09
public class MainActivity extends AppCompatActivity {
    TextView textview_fontstyle;
    EditText edittext_memo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview_fontstyle=findViewById(R.id.textview_fontstyle);
        edittext_memo=findViewById(R.id.edittext_memo);
        popupmenu_job();
    }
    private void popupmenu_job() {
        PopupMenu popupMenu=new PopupMenu(this, textview_fontstyle);
        getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
@Override
        public boolean onMenuItemClick(MenuItem item) {
            if(item.getItemId()==R.id.popupmenu_italic){
                edittext_memo.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
            }
            else if(item.getItemId()==R.id.popupmenu_bold){
                edittext_memo.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            }
            else if(item.getItemId()==R.id.popupmenu_normal){
                edittext_memo.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }
            return true;
            }
        });
        textview_fontstyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
            }
        });
    }
}
