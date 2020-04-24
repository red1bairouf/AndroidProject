package com.example.resto.bd;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UsrDatabase extends RoomDatabase {
    public abstract UsrDao mydao();
}
