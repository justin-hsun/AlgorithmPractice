package Others;

// 415
// int 1 = '1' - '0'

public class AddStrings {
    public String solutions(String num1, String num2) {

        StringBuilder ret = new StringBuilder();

        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        a = rev(a);
        b = rev(b);

        var carryOver = 0;
        for (int i=0; i<Math.min(a.length, b.length); ++i) {
            var numa = a[i] - '0';
            var numb = b[i] - '0';
            ret.append((char)((numa+numb+carryOver)%10 + '0'));
            carryOver = (numa+numb+carryOver)/10;
        }
        if (a.length == b.length) {
            // do noting
        } else if (a.length > b.length) {
            for (int i=b.length; i<a.length; ++i) {
                var numa = a[i] - '0';
                ret.append((char)((numa+carryOver)%10 + '0'));
                carryOver = (numa+carryOver)/10;
            }
        } else {
            for (int i=a.length; i<b.length; ++i) {
                var numb = b[i] - '0';
                ret.append((char)((numb+carryOver)%10 + '0'));
                carryOver = (numb+carryOver)/10;
            }
        }

        while (carryOver != 0) {
            ret.append((char)(carryOver + '0'));
            carryOver = carryOver / 10;
        }
        return ret.reverse().toString();
    }

    private char[] rev(char[] arr) {
        var len = arr.length;
        var ret = new char[len];
        for (int i=0; i<len; ++i) {
            ret[len-1-i] = arr[i];
        }
        return ret;
    }
}
