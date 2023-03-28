package com.bilgeadam.service;

import com.bilgeadam.repository.IFollowRepository;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class FollowService extends ServiceManager {

    private final IFollowRepository followRepository;

    public FollowService(IFollowRepository followRepository) {
        super(followRepository);
        this.followRepository = followRepository;
    }
}
