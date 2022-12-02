package jason.springframework.petclinicdata.service;

public interface AbstractService<T,ID> {
    T loginService(String userName,String password);
    int registService(T t);
}
