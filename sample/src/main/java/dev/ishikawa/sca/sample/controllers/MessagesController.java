package dev.ishikawa.sca.sample.controllers;

import com.google.gson.Gson;
import dev.ishikawa.sca.sample.applications.services.MessageService;
import dev.ishikawa.sca.sample.controllers.requests.CreateMessageRequest;
import dev.ishikawa.sca.sample.domains.entities.MessageEntity;
import dev.ishikawa.sca.sample.infrastructure.database.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Slf4j
@RequestMapping("/v1/sample/messages")
@RestController
@AllArgsConstructor
public class MessagesController extends BaseController {
    static Gson gson = new Gson();
    private MessageService messageService;
    private MessageRepository messageRepository;

    @RequestMapping(method = RequestMethod.DELETE, path = "/{messageId}")
    public ResponseEntity<String> destroy(@PathVariable("messageId") String messageId) {
        Gson gson = new Gson();

        for (int i = 0; i < 10; i++) {
            System.out.println("detected?: i");
            for (int j = 0; j < 10; j++) {
                System.out.println("detected?: j");
                for (int k = 0; k < 10; k++) {
                    System.out.println("detected?: k");
                    for (int l = 0; l < 10; l++) {
                        System.out.println("detected?: l");
                        for (int m = 0; m < 10; m++) {
                            System.out.println("detected?: m");
                        }
                    }
                }
            }
        }

        String valNotUsed = "should be detected";

        MessageEntity messageEntity = messageRepository.findByEncryptedId(messageId);
        messageRepository.delete(messageEntity);
        return buildResponse(gson.toJson(messageEntity));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<String> create(
            @RequestBody @NotNull CreateMessageRequest request
    ) {
        String key = String.format("USER_ID::%d", request.getReceiverId());
        MessageEntity message = MessageEntity.builder()
                .receiverId(request.getReceiverId())
                .senderId(request.getSenderId())
                .body(request.getBody())
                .sentAt(LocalDateTime.now()).build();
        messageRepository.save(message);
        messageService.addToList(key, message);

        return buildResponse(gson.toJson(message));
    }
}
