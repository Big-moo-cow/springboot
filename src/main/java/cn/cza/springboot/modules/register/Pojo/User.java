package cn.cza.springboot.modules.register.Pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {

    @TableId
    private String id;
    private String name;
    private Integer age;
    private String phone;
    private String sex;
    private String email;
    private String code;
    private String checkCode;
    private String isdel;


}