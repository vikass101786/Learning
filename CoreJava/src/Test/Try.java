package Test;

import java.io.IOException;

class C {
    public float m(float x, float y) throws IOException {
        return 0;
    }
}

 class D extends C {
    @Override
    public float m(float x, float x) throws Exception {return 0;}
}

public class Try {
    public static void main(String[] args) {
    	try {
    	    int c = 1/0;
    	} catch (Exception e) {
    	    System.out.println("E");
    	} finally {
    	    System.out.println("F");
    	}
    }
}