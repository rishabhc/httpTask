import java.net.*;
import java.io.*;

public class httpHeader {
    
	public static void getHeader(String url) throws IOException {
		Socket s = new Socket(url,80);
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.println("GET / HTTP/1.1");
		ps.println();
		String str = "";
		while(str!=null) {
			str = br.readLine();
			System.out.println(str);
		}
	}
	public static void main(String[] args) {
		try {
            getHeader("www.google.com");
		}
        catch(IOException e) {}
	}
}