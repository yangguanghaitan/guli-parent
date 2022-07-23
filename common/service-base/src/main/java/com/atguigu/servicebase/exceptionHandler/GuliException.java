package com.atguigu.servicebase.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther d
 * @Date 2022/7/12 15:43
 * @Describe
 **/
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class GuliException extends RuntimeException{

   private Integer code;

   private String msgg;

   public GuliException(String msgg){
      super(msgg);
      this.msgg=msgg;
   }

   public GuliException(Integer code,String msgg){
      super(msgg);
      this.msgg=msgg;
      this.code=code;
   }


}
