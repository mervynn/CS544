package edu.mum.cs544.service.impl;

import edu.mum.cs544.service.ITestService;
import edu.mum.framework.annotations.MyService;

@MyService
public class TestServiceImpl implements ITestService {

    @Override
    public String calculate(String a, String b, String operator) {
        Double n1 = Double.valueOf(a);
        Double n2 = Double.valueOf(b);
        Double res = 0d;
        switch (operator) {
            case "0":
                res = n1 + n2;
                break;
            case "1":
                res = n1 - n2;
                break;
            case "2":
                res = n1 * n2;
                break;
            case "3":
                res = n1 / n2;
                break;
            default:
                break;
        }

        return String.valueOf(res);
    }
}
