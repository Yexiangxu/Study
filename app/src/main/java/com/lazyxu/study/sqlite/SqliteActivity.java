package com.lazyxu.study.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.lazyxu.study.R;

/**
 * User: Lazy_xu
 * Data: 2019/07/02
 * Description:
 * FIXME
 */
public class SqliteActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String LazySqlite = "LazySqliteHelper";
    //声明五个控件对象
    Button createDatabase = null;
    Button updateDatabase = null;
    Button insert = null;
    Button update = null;
    Button query = null;
    Button delete = null;
    Button updateDatabaseInsert;


    private void findViews() {
        //根据控件ID得到控件
        createDatabase = this.findViewById(R.id.createDatabase);
        updateDatabase = this.findViewById(R.id.updateDatabase);
        insert = this.findViewById(R.id.insert);
        update = this.findViewById(R.id.update);
        query = this.findViewById(R.id.query);
        delete = this.findViewById(R.id.delete);
        updateDatabaseInsert = this.findViewById(R.id.updateDatabase_insert);
        //添加监听器
        createDatabase.setOnClickListener(this);
        updateDatabase.setOnClickListener(this);
        insert.setOnClickListener(this);
        update.setOnClickListener(this);
        query.setOnClickListener(this);
        delete.setOnClickListener(this);
        updateDatabaseInsert.setOnClickListener(this);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        findViews();
    }

    private SQLiteDatabase mDB = null;
    @Override
    public void onClick(View v) {
        //判断所触发的被监听控件，并执行命令
        switch (v.getId()) {
            //创建数据库
            case R.id.createDatabase:
                LazySqliteHelper dbHelper = new LazySqliteHelper(SqliteActivity.this);
                mDB= dbHelper.getReadableDatabase();
                break;
            //更新数据库
            case R.id.updateDatabase:
                LazySqliteHelper dbHelper2 = new LazySqliteHelper(SqliteActivity.this,2);
                mDB=dbHelper2.getReadableDatabase();
                break;
            case R.id.updateDatabase_insert:
                ContentValues updateInsert = new ContentValues();
                updateInsert.put("age",18);
                mDB.beginTransaction();
                mDB.update("lazyuser", updateInsert, "id=?", new String[]{"1"});
                mDB.setTransactionSuccessful();
                mDB.endTransaction();
                break;
            //插入数据
            case R.id.insert:
                mDB.beginTransaction();
                //创建存放数据的ContentValues对象
                ContentValues values = new ContentValues();
                //像ContentValues中存放数据
                values.put("id", "1");
                values.put("name", "lazyxu");
                //数据库执行插入命令
                mDB.insert("lazyuser", null, values);
                mDB.setTransactionSuccessful();
                mDB.endTransaction();
                break;

            //更新数据信息
            case R.id.update:
                ContentValues values2 = new ContentValues();
                values2.put("name", "xiaosan");
                mDB.beginTransaction();
                mDB.update("lazyuser", values2, "id=?", new String[]{"1"});
                mDB.setTransactionSuccessful();
                mDB.endTransaction();
                break;
            //查询信息
            case R.id.query:
                mDB.beginTransaction();
                Cursor cursor = mDB.query("lazyuser", new String[]{"id", "name"}, "id=?", new String[]{"1"}, null, null, null, null);
                //利用游标遍历所有数据对象
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    //日志打印输出
                    Log.i(LazySqlite, "query-->" + name);
                }
                cursor.close();
                mDB.setTransactionSuccessful();
                mDB.endTransaction();
                break;
            //删除记录
            case R.id.delete:
                mDB.beginTransaction();
                mDB.delete("lazyuser", "id=?", new String[]{"1"});
                mDB.setTransactionSuccessful();
                mDB.endTransaction();
                break;
        }
    }
}

