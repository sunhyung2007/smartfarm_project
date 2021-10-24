package com.example.farm;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DetailRequest extends StringRequest {

    // 서버 URL 설정 (PHP 파일 연동)
    final static private  String URL = "http://dbgus1006.ivyro.net/Detail.php";

    private Map<String, String> map;




    public DetailRequest(String potID, float potGHUM, float potATEMP, float potAHUM, boolean potWCON, boolean potVCON, String userID, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();

        map.put("potID", potID);
        map.put("potGHUM", potGHUM + "");
        map.put("potATEMP", potATEMP + "");
        map.put("potAHUM", potAHUM + "");
        map.put("potWCON", potWCON + "");
        map.put("potVCON", potVCON + "");
        map.put("userID", userID);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }




}
