package com.ambereye.fegin;

import com.ambereye.entity.Student;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/11/11
 */
@Component
public class FeignError implements FeignProviderClient{
    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器维护中。。。。";
    }
}
