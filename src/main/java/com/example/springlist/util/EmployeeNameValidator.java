package com.example.springlist.util;

import com.example.springlist.exceptions.IllegalNameException;
import org.apache.commons.lang3.StringUtils;

public class EmployeeNameValidator {
    public static void checkName(String... names){
        for(String name : names){
            if(!StringUtils.isAlpha(name)){
                throw new IllegalNameException();
            }
        }
    }
}
