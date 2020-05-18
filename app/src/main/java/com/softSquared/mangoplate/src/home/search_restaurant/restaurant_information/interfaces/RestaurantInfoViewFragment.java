package com.softSquared.mangoplate.src.home.search_restaurant.restaurant_information.interfaces;

import com.softSquared.mangoplate.src.home.search_restaurant.restaurant_information.models.RestaurantInfomationResponse;

public interface RestaurantInfoViewFragment {

    void validateSuccess(String text);

    void validateFailure(String message);

    void successUpdateRecyclerView(RestaurantInfomationResponse restaurantInfomationResponse);



}
