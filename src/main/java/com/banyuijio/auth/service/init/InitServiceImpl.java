package com.banyuijio.auth.service.init;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitServiceImpl implements InitService {
    @Override
    public Object init(String pass) {
        if (!pass.equalsIgnoreCase("qwertyasdfg")){
            return "goblok";
        }
        return "anjay sukses init";
    }
}
