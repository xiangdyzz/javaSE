package com.xiangdy.study.annotation.entity;

import org.springframework.stereotype.Component;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2020/1/21　10:00
 */
@Component
public class SpringBean {

    public String getDream() {
        return dream;
    }

    public void setDream(String dream) {
        this.dream = dream;
    }

    String dream;
}
