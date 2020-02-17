package com.example.restservice.presentation;

import com.example.restservice.domain.Message;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("messages")
public class MessagesRestController {

  final List<Message> messages = new CopyOnWriteArrayList<>();

  private final JdbcTemplate jdbcTemplate;

  public MessagesRestController(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Message> getMessages() {
    return jdbcTemplate.query(
        "SELECT text FROM messages ORDER BY id",
        (rs, i) -> {
          Message m = new Message();
          m.setText((rs.getString("text")));
          return m;
        });
  }

  @RequestMapping(method = RequestMethod.POST)
  public Message postMessage(@RequestBody Message message) {
    jdbcTemplate.update("INSERT INTO messages(text) VALUES (?)", message.getText());
    return message;
  }
}
