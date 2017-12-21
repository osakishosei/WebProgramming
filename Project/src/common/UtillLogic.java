package common;

public class UtillLogic {

	/**
	 * 渡された文字列がnullまたは空文字だった場合trueを返す
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		if (null == str || str == "") {
			return true;
		}
		return false;
	}

//	public static boolean isEmpty(String str) {
//		//ハッシュを生成したい元の文字列
//		String source = "暗号化対象";
//		//ハッシュ生成前にバイト配列に置き換える際のCharset
//		Charset charset = StandardCharsets.UTF_8;
//		//ハッシュアルゴリズム
//		String algorithm = "MD5";
//
//		//ハッシュ生成処理
//		byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
//		String result = DatatypeConverter.printHexBinary(bytes);
//		//標準出力
//		System.out.println(result);
//
//
//	}




}