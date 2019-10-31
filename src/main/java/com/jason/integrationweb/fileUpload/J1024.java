package com.jason.integrationweb.fileUpload;

public class J1024 {
    public static void main(String[] args) {
        int m = 1;
        int n = 0;

        int a = m << 8;
        int b = a ^ (n + 7) | 512;
        int c = b + 249;
        Inspur1024(a, b, c);

    }

    public static void Inspur1024(int a, int b, int c) {
        String s = null;
        if (a << 2 == 1024) {
            s = "Happy ";
        }
        if ((b & 1) == 1) {
            s += "developers' ";
        }
        if (c == 1 << 10) {
            s += "Day!";
        }
        System.out.println(s);
    }


}
