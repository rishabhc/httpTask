import java.net.*;
import java.io.*;

public class httpHeader {
    
    public static void getHeader(String url) throws IOException {
		URL stringUrl = new URL(url);
        Socket s = new Socket(stringUrl.getHost(),80);
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.println("HEAD / HTTP/1.1");
        ps.println("Host: " + stringUrl.getHost());
		ps.println();
		String str = "";
		while(str!=null) {
			str = br.readLine();
			System.out.println(str);
		}
	}
	public static void main(String[] args) {
		try {
            if(args[0]!="") getHeader(args[0]);
		}
        catch(IOException e) {}
	}
}