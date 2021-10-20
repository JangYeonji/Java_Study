package T211020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;

public class URLConnectionReader {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		URL site = new URL("http://www.naver.com/");
		URLConnection url = site.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
		String inLine;
		while((inLine=in.readLine())!=null)
			System.out.println(inLine);
		in.close();
	}

}
