package com.example.objectcopy;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class OriginalObject implements Cloneable {

    private int intValue;
    private String stringValue;
    private List<String> listValue;

    public OriginalObject() {
        this.intValue = 10;
        this.stringValue = "This String is Original";
        this.listValue = new ArrayList<>(List.of("a", "b", "c", "d", "e"));
    }

    // Deep Copy 를 위한 메서드
    public OriginalObject clone() {
        OriginalObject original = null;
        try {
            // 원본 객체 Deep Copy
            original = (OriginalObject) super.clone();
            // 원본 객체 안의 List Deep Copy
            original.setListValue(new ArrayList<>(listValue));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return original;
    }
}


