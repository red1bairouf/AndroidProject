package com.example.resto.bd;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface UsrDao {
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    public void adduser(User user);
    @Query("select * from users where nom = :login")
    public List<User> getUser(String login);
    @Query("select * from users")
    public List<User> getUsers();
    @Delete
    public void deletuser(User user);
    @Update
    public void updatuser(User user);
}
