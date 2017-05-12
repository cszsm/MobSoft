package com.moblab.zsolt.moblab.network.user;

import com.moblab.zsolt.moblab.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApi {

    /**
     * Add a new user
     *
     * @param body User object that needs to be added
     * @return Call<Void>
     */

    @POST("user")
    Call<Void> addUser(
            @Body User body
    );


    /**
     * Find user by ID
     * Returns a single user
     *
     * @param userId ID of user to return
     * @return Call<User>
     */

    @GET("user/{userId}")
    Call<User> getUserById(
            @Path("userId") Long userId
    );


}
