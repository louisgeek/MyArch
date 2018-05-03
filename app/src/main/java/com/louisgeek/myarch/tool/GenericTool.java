package com.louisgeek.myarch.tool;

import android.util.Log;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTool {
    private static final String TAG = "GenericTool";

    //支持解析一个类的类型，不支持List<T> 的类型
    public static Type getFirstGenericType(Class<?> clazz) {
        return getGenericTypes(clazz)[0];
    }

    //支持解析一个类的类型，不支持List<T> 的类型
    public static Type[] getGenericTypes(Class<?> clazz) {
        //反射获取带泛型的class
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            //获取所有泛型参数列表
            ParameterizedType parameter = (ParameterizedType) genericSuperclass;
            //将泛型转为type
            return parameter.getActualTypeArguments();
        } else {
            Log.e(TAG, "getGenericTypes: genericSuperclass is not ParameterizedType");
            return new Type[]{genericSuperclass};
        }
    }
}
