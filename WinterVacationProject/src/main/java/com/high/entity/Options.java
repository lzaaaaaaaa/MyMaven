package com.high.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName
public class Options {
    @TableId
    private Integer oid;
//    @NonNull
    private String context;
//    @NonNull
    private Integer o_sid;
}
