package com.xiangdy.study;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Data;

import java.util.*;

/**
 * @author xiangDY
 * @Description: 测试字符串存储存储入字符串常量池中
 * @date 2019/12/24　13:55
 */
public class StringTest {

    public static void main(String[] args) {
       ArrayList<String> list = new ArrayList<String>(Arrays.asList(new String[]{"1","2","3","4","5"}));
        /**
         * 1.由于iterator.remove();在调用集合删除方法改变了modeCount后
         * 2.又将modCount的值赋给了expectedModCount，导致下一次next判断时正确
         */
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next(); //if (modCount != expectedModCount) throw new ConcurrentModificationException();
            if(str.equals("2"))
                /**
                 * 1.调用ArrayList.this.remove(lastRet);
                 * 2.expectedModCount = modCount;
                 */
                iterator.remove();
        }
    }
}
