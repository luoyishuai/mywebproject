package com.yishuailuo.mywebproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by luoyishuai on 17/7/17.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HelloWorld implements Serializable {

    private Integer id;
    private String name;
    private String nameDesc;
    
    @Override
    public String toString() {
        
        return "HelloWorld{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameDesc='" + nameDesc + '\'' +
                '}';
    }
}
