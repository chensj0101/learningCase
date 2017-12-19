package cn.bean.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;

public class ReadFromFile {
/*
 * 以字节为单位读取文件，常用于读取二进制文件，如图片，声音，影像等。
 */
	//一次读取一个字节
	public static void readFileByByte(String filepath) {
		File file = new File(filepath);
		InputStream inputStream = null;
		
		try {
			System.out.println("以字节为单位读取文件，一次读取一个字节");
			//一次读一个字节
			inputStream = new FileInputStream(file);
			int tempByte;
			while((tempByte = inputStream.read()) != -1) {
				System.out.print((char)tempByte);
//				System.out.print(tempByte);
			}
			
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	//一次读取多个字节
	public static void readFileByBytes(String filepath) {
		File  file = new File(filepath);
		InputStream inputStream = null;
		try {
			System.out.println("以字节为单位，一次读取多个字节");
			
			inputStream = new FileInputStream(file);
			int bytes = 0;
			//一次读多个字节
			byte[] tempBytes = new byte[100];
			//读取多个字节到字节数组找那个，bytes为一次读入的字节数
			while((bytes = inputStream.read(tempBytes)) != -1) {
				String str = new String(tempBytes, 0, bytes);
				System.out.print(str);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
            if (inputStream != null) {
                try {
                	inputStream.close();
                } catch (IOException e1) {
                }
            }
        }
	}
/*
* 以字符为单位读取文件，常用于读取文本，数字等类型的文件
*/
	//一次读取一个字符
	public static void readFilesByChar(String filePath) {
		File file = new File(filePath);
		Reader reader = null;
		try {
			System.out.println("以字符为单位读取文件内容，每次读取一个字符");
			reader = new InputStreamReader(new FileInputStream(file));
			int tempChar = 0;
			while((tempChar = reader.read()) != -1) {
				// 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
				if(((char)tempChar) != '\r') {
					System.out.print((char)tempChar);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//一次读取多个字符
	public static void readFilesByChars(String filePath) {
		File file = new File(filePath);
		Reader reader = null;
		try {
			System.out.println("以字符为单位读取文件，一次读取多个字符");
			reader = new InputStreamReader(new FileInputStream(file));
			char[] tempChar = new char[30];
			int charread = 0;
			// 读入多个字符到字符数组中，charread为一次读取字符数
			while((charread = reader.read(tempChar)) != -1) {
				if((charread == tempChar.length) && (tempChar[tempChar.length - 1] != '\r')) {
					System.out.print(tempChar);
				}else {
					for(int i = 0; i < charread; i++) {
						if(tempChar[i] == '\r') {
							continue;
						}else {
							System.out.print(tempChar[i]);
						}
					}
				}
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (Exception e2) {
					
				}
			}
		}
	}
	
/*
 * 以行为单位读取文件，常用于读面向行的格式化文件
 */
	public static void readFileByLines(String filePath) {
		File file = new File(filePath);
		BufferedReader reader = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			//一次读入一行，直到读入null为文件结束
			while((tempString = reader.readLine()) != null) {
				//显示行号
				System.out.println("line" + line + ":" +tempString);
				line++;
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (Exception e2) {
					
				}
			}
		}
		
	}
	
/*
 * 将一个文件的内容写入另一个文件（按行来写）
 */
	public static void writeFileToAnotherFile(String srcFile, String targetFile) {
		File file = new File(srcFile);
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(targetFile));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while((tempString = reader.readLine()) != null) {
				writer.append(tempString);
				writer.newLine();
				writer.flush();//需要及时清理掉流的缓冲区，如果文件过大就有可能无法写入了
			}
			reader.close();
			writer.close();
			System.out.println("文件写入完成...");
		} catch (Exception e) {
			// TODO: handle exception 
		}
				
	}
	
	@Test
	public void testReadFileByByte() {
		readFileByByte("src/cn/bean/properties/Test.properties");
	}
	@Test
	public void testReadFileByBytes() {
		readFileByBytes("src/cn/bean/properties/Test.properties");
	}
	@Test
	public void testReadFileByChar() {
		readFilesByChar("src/cn/bean/properties/Test.properties");
	}
	@Test
	public void testReadFileByChars() {
		readFilesByChars("src/cn/bean/properties/Test.properties");
	}
	@Test
	public void testReadeFileByLines() {
		readFileByLines("src/cn/bean/properties/Test.properties");
	}
	@Test
	public void testWriteFileToAnotherFile() {
		writeFileToAnotherFile("src/cn/bean/io/sourceFile.txt", "src/cn/bean/io/targetFile.txt");
	}
}
