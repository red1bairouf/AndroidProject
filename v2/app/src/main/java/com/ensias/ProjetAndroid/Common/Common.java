package com.ensias.ProjetAndroid.Common;

import com.ensias.ProjetAndroid.Model.User;

public class Common {
    public static User currentUser ;

    public static String convertCodeToStatus(String status) {
        if(status.equals("0"))
            return "Placed";
        else if(status.equals("1"))
            return "On the way";
        else
            return "Shipped";
    }
}