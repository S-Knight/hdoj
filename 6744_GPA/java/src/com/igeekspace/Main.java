package com.igeekspace;

import java.io.*;

public class Main {
    static StreamTokenizer in;
    static PrintWriter out;

    static int[] minPoints = new int[]{95, 90, 85, 80, 75, 70, 67, 65, 62, 60};
    static double[] points = new double[]{4.3, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.0};
    static double[] maxPoints = new double[401];

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    private static void init() {
        for (int i = 0; i < 60; i++) {
            maxPoints[i] = 0;
        }

        for (int i = 60; i < 401; i++) {
            for (int j = 0; j < minPoints.length; j++) {
                if (i >= minPoints[j]) {
                    maxPoints[i] = Math.max(maxPoints[i], points[j] + maxPoints[i - minPoints[j]]);
                }
            }
        }
    }

    private static void solve() throws IOException {
        int testCases = nextInt();

        while (testCases-- > 0) {
            int x = nextInt();
            out.println(String.format("%.1f", maxPoints[x]));
        }
    }

    public static void main(String[] args) {
        try {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            init();
            solve();
            out.flush();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}