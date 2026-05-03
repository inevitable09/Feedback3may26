package com.rudra.Feedback;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    private final FeedbackDAO dao;

    private FeedbackService(FeedbackDAO dao) {
        this.dao = dao;
    }

    public String save(Feedback f) {
        try {
            dao.save(f);
            return "Feedback saved successfully";
        }
        catch (Exception e) {
            return "Error occurred while saving feedback";
        }
    }

    public List<Feedback> getAll() {
        return dao.getAll();
    }
}
