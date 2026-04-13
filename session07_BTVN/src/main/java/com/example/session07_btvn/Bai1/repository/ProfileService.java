package com.example.session07_btvn.Bai1.repository;

import com.example.session07_btvn.Bai1.model.RestaurantProfile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProfileService {
    List<RestaurantProfile> list = new ArrayList<>(
            Arrays.asList(
                    new RestaurantProfile("Nguyen Van A" , "01234567890" , true),
                    new RestaurantProfile("Nguyen Van B" , "01234567890" , false),
                    new RestaurantProfile("Nguyen Van C" , "01234567890" , true)
            )
    );

    public List<RestaurantProfile> getAll(){
        return this.list;
    }

    public void uploadProfile(RestaurantProfile profile){
        list.add(profile);
    }
}

