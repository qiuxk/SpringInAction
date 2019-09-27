package com.qiuxk.common;

import com.qiuxk.enmu.ResultCode;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author qiuxk
 * @Description: 返回结果的实体封装
 * @create 2019/9/27
 **/

@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -5893088988745285253L;
    private  String resCode;
    private  String resDesc;
    private Object data;


    /**
     * 返回成功
     */
      public static  Result seccess(){
          Result result =  new Result();
          result.setResCode(ResultCode.SUCCESS.code());
          result.setResDesc(ResultCode.SUCCESS.getValue());
          return  result;
      }



      /**
       * 对seccess 进行改造
       */

      public  static  Result success(Object data){
          Result result =  new Result();
          result.setResCode(ResultCode.SUCCESS.code());
          result.setResDesc(ResultCode.SUCCESS.getValue());
          result.setData(data);
          return  result;
      }



      public  static  Result  fail(){
          Result result = new Result();
          result.setResDesc(ResultCode.FAIIL.getValue());
          result.setResCode(ResultCode.FAIIL.getCode());
          return  result;
      }

}
