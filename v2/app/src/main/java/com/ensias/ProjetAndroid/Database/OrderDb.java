package com.ensias.ProjetAndroid.Database;

import androidx.room.*;

import com.ensias.ProjetAndroid.Database.Dao.OrderDao;
import com.ensias.ProjetAndroid.Model.Order;

@Database(entities = {Order.class}, version = 1)
public abstract class OrderDb extends RoomDatabase {

        // --- DAO ---
        public abstract OrderDao OrderDao();


}
