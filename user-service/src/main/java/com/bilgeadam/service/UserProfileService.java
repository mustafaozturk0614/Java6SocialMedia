package com.bilgeadam.service;

import com.bilgeadam.dto.request.NewCreateUserRequestDto;
import com.bilgeadam.dto.request.UserProfileUpdateRequestDto;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.UserManagerException;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.IUserProfileRepository;
import com.bilgeadam.repository.entity.UserProfile;
import com.bilgeadam.repository.enums.EStatus;
import com.bilgeadam.utility.JwtTokenManager;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> {

    private final IUserProfileRepository userProfileRepository;

    private final JwtTokenManager jwtTokenManager;

    public UserProfileService(IUserProfileRepository userProfileRepository, JwtTokenManager jwtTokenManager) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
        this.jwtTokenManager = jwtTokenManager;
    }

    public Boolean createUser(NewCreateUserRequestDto dto) {
        try {
            save(IUserMapper.INSTANCE.toUserProfile(dto));
            return  true;
        }catch (Exception e){
            throw  new UserManagerException(ErrorType.USER_NOT_CREATED);
        }

    }

    public Boolean activateStatus(Long authId) {
        Optional<UserProfile> userProfile=userProfileRepository.findOptionalByAuthId(authId);
        if (userProfile.isEmpty()){
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
        userProfile.get().setStatus(EStatus.ACTIVE);
        update(userProfile.get());
        return true;
    }



    public Boolean update(UserProfileUpdateRequestDto dto){
        Optional<Long> authId=jwtTokenManager.getIdFromToken(dto.getToken());
        if (authId.isEmpty()){
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<UserProfile> userProfile=userProfileRepository.findOptionalByAuthId(authId.get());
        if (userProfile.isEmpty()){
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
        userProfile.get().setPhone(dto.getPhone());
        userProfile.get().setAvatar(dto.getAvatar());
        userProfile.get().setAddress(dto.getAddress());
        userProfile.get().setEmail(dto.getEmail());
        userProfile.get().setAbout(dto.getAbout());
        update(userProfile.get());
        return  true;
    }
}
