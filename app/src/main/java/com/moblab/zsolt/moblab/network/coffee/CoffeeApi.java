package com.moblab.zsolt.moblab.network.coffee;

import com.moblab.zsolt.moblab.model.Coffee;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CoffeeApi {
  
  /**
   * Add a new coffee
   * 
   * @param body Coffee object that needs to be added
   * @return Call<Void>
   */
  
  @POST("coffee")
  Call<Void> addCoffee(
    @Body Coffee body
  );

  
  /**
   * Find coffee by ID
   * Returns a single coffee
   * @param coffeeId ID of coffee to return
   * @return Call<Coffee>
   */
  
  @GET("coffee/{coffeeId}")
  Call<Coffee> getCoffeeById(
    @Path("coffeeId") Long coffeeId
  );

  
  /**
   * Deletes a coffee
   * 
   * @param coffeeId Coffee id to delete
   * @param apiKey 
   * @return Call<Void>
   */
  
  @DELETE("coffee/{coffeeId}")
  Call<Void> deleteCoffee(
    @Path("coffeeId") Long coffeeId, @Header("api_key") String apiKey
  );

  
}
