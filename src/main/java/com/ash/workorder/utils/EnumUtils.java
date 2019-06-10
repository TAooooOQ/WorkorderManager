package com.ash.workorder.utils;


import com.ash.workorder.enums.BaseEnum;

/**
 * @Created by Ash on 2018/12/28 14:47
 */
public class EnumUtils {

    /**
     * 根据 int 转化成枚举
     * @param enumClass
     * @param code
     * @param <E>
     * @return
     */
    public static <E extends Enum<?> & BaseEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for(E e : enumConstants) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }
}
