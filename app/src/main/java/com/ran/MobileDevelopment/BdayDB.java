package com.ran.MobileDevelopment;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {BdayEntity.class},version = 1 , exportSchema = false)
public abstract class BdayDB extends RoomDatabase {
    public abstract BdayDao bdayDao();
}
