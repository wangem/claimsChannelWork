package com.answern.zuul.filter.base;

 
public class ConstantUtile {
	
	public final static String CTXPROXY =  "proxy" ;
	
	public final static String CTX_ERROR_CODE_KEY =  "error.status_code" ;
	public final static String CTX_ERROR_EXCEPTION =  "error.exception" ;
	/**
	 * @see 定义一组返回信息
	 * @author wem
	 *
	 */
    public static enum ZuulRoutesPath {  

    	JOSN_TO_XML("josnToXml"),
    	XML_TO_XML("api-b");
        
		private String value;
		
		private ZuulRoutesPath(String value){
			this.value=value;
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
