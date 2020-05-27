package com.ensias.ProjetAndroid.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.ensias.ProjetAndroid.Model.Order;

import java.util.List;

@Dao
public interface OrderDao {
    @Query("SELECT * FROM `Order`")
    List<Order> getCart();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertOrder(Order order);

    @Update
    int updateOrder(Order order);

    @Query("DELETE FROM `Order` WHERE ProductId = :productId")
    int deleteOrder(long productId);

    @Query("DELETE FROM `Order`")
    int cleanCart();
}
