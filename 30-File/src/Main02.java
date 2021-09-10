import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Main02 {

	public static void main(String[] args) {

		final String PATH = "./test.txt";
		
		String write_string = "가나다라마바사nabcdefg";
		
		/** 특정 인코딩 방식 적용 */
		byte[] buffer = null;
		try {
			buffer = write_string.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/** 파일 저장 절차 시작 */
		OutputStream out = null;
		try {
			out = new FileOutputStream(PATH);
			// 파일쓰기
			out.write(buffer);
			System.out.println("[INFO] 파일 저장 성공 >> " + PATH);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 지정된 경로를 찾을 수 없음. >> " + PATH);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 저장 실패 >> " + PATH);
			e.printStackTrace();
		} catch (Exception e) { 
			System.out.println("[ERROR] 알 수 없는 에러 >> " + PATH);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		

	}

}
