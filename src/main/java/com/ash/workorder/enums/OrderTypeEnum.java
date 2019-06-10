package com.ash.workorder.enums;

/**
 * @Created by Ash on 2018/12/28 14:18
 */
public enum OrderTypeEnum implements BaseEnum{

    REJECT(0, "reject"), WAITING(1, "waiting"), AGREED(2, "agreed");

    private int value;
    private String type;

    OrderTypeEnum(int value, String type) {
        this.value = value;
        this.type = type;
    }

    public int getCode(){
        return this.value;
    }

    public String getType(){
        return this.type;
    }
}
