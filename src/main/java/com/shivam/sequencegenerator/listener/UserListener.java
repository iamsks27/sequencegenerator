package com.shivam.sequencegenerator.listener;

import com.shivam.sequencegenerator.bean.User;
import com.shivam.sequencegenerator.daos.SequenceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

/**
 * @author sksingh created on 27/12/23
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserListener extends AbstractMongoEventListener<User> {

    private final SequenceRepository sequenceRepository;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<User> event) {
        if (event.getSource().getUserId() == null) {
            event.getSource().setUserId(sequenceRepository.generateSequence(User.SEQ_NAME));
        }

    }
}
