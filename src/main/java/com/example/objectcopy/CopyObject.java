package com.example.objectcopy;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CopyObject {

    OriginalObject firstObj = new OriginalObject();
    OriginalObject secondObj;

    public void shallowCopy1() {
        System.out.println("\nShallow Copy1 : 객체 전체를 복사\n");
        secondObj = firstObj;
        changeValue(this);
    }

    public void shallowCopy2() {
        System.out.println("\nShallow Copy2 : 새로운 객체를 만들고 안의 값들만 복사\n");
        secondObj = new OriginalObject();
        secondObj.setIntValue(firstObj.getIntValue());
        secondObj.setStringValue(firstObj.getStringValue());
        secondObj.setListValue(firstObj.getListValue());
        changeValue(this);
    }

    public void deepCopy() {
        System.out.println("\nDeep Copy\n");
        secondObj = firstObj.clone();
        changeValue(this);
    }

    private void changeValue(CopyObject cp) {
        System.out.println("변경 전 출력");
        cp.printValue();

        System.out.println("\n원본 값 변경!!\n");
        cp.firstObj.setIntValue(100);
        cp.firstObj.setStringValue("This String is Changed");
        cp.firstObj.getListValue().clear();
        cp.firstObj.getListValue().addAll(List.of("가", "나", "다", "라", "마"));

        System.out.println("변경 후 출력");
        cp.printValue();
    }

    private void printValue() {
        System.out.println("firstObj[" + firstObj.toString() + "]");
        System.out.println("\tgetIntValue : " + firstObj.getIntValue());
        System.out.println("\tgetStringValue : " + firstObj.getStringValue());
        System.out.println("\tgetListValue : " + firstObj.getListValue() + "\n");

        System.out.println("secondObj[" + secondObj.toString() + "]");
        System.out.println("\tgetIntValue : " + secondObj.getIntValue());
        System.out.println("\tgetStringValue : " + secondObj.getStringValue());
        System.out.println("\tgetListValue : " + secondObj.getListValue());
    }
}

