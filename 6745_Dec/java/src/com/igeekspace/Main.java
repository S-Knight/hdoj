package com.igeekspace;

import java.io.*;

public class Main {
    static StreamTokenizer in;
    static PrintWriter out;
    static int[][] relativelyPrimeCount;

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    /**
     * 判断两个整数是否互质(最大公约数为1)
     *
     * @param num1
     * @param num2
     * @return
     */
    private static boolean isRelativelyPrime(int num1, int num2) {
        if (num1 % num2 == 0 || num2 % num1 == 0) {
            return false;
        }

        int min = Math.min(num1, num2);
        for (int i = 2; i <= min; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void init() {
        //relativelyPrimeCount[i][j]存储两个数互质的最大次数
        relativelyPrimeCount = new int[1001][1001];

        for (int i = 1; i < 1001; i++) {
            relativelyPrimeCount[1][i] = i;
            relativelyPrimeCount[i][1] = i;
        }

        for (int i = 2; i < 1001; i++) {
            for (int j = i; j < 1001; j++) {
                relativelyPrimeCount[i][j] = Math.max(relativelyPrimeCount[i - 1][j], relativelyPrimeCount[i][j - 1]);
                relativelyPrimeCount[i][j] = isRelativelyPrime(i, j) ? relativelyPrimeCount[i][j] + 1 : relativelyPrimeCount[i][j];
                relativelyPrimeCount[j][i] = relativelyPrimeCount[i][j];
            }
        }
    }

    private static void solve() throws IOException {
        int testCases = nextInt();

        while (testCases-- > 0) {
            int a = nextInt();
            int b = nextInt();

            out.println(relativelyPrimeCount[a][b]);
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