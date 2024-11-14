// 05 static 메소드, 배열

package ch11;

class ArrayUtil {
    public static int[] concat(int a[], int b[]) {
        int res_arr[] = new int[a.length + b.length];

        System.arraycopy(a, 0, res_arr, 0, a.length);
        System.arraycopy(b, 0, res_arr, a.length, b.length);

        return res_arr;
    }

    public static void print(int a[]) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }
}

public class week11_5 {
    public static void main(String[] args) {
        int array1[] = {1, 5, 7, 9};
        int array2[] = {3, 6, -1, 100, 77};
        int array3[] = ArrayUtil.concat(array1, array2);
        ArrayUtil.print(array3);
    }
}
