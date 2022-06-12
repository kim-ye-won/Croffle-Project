package com.example.croffleproject.RoomDB;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

// version = 1: 세팅, 통계, 타이머
// version = 2: Analytics Dao 추가
// version = 3: 모든 entity 병합
// version = 4: DB 수정
// version = 5: 모든 db 병합
// version = 6: 최종 merge 후 디비 수정
@Database(entities = { SettingsEntity.class, AnalyticsEntity.class,
        TimerEntity.class, ConcentrationTableEntity.class, MeasurementTableEntity.class}, version = 6)

@TypeConverters({Converters.class})
public abstract class  AppDatabase extends RoomDatabase{
    public abstract ConcentrationTableDao concentrationTableDao();
    public abstract MeasurementTableDao measurementTableDao();
    public abstract SettingsDao settingsDao();
    public abstract TimerDao timerDao();
    public abstract AnalyticsDao analyticsDao();

    private static AppDatabase instance = null;
    private static String DB_NAME = "MyTime";

    public static AppDatabase getInstance(Context context) {
        return instance != null ? instance : buildDatabase(context);
    }

    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, DB_NAME)
                .fallbackToDestructiveMigration()
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                    }
                }).build();
    }
}
