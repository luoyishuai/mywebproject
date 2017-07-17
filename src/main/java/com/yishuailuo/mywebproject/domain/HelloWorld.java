package com.yishuailuo.mywebproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by luoyishuai on 17/7/17.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HelloWorld {

    private Integer id;
    private String name;
    private String nameDesc;

}
