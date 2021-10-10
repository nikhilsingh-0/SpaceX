package com.mk.nk.spacex.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mk.nk.spacex.CrewModel;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DAO {

    @Insert
    void crewInsert(Crew crew);

    @Query("Select * from Crew")
    List<Crew> readAll();

    @Query("Delete from Crew")
    void deleteAll();
}
