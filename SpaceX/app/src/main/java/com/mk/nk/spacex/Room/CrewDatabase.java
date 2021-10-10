package com.mk.nk.spacex.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Crew.class},version = 2,exportSchema = false)
public abstract class CrewDatabase extends RoomDatabase {
    public abstract DAO dao();
}
