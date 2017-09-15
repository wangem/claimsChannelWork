package com.answern.claimsChannel.base.utile;



/**
 * @see  这是一个常量类,所有常量在此定义
 * @author wem
 *
 */
public class ConstantUtile {
	
	/**
	 * @see 定义一组返回信息
	 * @author wem
	 *
	 */
    public static enum ReturnHint {  

    	ERROR("0","错误"),
        SAVE_SUCCESS("1","保存成功"),
        SAVE_FAILED("2","保存失败"),
    	QUERY_FAILED("4","查询失败");
    	
        private String key;
		private String value;
		
		private ReturnHint(String key,String value){
			this.key=key;
			this.value=value;
		}
		
		public String getkey(){
			return this.key;
		}
		public String getvalue(){
			return this.value;
		}
		
		@Override
		public String toString(){
			return this.value;
		}
      }  
    
   

}
