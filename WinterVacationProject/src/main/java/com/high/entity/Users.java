package com.high.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName
public class Users {
    @TableId
    private Integer uid;
    private String uname;
    private String password;
    private Integer status;
    private Integer utype;
}
