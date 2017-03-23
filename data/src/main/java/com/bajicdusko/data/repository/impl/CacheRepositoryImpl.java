package com.bajicdusko.data.repository.impl;

import android.content.SharedPreferences;

import com.bajicdusko.data.Constants;
import com.bajicdusko.data.repository.CacheRepository;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27/02/17.
 */

/**
 * CacheRepositoryImpl utilize SharedPreferences to store data that won't be cleared with
 * database data. Cache data lifecycle is different.
 */
public class CacheRepositoryImpl implements CacheRepository {

    private static final String KEY_USERNAME = "key_username";
    private static final String KEY_PASSWORD = "key_password";
    private static final String KEY_IS_SIDEBAR_SHOWN = "key_is_sidebar_shown";
    private static final String KEY_COMPANY_ID = "key_company_id";
    private static final String KEY_LONGITUDE = "key_longitude";
    private static final String KEY_LATITUDE = "key_latitude";
    private static final String KEY_REMEMBER_ME = "key_remember_me";
    private SharedPreferences sharedPreferences;

    public CacheRepositoryImpl(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void setUsername(String username) {
        sharedPreferences.edit().putString(KEY_USERNAME, username).apply();
    }

    @Override
    public void setPassword(String password) {
        sharedPreferences.edit().putString(KEY_PASSWORD, password).apply();
    }

    @Override
    public String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, Constants.EMPTY_STRING);
    }

    @Override
    public String getPassword() {
        return sharedPreferences.getString(KEY_PASSWORD, Constants.EMPTY_STRING);
    }

    /**
     * On application first start, this method returns false and sidebar will be automatically shown.
     * SideBar status will be set to true, forever,
     *
     * @return
     */
    @Override
    public boolean isSidebarShown() {
        boolean isSidebarShown = sharedPreferences.getBoolean(KEY_IS_SIDEBAR_SHOWN, false);
        if (!isSidebarShown) {
            sharedPreferences.edit().putBoolean(KEY_IS_SIDEBAR_SHOWN, true).apply();
        }

        return isSidebarShown;
    }

    @Override
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }
}
