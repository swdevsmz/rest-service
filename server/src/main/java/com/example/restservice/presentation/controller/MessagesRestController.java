package com.example.restservice.presentation.controller;

import com.example.restservice.domain.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("messages")
public class MessagesRestController {

  private final JdbcTemplate jdbcTemplate;

  public MessagesRestController(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * メッセージを取得します.
   *
   * @return メッセージ
   */
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

  /**
   * メッセージを投稿します.
   *
   * @param message メッセージ
   * @return メッセージ
   */
  @RequestMapping(method = RequestMethod.POST)
  public Message postMessage(@RequestBody Message message) {
    jdbcTemplate.update("INSERT INTO messages(text) VALUES (?)", message.getText());
    return message;
  }
}
