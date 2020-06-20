package util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

public class QiniuUtil {

	// 在七牛注册后获得的accessKey和secretKey（改为自己的）
	private static String accessKey = "oucdZqrr5c7IxQW8ZyYgTDKxpPNfIMB3OnNJeg1I";
	private static String secretKey = "G7W77DlMCmcX8JHxKgh4djVsucu18Bu-Dtb_0xjw";
	private static String bucket = "qimosheji"; // 七牛空间名（改为自己的）

	// 获取覆盖同名文件的上传凭证
	public static String getToken(String key) {
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket, key, 3600, null, true); // key：上传到七牛的文件名，设置key将生成覆盖相同key文件的上传Token
		return upToken;
	}

	// 删除七牛中指定key的文件
	public static void delFile(String key) {
		// 构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		Auth auth = Auth.create(accessKey, secretKey);
		BucketManager bucketManager = new BucketManager(auth, cfg);
		try {
			bucketManager.delete(bucket, key);
		} catch (QiniuException ex) {
			// 如果遇到异常，说明删除失败
			System.err.println(ex.code());
			System.err.println(ex.response.toString());
		}
	}
}
