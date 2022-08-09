package com.zhangbo.lovepets.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Petimg {
  @TableId
  private String imgId;
  private String perId;
  private String img;
  private String bigImg;



}
