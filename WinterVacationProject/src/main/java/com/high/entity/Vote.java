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
public class Vote {
    @TableId
    private Integer vid;
//    @NonNull
    private Integer v_uid;
//    @NonNull
    private Integer v_sid;
//    @NonNull
    private Integer v_oid;
}
