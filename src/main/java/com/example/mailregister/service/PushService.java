package com.example.mailregister.service;

import com.example.mailregister.common.ResultBean;

public interface PushService {

    void pushToOne(String uid, String text);

    void pushToAll(String text);

    ResultBean pushMessageToXFServer(String uid, String text);
}
