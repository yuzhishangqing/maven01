package aa.Maven01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
		String s[] = args[0].split("/");
		s[1] = sha256hex(s[1]);
		System.out.println(s[0]+"  "+s[1]);
		String[] file = new String[2];
		try {
			FileInputStream fis = new FileInputStream("key.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String l;
			int i=0;
			while((l=br.readLine())!=null) {
				file[i] = l;
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(file[0]+"  "+file[1]);
		if(s[0].equals(file[0])) {
			if(s[1].equals(file[1]))
				System.out.println("success!");
			else
				System.out.println("fail!");
		}
		else
			System.out.println("fail!");
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}

