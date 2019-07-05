package lock.singlelock;

import lock.Lock;

import java.util.ArrayList;
import java.util.List;

public class ShareObject {

    private Lock singleLock = new SingleLock();

    private List<Character> chars = new ArrayList<>();

    

}
