package pojo;

public class BaseDataPojo<T> {
	private boolean success;//是否成功
	private String msg;//返回信息
	private T data;
	//构造函数
		public BaseDataPojo(String msg,boolean success,T data) {
			this.data =data;
			this.msg = msg;
			this.success = success;
		}
		public BaseDataPojo() {
			
		}
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		
}
