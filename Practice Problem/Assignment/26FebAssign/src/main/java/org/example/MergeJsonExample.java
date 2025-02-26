package org.example;

import org.json.JSONObject;

public class MergeJsonExample {
    public static void main(String[] args) {
        JSONObject json1 = new JSONObject();
        json1.put("name", "Alice");
        json1.put("age", 21);

        JSONObject json2 = new JSONObject();
        json2.put("city", "New York");
        json2.put("zip", "10001");

        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        System.out.println(json1.toString(2));
    }
}
