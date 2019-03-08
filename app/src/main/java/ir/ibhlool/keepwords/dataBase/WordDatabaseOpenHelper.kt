package ir.ibhlool.keepwords.dataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class WordDatabaseOpenHelper(context: Context) : ManagedSQLiteOpenHelper(context, "DB", null, 1) {
    companion object {
        private var instance: WordDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(context: Context): WordDatabaseOpenHelper {
            if (instance == null) {
                instance = WordDatabaseOpenHelper(context)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
            "MyWord", true, "ID" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            "Word" to TEXT + NOT_NULL,
            "Definition" to TEXT + NOT_NULL,
            "WordInUse" to TEXT,
            "Means" to TEXT,
            "Voice" to TEXT,
            "GroupID" to INTEGER,
            "PublishMode" to BLOB + NOT_NULL
        )

        db?.createTable(
            "MyLesson", true,
            "ID" to INTEGER + UNIQUE + PRIMARY_KEY + AUTOINCREMENT,
            "Name" to TEXT + NOT_NULL,
            "Color" to INTEGER + NOT_NULL
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.dropTable("MyWord", true)
        db?.dropTable("MyLesson", true)
    }

    val Context.database: WordDatabaseOpenHelper
        get() = WordDatabaseOpenHelper.getInstance(applicationContext)
}