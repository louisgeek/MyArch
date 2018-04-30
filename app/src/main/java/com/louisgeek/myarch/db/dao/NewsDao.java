package com.louisgeek.myarch.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface NewsDao {
    @Insert
    void insert();

    @Query("")
    void read();

    @Update
    void update();

    @Delete
    void delete();

}
