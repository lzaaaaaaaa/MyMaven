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
public class Subject {
    @TableId
//    @NonNull
    private Integer sid;
//    @NonNull
    private String title;
//    @NonNull
    private Integer stype;
}
