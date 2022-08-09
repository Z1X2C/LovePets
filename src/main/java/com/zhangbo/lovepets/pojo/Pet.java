package com.zhangbo.lovepets.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
  @TableId
  private String petId;
  private String userId;
  private String petName;
  private int petAge;
  private String petHobby;
  private String petVariety;
  private String petVaccine;
  private String petState;
  private String petImage;


}
