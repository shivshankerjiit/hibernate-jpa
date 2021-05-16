package com.demo.springboot.hibernatejpademo;

import java.util.EnumSet;

public enum PositionCheckTyp {
    SKIP_RECORD(0), SET_DEFAULT_VALUE(1), IMPORTED_VALUE(2);

    private int value;

    private PositionCheckTyp(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static PositionCheckTyp from(int value) throws Exception {
        for( final PositionCheckTyp element : EnumSet.allOf(PositionCheckTyp.class)){
            if(element.getValue() == value) {
                return element;
            }
        }
        throw new Exception(new StringBuilder("Unknown PositionCheckTyp :").append(value).toString());
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}

