package com.igeekspace;

import java.io.*;

public class Main {
    static StreamTokenizer in;
    static PrintWriter out;

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    private static void solve() throws IOException {
        int testCases = nextInt();

        while (testCases-- > 0) {
            int n = nextInt();
            int m = nextInt();

            int minCalorie = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int x = nextInt();
                int y = nextInt();

                minCalorie = Math.min(minCalorie, (m + x - 1) / x * y);
            }

            out.println(minCalorie);
        }
    }

    public static void main(String[] args) {
        try {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            solve();
            out.flush();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}