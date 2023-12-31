package com.sdu.irlab.chatlabelling.datasource.repository;

import com.sdu.irlab.chatlabelling.common.MessageType;
import com.sdu.irlab.chatlabelling.datasource.domain.Conversation;
import com.sdu.irlab.chatlabelling.datasource.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDAO extends JpaRepository<Message, Long> {
    public int countByConversation(Conversation conversation);

    public List<Message> findMessageByConversationOrderByCreateTimeDesc(Conversation conversation);
    public List<Message> findMessageByConversationAndTypeIsNotOrderByCreateTimeDesc(Conversation conversation, MessageType type);

//     @Query("SELECT m FROM Message m WHERE m.conversation = :conversation AND JSON_CONTAINS(m.action, :actionValue)")
    public Message findMessageByConversationAndActionOrderByCreateTimeDesc(Conversation conversation, String actionValue);

}
