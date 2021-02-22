import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TablesTest {

    @Test
    void test_setName() {
        String tableName="Earth";
        int betSize=1000;
        Tables t1=new Tables(tableName,betSize);
        String result=t1.getName();
        Assert.assertEquals(tableName,result);
    }

    @Test
    void test_getName() {
        String tableName="Earth";
        int betSize=1000;
        Tables t1=new Tables(tableName,betSize);
        String result=t1.getName();
        Assert.assertEquals("Earth",result);
    }

    @Test
    void test_setBetSize() {
        String tableName="Earth";
        int betSize=1000;
        Tables t1=new Tables(tableName,betSize);
        int result=t1.getBetSize();
        Assert.assertEquals(betSize,result);
    }

    @Test
    void test_getBetSize() {
        String tableName="Earth";
        int betSize=1000;
        Tables t1=new Tables(tableName,betSize);
        int result=t1.getBetSize();
        Assert.assertEquals(1000,result);
    }
}