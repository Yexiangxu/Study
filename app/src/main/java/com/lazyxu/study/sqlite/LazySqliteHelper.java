package com.lazyxu.study.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * User: Lazy_xu
 * Data: 2019/07/02
 * Description:
 * FIXME
 */
public class LazySqliteHelper extends SQLiteOpenHelper {
    private final static String LazySqlite = "LazySqliteHelper";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "lazyuser";
    private static final String TABLE_RENAME = "rename_lazyuser";
    private static final String DB_NAME = "myTest.db";//数据库名称

    public LazySqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public LazySqliteHelper(Context context) {
        this(context, VERSION);
    }

    public LazySqliteHelper(Context context, int version) {
        this(context, DB_NAME, null, version);
    }

    /**
     * 在第一次打开数据库的时候才会走、在清除数据之后再次运行-->打开数据库，这个方法会走
     * 没有清除数据，不会走这个方法 、数据库升级的时候这个方法不会走
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LazySqlite, "create a Database");
        String sql = "create table if not exists " + TABLE_NAME + " (id text primary key, name text)";
        db.execSQL(sql);
    }

    /**
     * 第一次创建数据库的时候，这个方法不会走、清除数据后再次运行(相当于第一次创建)这个方法不会走
     * 数据库已经存在，而且版本升高的时候，这个方法才会调用
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(LazySqlite, "update a Database");
//        数据库升级，删除原来数据，比较低级做法
//        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
//        db.execSQL(sql);
//        onCreate(db);
//        数据库升级时候 添加字段
//        String updateSql = "alter table " + TABLE_NAME + " add column age Integer";
//        db.execSQL(updateSql);
//        数据库升级时候 添加修改表名字
        String updateSql = "alter table "+TABLE_NAME+" rename to "+TABLE_RENAME;
        db.execSQL(updateSql);
    }

    /**
     * 只有新版本比旧版本低的时候才会执行 ，如果不执行降级操作，会抛出异常
     */
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
