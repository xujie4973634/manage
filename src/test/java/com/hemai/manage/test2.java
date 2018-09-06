package com.hemai.manage;

import jdk.internal.org.objectweb.asm.commons.InstructionAdapter;
import org.junit.Test;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 20:06 2018/8/23
 */

public class test2 {
    public static void main(String[] args) {
        String str = "51212dsdsda,,,//\\nnxssxx..??\ndfsd::";
        String str1 = "[^\\d]";
        System.out.println(str.replaceAll(str1,""));
    }


}
