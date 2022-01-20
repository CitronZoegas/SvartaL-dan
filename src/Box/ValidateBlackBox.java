package Box;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ValidateBlackBox {
    public ValidateBlackBox() {

    }

    public ArrayList<List<Map<String, String>>> validation_seeking() {

        HashMap<String, String> GETValues0 = new HashMap<>();
        System.out.println("GET0");
        GETValues0.put("list0", "customer");
        GETValues0.put("page0", "2");
        HashMap<String, String> GETValues1 = new HashMap<>();
        System.out.println("GET1");
        GETValues1.put("list1", "customer");
        GETValues1.put("page1", "2");
        HashMap<String, String> GETValues2 = new HashMap<>();
        System.out.println("GET2");
        GETValues2.put("list2", "customer");
        GETValues2.put("page2", "2");
        HashMap<String, String> GETValues3 = new HashMap<>();
        System.out.println("GET3");
        GETValues3.put("list0", "customer");
        GETValues3.put("page0", "2");
        HashMap<String, String> GETValues4 = new HashMap<>();
        System.out.println("GET4");
        GETValues4.put("list1", "customer");
        GETValues4.put("page1", "2");
        HashMap<String, String> GETValues5 = new HashMap<>();
        System.out.println("GET5");
        GETValues5.put("list2", "customer");
        GETValues5.put("page2", "2");
        HashMap<String, String> in0 = new HashMap<>();
        in0.put("page0", "3");
        HashMap<String, String> in1 = new HashMap<>();
        in1.put("page1", "2");
        HashMap<String, String> in2 = new HashMap<>();
        in2.put("list", "page");
        in2.put("employees", null);
        HashMap<String, String> in3 = new HashMap<>();
        in3.put(null, "foo");
        in3.put(null, "2");
        in3.put("baz", "3");
        HashMap<String, String> in4 = new HashMap<>();
        in4.put("foo", "bar");
        in4.put("false", "1");
        HashMap<String, String> in5 = new HashMap<>();
        in5.put(null, "baz");
        HashMap<String, String> out0 = new HashMap<>();
        out0.put("out0", "list=customers&page=3");
        HashMap<String, String> out1 = new HashMap<>();
        out1.put("out1", "list=customers");
        HashMap<String, String> out2 = new HashMap<>();
        out2.put("out2", "list=employees");
        HashMap<String, String> out3 = new HashMap<>();
        out3.put("out3", "foo=2&bar=2&baz=3");
        HashMap<String, String> out4 = new HashMap<>();
        out4.put("out4", "bar=1");
        HashMap<String, String> out5 = new HashMap<>();
        out5.put("out5", "foo=1&bar=2");
        List<Map<String, String>> _GET0 = new ArrayList<>();
        _GET0.add(GETValues0);
        _GET0.add(in0);
        _GET0.add(out0);
        List<Map<String, String>> _GET1 = new ArrayList<>();
        _GET1.add(GETValues1);
        _GET1.add(in1);
        _GET1.add(out1);
        List<Map<String, String>> _GET2 = new ArrayList<>();
        _GET2.add(GETValues2);
        _GET2.add(in2);
        _GET2.add(out2);
        List<Map<String, String>> _GET3 = new ArrayList<>();
        _GET3.add(GETValues3);
        _GET3.add(in3);
        _GET3.add(out3);
        List<Map<String, String>> _GET4 = new ArrayList<>();
        _GET4.add(GETValues4);
        _GET4.add(in4);
        _GET4.add(out4);
        List<Map<String, String>> _GET5 = new ArrayList<>();
        _GET5.add(GETValues5);
        _GET5.add(in5);
        _GET5.add(out5);
        ArrayList<List<Map<String, String>>> checks = new ArrayList<>();
        checks.add(_GET0);
        checks.add(_GET1);
        checks.add(_GET2);
        checks.add(_GET3);
        checks.add(_GET4);
        checks.add(_GET5);
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        checks.forEach(var10001::println);
        return checks;
    }
}