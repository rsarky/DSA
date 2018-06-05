import java.util.Scanner;

public class RotateMatrix {

    //O(n^2)
    static void rotate90(int mat[][]) {
        int n = mat.length;
        int layers = n/2;
        int temp;

        for(int layer=0;layer<layers;layer++) {
            int first = layer;
            int last = n - layer - 1;
            for(int i=first;i<last;i++) {
                int offset = i - first;
                temp = mat[first][i];
                mat[first][i] = mat[last-offset][first];
                mat[last-offset][first]  = mat[last][last-offset];
                mat[last][last-offset] = mat[i][last];
                mat[i][last] = temp;
            }
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
        rotate90(matrix);
        output(matrix);
    }
}