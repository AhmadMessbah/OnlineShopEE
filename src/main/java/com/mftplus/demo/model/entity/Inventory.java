package com.mftplus.demo.model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Inventory {
    private Long id;
    private String title;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return new Gson().toJson(this);}
}
