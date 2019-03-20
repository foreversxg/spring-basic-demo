package com.example.jdk.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/7/31
 */
public class UnsafeTest {

    private Long a;
    public static void main(String[] args) throws Exception{
        System.out.println(sizeOf(new Object()));
        System.out.println(sizeOf(new Guard()));
        System.out.println(sizeOf(new String("1232132132132132131321321321321321132121213131321")));
    }

    public static long sizeOf(Object o) {
        Unsafe u = getUnsafe();
        HashSet<Field> fields = new HashSet();
        Class c = o.getClass();
        while (c != Object.class) {
            for (Field f : c.getDeclaredFields()) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }

        // get offset
        long maxSize = 0;
        for (Field f : fields) {
            long offset = u.objectFieldOffset(f);
            if (offset > maxSize) {
                maxSize = offset;
            }
        }

        return ((maxSize/8) + 1) * 8;   // padding
    }

    private static void test_2() throws NoSuchFieldException {
        Guard guard = new Guard();
        System.out.println(guard.giveAccess());   // false, no access

        // bypass
        Unsafe unsafe = getUnsafe();
        Field f = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
        // 修改内存值
        unsafe.putInt(guard, unsafe.objectFieldOffset(f), 42); // memory corruption
        System.out.println(guard.giveAccess());
    }
    // 创建对象
    private static void test_1() throws InstantiationException {
        Unsafe unsafe = getUnsafe();
        A a = (A) unsafe.allocateInstance(A.class);
        System.out.println(a);
    }


    public static Unsafe getUnsafe() {
        Field f;
        Unsafe unsafe = null;
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return unsafe;
    }

    static class Guard {
        private int ACCESS_ALLOWED = 1;

        public boolean giveAccess() {
            return 42 == ACCESS_ALLOWED;
        }
    }

    class A {
        private long a; // not initialized value

        public A() {
            this.a = 1; // initialization
        }

        public long a() { return this.a; }
    }
}
