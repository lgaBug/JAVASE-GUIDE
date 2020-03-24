package com.lga.gc.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 *  -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class TestMemory {

    public static class OOMObject{
        //64kb
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int count) throws InterruptedException {
        Thread.sleep(20000);
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1500);
    }
}
