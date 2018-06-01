package com.ran.MobileDevelopment;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BdayDao {
    @Query("SELECT * FROM BdayEntity ORDER BY SUBSTR(DATE('NOW'), 6)>SUBSTR(date, 6), SUBSTR(date, 6) DESC"   )
    List<BdayEntity> getallbirthday();

    @Insert
    void insertAll(BdayEntity birthday);
}
