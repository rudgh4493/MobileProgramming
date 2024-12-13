package com.example.a1213;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;


class DBHelper2 extends SQLiteOpenHelper {
    public DBHelper2(Context context) {
        super(context, "memo.db", null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TB_memo (datetime TEXT, memo TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// 이전 버전 데이터 유지 필요시 이전 절차 필요db.execSQL("DROP TABLE IF EXISTS TB_memo");
        onCreate(db);
    }
    public void insert(String memo) {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("INSERT INTO TB_memo VALUES ('"+System.currentTimeMillis()+"','"+memo+"');");
        db.close();
    }
    public void select(EditText edittext_display) {
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT datetime, memo FROM TB_memo;", null);
        edittext_display.setText("[TB_memo 내용]\n");
        while(cursor.moveToNext()){
            edittext_display.append(cursor.getString(0)+","+cursor.getString(1)+"\n");
        }
        db.close();
    }
}