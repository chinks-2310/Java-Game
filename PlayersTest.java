import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    void test_setEmail() {
        String email="chintanjehani12345@gmail.com";
        int BankRoll=1500;
        String userName="Chintan";
        Players p1=new Players(email,BankRoll,userName);
        String result=p1.getEmail();
        Assert.assertEquals(email,result);
    }

    @Test
    void test_getEmail() {
        String email="chintanjehani12345@gmail.com";
        int BankRoll=1500;
        String userName="Chintan";
        Players p1=new Players(email,BankRoll,userName);
        String result=p1.getEmail();
        Assert.assertEquals("chintanjehani12345@gmail.com",result);
    }

    @Test
    void test_setBankRoll() {
        String email="chintanjehani12345@gmail.com";
        int BankRoll=1500;
        String userName="Chintan";
        Players p1=new Players(email,BankRoll,userName);
        int result=p1.getBankRoll();
        Assert.assertEquals(BankRoll,result);
    }

    @Test
    void getBankRoll() {
        String email="chintanjehani12345@gmail.com";
        int BankRoll=1500;
        String userName="Chintan";
        Players p1=new Players(email,BankRoll,userName);
        int result=p1.getBankRoll();
        Assert.assertEquals(1500,result);
    }

    @Test
    void test_setUserName() {
        String email="chintanjehani12345@gmail.com";
        int BankRoll=1500;
        String userName="Chintan";
        Players p1=new Players(email,BankRoll,userName);
        String result=p1.getUserName();
        Assert.assertEquals(userName,result);
    }

    @Test
    void getUserName() {
        String email="chintanjehani12345@gmail.com";
        int BankRoll=1500;
        String userName="Chintan";
        Players p1=new Players(email,BankRoll,userName);
        String result=p1.getUserName();
        Assert.assertEquals("Chintan",result);
    }
}