import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardsTest {

    @Test
    void testToString() {
        Suits s1=Suits.CLUB;
        Values v1=Values.TWO;
        Cards c1=new Cards(s1,v1);
        String ans=c1.toString();
        Assert.assertEquals("CLUB-TWO",ans);
    }

    @Test
    void testToStringForMultipleCards() {
        Suits s1=Suits.CLUB;
        Values v1=Values.TWO;
        Cards c1=new Cards(s1,v1);
        Suits s2=Suits.HEART;
        Values v2=Values.ACE;
        Cards c2=new Cards(s2,v2);
        String a1=c1.toString();
        String a2=c2.toString();
        String ans=a1+"\n"+a2;
        Assert.assertEquals("CLUB-TWO"+"\n"+"HEART-ACE",ans);
    }

    @Test
    void test_getValues() {
        Suits s1=Suits.CLUB;
        Values v1=Values.TWO;
        Cards c1=new Cards(s1,v1);
        String v2=c1.valuesToString();
        Assert.assertEquals("TWO",v2);
    }

    @Test
    void test_getSuits() {
        Suits s1=Suits.HEART;
        Values v1=Values.KING;
        Cards c1=new Cards(s1,v1);
        String v2=c1.suitsToString();
        Assert.assertEquals("HEART",v2);
    }
}