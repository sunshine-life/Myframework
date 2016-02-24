package Test;

import java.util.Random;

/**
 * Created by life on 2016/1/25.
 */
public class Test {

        Random rand = new Random(47);
        final int i = rand.nextInt(20);

        public int getI() {
            return i;
        }

    public static void main(String []args){
        Test h = new Test();
        System.out.println(h.getI());

    }
}
