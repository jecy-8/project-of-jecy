package jecy.test.algorithm.sort;

public class SortUtils {

    public static String getArrayElements(int[] a) {
        StringBuffer sb = new StringBuffer("{");
        for (int i = 0; i < a.length; i ++) {
            sb.append(a[i]).append(",");
        }
        sb.deleteCharAt(sb.toString().length() - 1);
        sb.append("}");
        return sb.toString();
    }
}
