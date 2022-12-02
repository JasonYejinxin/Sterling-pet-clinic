package jason.springframework.petclinicdata.service.serviceImpl;

import jason.springframework.petclinicdata.model.Owner;
import jason.springframework.petclinicdata.repository.OwnerDao;
import jason.springframework.petclinicdata.service.OwnerService;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Resource
    private OwnerDao ownerDao;

    public boolean emailValidOrNot(Owner owner){
        boolean flag = false;
        String email = owner.getEmail();

        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(email);
        if(m.matches()){
            flag = true;
        }
        return flag;
    }
    @Test
    public void test1(){
        Owner newOwner1 = new Owner();
        Owner newOwner2 = new Owner();
        Owner newOwner3 = new Owner();
        newOwner1.setEmail("jason123@gmail.com");
        newOwner2.setEmail("jason123@qweqw212312.com");
        newOwner3.setEmail("jason12qweq");

        if(emailValidOrNot(newOwner1)){
            System.out.println("jason123@gmail.com is a valid email");
        }
        else {
            System.out.println( "jason123@gmail.com is not a valid email");
        }

        if(emailValidOrNot(newOwner2)){
            System.out.println("jason123@qweqw212312.com is a valid email");
        }
        else {
            System.out.println( "jason123@qweqw212312.com is not a valid email");
        }

        if(emailValidOrNot(newOwner3)){
            System.out.println("jason12qweq is a valid email");
        }
        else {
            System.out.println("jason12qweq is not a valid email");
        }
    }


    @Override
    public Owner loginService(String email, String password) {
        Owner owner = ownerDao.findByEmailAndPassword(email,password);

        if(owner != null){
            //keep secret
            owner.setPassword("");
        }
        return owner;
    }

    @Override
    public int registService(Owner owner) {
        //uname existed or email not fit reEx
        if(!ownerDao.findByEmail(owner.getEmail()).isEmpty() || !emailValidOrNot(owner)){
            return 0;
        }else{
            int suc = ownerDao.insertOwner(owner.getEmail(),owner.getPassword(),owner.getAddress(),owner.getCity(),owner.getTelephone());
            if(suc < 1 ){
                //insert failed
                return 1;
            }
            //insert success
            return 2;
        }
    }


}
