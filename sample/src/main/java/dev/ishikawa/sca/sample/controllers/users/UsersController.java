package dev.ishikawa.sca.sample.controllers.users;

import com.google.gson.Gson;
import dev.ishikawa.sca.sample.controllers.BaseController;
import dev.ishikawa.sca.sample.controllers.requests.CreateUserRequest;
import dev.ishikawa.sca.sample.domains.entities.UserEntity;
import dev.ishikawa.sca.sample.infrastructure.database.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Slf4j
@RequestMapping("/v1/sample/users")
@RestController
@AllArgsConstructor
public class UsersController extends BaseController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<String> index() {
        Gson gson = new Gson();
        UserEntity user = UserEntity.builder().userName("test1").build();
        userRepository.save(user);
        return buildResponse(gson.toJson(user));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}")
    public ResponseEntity<String> show(@PathVariable("userId") Long userId) {
        String response = String.format("show userId: %s", userId);
        return buildResponse(response);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{userId}")
    public ResponseEntity<String> update(@PathVariable("userId") Long userId) {
        String response = String.format("update userId: %s", userId);
        return buildResponse(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{userId}")
    public ResponseEntity<String> destroy(@PathVariable("userId") Long userId) {
        String response = String.format("delete userId: %s", userId);
        return buildResponse(response);
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<String> create(
            @RequestBody @NotNull CreateUserRequest request
    ) {
        String response = String.format("create name: %s", request.getName());
        return buildResponse(response);
    }

}
