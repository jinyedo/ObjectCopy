package com.example.objectcopy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectCopyTest {

    @Autowired
    CopyObject copyObject;

    @Test
    public void test() {
        copyObject.shallowCopy1();
        copyObject.shallowCopy2();
        copyObject.deepCopy();
    }
}
