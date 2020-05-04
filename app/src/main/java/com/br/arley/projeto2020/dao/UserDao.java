package com.br.arley.projeto2020.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.br.arley.projeto2020.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    public List<User> getAllUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
