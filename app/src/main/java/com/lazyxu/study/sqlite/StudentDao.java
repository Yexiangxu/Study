package com.lazyxu.study.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import static com.lazyxu.study.sqlite.TestSqlite.TABLE_NAME;

/**
 * User: Lazy_xu
 * Data: 2019/07/03
 * Description:
 * FIXME
 */
public class StudentDao {
    private static StudentDao INSTANCE = null;
    private TestSqlite mHelper = null;
    private SQLiteDatabase mDB = null;

    private StudentDao(Context context) {
        mHelper = new TestSqlite(context);
        mDB = mHelper.getWritableDatabase();
    }

    public static StudentDao getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (StudentDao.class){
                if(INSTANCE == null){
                    return new StudentDao(context);
                }
            }
        }
        return INSTANCE;
    }


    public void deletestudent(String id) {
        mDB.beginTransaction();
        mDB.delete(TABLE_NAME, "studentid = ?", new String[]{id});
        mDB.setTransactionSuccessful();
    }

    public void updatestudent(ContentValues contentValues, String id) {
        mDB.beginTransaction();
        mDB.update(TABLE_NAME, contentValues, "Id = ?", new String[]{id});
        mDB.setTransactionSuccessful();
    }

    public void addstudent(Student student) {
        mDB.beginTransaction();
        ContentValues contentValues = new ContentValues();
        contentValues.put("studentid", student.getId());
        contentValues.put("name", student.getName());
        contentValues.put("age", student.getAge());
        mDB.insertOrThrow(TABLE_NAME, null, contentValues);
        mDB.setTransactionSuccessful();
        mDB.endTransaction();
    }
}

