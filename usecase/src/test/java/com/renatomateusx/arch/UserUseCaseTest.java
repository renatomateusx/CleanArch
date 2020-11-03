package com.renatomateusx.arch;

import com.renatomateusx.arch.User.IUserOut;
import com.renatomateusx.arch.User.dto.UserOut;
import com.renatomateusx.arch.ports.UserAdapter;
import com.renatomateusx.arch.user.dto.UserIn;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.security.auth.Subject;
import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class UserUseCaseTest {

    @InjectMocks
    private UserUseCase subject;

    @Mock
    private IUserOut userOut;
    @Mock
    private UserAdapter userAdapter;


    @Test
    public void getAll(){
        UUID uuidOne = UUID.randomUUID();
        UUID uuidTwo = UUID.randomUUID();
        List<UserOut> listOut = Arrays.asList(new UserOut(uuidOne, "Renato Moura"), new UserOut(uuidTwo, "Renato Mateus"));
        List<UserIn> listIn = Arrays.asList(new UserIn(uuidOne, "Renato Moura"), new UserIn(uuidTwo, "Renato Mateus"));
        Mockito.when(userOut.getAll()).thenReturn(listOut);
        Mockito.when(userAdapter.toInputList(listOut)).thenReturn(listIn);
        subject.getAll();
        Assertions.assertTrue(listIn.size() == 2);
    }

    @Test
    public void getById(){
        UUID uuidOne = UUID.randomUUID();
        UserOut userMockOut = new UserOut(uuidOne, "Renato Moura");
        UserIn userIn = new UserIn(uuidOne, "Renato Moura");
        Mockito.when(userOut.findByUUID(uuidOne)).thenReturn(userMockOut);
        Mockito.when(userAdapter.toInput(userMockOut)).thenReturn(userIn);
        subject.getUserById(uuidOne);
        Assertions.assertTrue(userIn.getId() == uuidOne);

    }

    @Test
    public void save(){
        UUID uuidOne = UUID.randomUUID();
        UserOut userMockOut = new UserOut(uuidOne, "Renato Moura");
        UserIn userIn = new UserIn(uuidOne, "Renato Moura");
        subject.save(userIn);
        Mockito.verify(userOut, Mockito.times(1))
                .saveUser(userAdapter.toOutput(userIn));
    }

}
