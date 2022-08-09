package com.zhangbo.lovepets.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tab_user")
public class User implements Serializable {
  @TableId
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private long userId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String userName;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String password;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String userPhone;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String sign;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String email;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String userAdd;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String userAvatar;
  @Transient
  private String token;
}
