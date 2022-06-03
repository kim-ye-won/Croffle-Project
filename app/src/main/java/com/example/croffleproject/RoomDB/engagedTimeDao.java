package com.example.croffleproject.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface engagedTimeDao {//데이터를 엑세스하기 위한 오브젝트(객체)

    @Query("SELECT * FROM engagedTimeEntity")
    LiveData<List<engagedTimeEntity>> getAll(); // 리스트 전부를 받아오는 쿼리를 사용하여 getAll을 선언
    //Livedata는 TimerTableEntity의 데이터가 변경이 일어나면 관찰하던 데이터의 변경을 바로 반영함
    @Insert
    void insert(engagedTimeEntity E_Time);

    @Update
    void update(engagedTimeEntity E_Time);

    @Delete
    void delete(engagedTimeEntity E_Time);



}