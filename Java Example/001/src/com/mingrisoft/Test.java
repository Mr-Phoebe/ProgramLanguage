package com.mingrisoft;

import java.util.*;
import java.io.*;
import java.math.*;

public class Test
{
	static class Reader {
        final private int BUFFER_SIZE = 1 << 16;private byte[] buffer;private int bufferPointer, bytesRead;
        public Reader(){buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
        }private void fillBuffer() throws IOException{bytesRead=System.in.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
        }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
        }public String next() throws IOException{StringBuilder sb = new StringBuilder();byte c;while((c=read())<=' ');do{sb.append((char)c);} while((c=read())>' ');return sb.toString();
        }public String nextLine() throws IOException{StringBuilder sb = new StringBuilder();byte c;while((c=read())!=-1){if(c=='\n')break;sb.append((char)c);}return sb.toString();
        }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10L+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;             
        }public void close() throws IOException{if(System.in==null) return;System.in.close();}  
    }

	public static Reader in = new Reader();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException
	{
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext())
		{
			long a = cin.nextLong();
			long b = cin.nextLong();
			long t = a+b;
			int ans = 0;
			while(t!=0)
			{
				ans++;
				t /= 10;
			}
			System.out.println(ans);
		}
	}
}