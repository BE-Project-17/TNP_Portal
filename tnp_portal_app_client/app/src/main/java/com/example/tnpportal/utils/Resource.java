package com.example.tnpportal.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Resource<T>{
    @NonNull
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;

    public Resource(@NonNull Status status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@NonNull T data, String msg){
        return new Resource<>(Status.SUCCESS,data,msg);
    }

    public static <T> Resource<T> error(@Nullable T data, String msg){
        return new Resource<>(Status.ERROR,data,msg);
    }

    public static <T> Resource<T> loading(@NonNull T data){
        return new Resource<>(Status.LOADING,data,null);
    }
}
