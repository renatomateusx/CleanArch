import com.renatomateusx.user.IUser;
import com.renatomateusx.user.dto.IUser;
import com.renatomateusx.user.dto.RequestUserWebDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
class UserController {

    @Autowired
    private IUser user;

    @GetMapping("/{id}")
    public ResponseEntity<UserWebDTO> getUser(@PathVariable RequestUserWebDTO requestUserWebDTO){
        return ResponseEntity.Ok(user.getUserById(requestUserWebDTO.toInput()).toWebDTO());
    }
}
