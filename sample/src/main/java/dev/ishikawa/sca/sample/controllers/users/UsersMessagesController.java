package dev.ishikawa.sca.sample.controllers.users;

import com.google.gson.Gson;
import dev.ishikawa.sca.sample.applications.services.MessageService;
import dev.ishikawa.sca.sample.controllers.BaseController;
import dev.ishikawa.sca.sample.domains.entities.MessageEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO: え、同一名ってあかんのか

@Slf4j
@RequestMapping("/v1/sample/users/{userId}/messages")
@RestController
@AllArgsConstructor
public class UsersMessagesController extends BaseController {
    private MessageService messageService;
    static private Gson gson = new Gson();

    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<String> index(@PathVariable("userId") Long userId) {
        String key = String.format("USER_ID::%d", userId);
        List<MessageEntity> messages = messageService.getFromList(key, MessageEntity.class);
        return buildResponse(gson.toJson(messages));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{messageId}")
    public ResponseEntity<String> show(
            @PathVariable("userId") Long userId,
            @PathVariable("messageId") Long messageId
    ) {
//        String key = String.format("USER_ID::%d", userId);
//        String val = redisService.get(key);
//        if (Objects.isNull(val)) {
//            val = "blank";
//        }
//        String response = String.format("user(id: %d)'s message box is: %s", userId, val);
        return buildResponse("TODO");
    }
}
