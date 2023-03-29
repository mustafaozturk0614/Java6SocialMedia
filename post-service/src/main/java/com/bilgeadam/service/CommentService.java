package com.bilgeadam.service;

import com.bilgeadam.repository.ICommnetRepository;
import com.bilgeadam.repository.IPostRepository;
import com.bilgeadam.repository.entity.Comment;
import com.bilgeadam.repository.entity.Post;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends ServiceManager<Comment,String> {
    private final ICommnetRepository commentRepository;
    public CommentService(ICommnetRepository commentRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }
}
