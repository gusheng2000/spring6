package com.shichong.factory;

import com.shichong.bean.Student;
import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author sc
 * @ClassName StudentFactoryBean
 * @Description class function:
 * @Date 2023/12/17 14:57:10
 **/
public class DateFactoryBean implements FactoryBean<Date> {
    public String birth;

    public void setBirth(String birth) {
        this.birth = birth;
    }


    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(birth);
        return parse;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
