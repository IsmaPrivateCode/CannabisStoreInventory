package com.example.cannabisstoreinventory.user;

import android.provider.BaseColumns;

public class UserConctract {

    public static abstract class UserEntry implements BaseColumns{
        public static final String TABLE_NAME="user";
        public static final String ID="id";
        public static final String NAME="name";
        public static final String PASSWORD="password";
        public static final boolean ADMIN=false;
        public static final String AVATAR_URI="avatarUri";
    }
}
