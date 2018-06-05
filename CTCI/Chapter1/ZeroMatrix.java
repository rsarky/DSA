import java.util.Scanner;

public class ZeroMatrix {
    static void zerofy(int mat[][]) {
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat.length;j++) {
                if(mat[i][j] == 0) {
                    mat[i][j] = Integer.MIN_VALUE;
                }
            }
        }

        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat.length;j++) {
                if(mat[i][j] == Integer.MIN_VALUE) {
                    makeZero(mat,i,j);
                }
            }
        }
    }

    static void makeZero(int mat[][],int row, int col) {
        for(int i=0;i<mat[row].length;i++) {
            mat[row][i] = 0;
        }
        for(int i=0;i<mat.length;i++) {
            mat[i][col] = 0;
        }
    }

    static void input(int a[][],Scanner ip) {
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a.length;j++)
                a[i][j] = ip.nextInt();
    }

    static void output(int a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[i][j]);
                System.out.print("  ");
            }
            System.out.println("");
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int matrix[][] = new int[n][n];
        input(matrix,sc);
        zerofy(matrix);
        output(matrix);
    }
}