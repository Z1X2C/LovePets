package com.zhangbo.lovepets.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sell {
  @TableId
  private String id;
  private String petId;
  private String userId;
  private double price;



}
