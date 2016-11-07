package com.aptmgmt.dao.accesstoken;

import com.aptmgmt.dao.Dao;
import com.aptmgmt.entity.AccessToken;

public interface AccessTokenDAO extends Dao<AccessToken, Long>
{
    public AccessToken findByToken(String accessTokenString);
}
