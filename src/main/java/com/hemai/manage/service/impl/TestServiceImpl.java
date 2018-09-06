package com.hemai.manage.service.impl;



import com.hemai.manage.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 9:41 2018/7/26
 */
@Service
public class TestServiceImpl implements TestService {

    public String test() {
        return "test";
    }

}
