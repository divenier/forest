package com.rymcu.vertical.service.impl;

import com.rymcu.vertical.core.constant.NotificationConstant;
import com.rymcu.vertical.core.service.AbstractService;
import com.rymcu.vertical.dto.UserDTO;
import com.rymcu.vertical.entity.Follow;
import com.rymcu.vertical.entity.User;
import com.rymcu.vertical.mapper.FollowMapper;
import com.rymcu.vertical.service.FollowService;
import com.rymcu.vertical.util.NotificationUtils;
import com.rymcu.vertical.util.UserUtils;
import com.rymcu.vertical.web.api.exception.BaseApiException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ronger
 */
@Service
public class FollowServiceImpl extends AbstractService<Follow> implements FollowService {

    @Resource
    private FollowMapper followMapper;

    @Override
    public Boolean isFollow(Integer followingId, String followingType) throws BaseApiException {
        User tokenUser = UserUtils.getCurrentUserByToken();
        Boolean b = followMapper.isFollow(followingId, tokenUser.getIdUser(), followingType);
        return b;
    }

    @Override
    public Boolean follow(Follow follow) throws BaseApiException {
        User tokenUser = UserUtils.getCurrentUserByToken();
        follow.setFollowerId(tokenUser.getIdUser());
        int result = followMapper.insertSelective(follow);
        if (result > 0) {
            NotificationUtils.saveNotification(follow.getFollowingId(), follow.getIdFollow(), NotificationConstant.Follow, tokenUser.getNickname() + " 关注了你!");
        }
        return result > 0;
    }

    @Override
    public Boolean cancelFollow(Follow follow) throws BaseApiException {
        User tokenUser = UserUtils.getCurrentUserByToken();
        follow.setFollowerId(tokenUser.getIdUser());
        int result = followMapper.delete(follow);
        return result == 0;
    }

    @Override
    public List<Follow> findByFollowingId(String followType, Integer followingId) {
        Follow follow = new Follow();
        follow.setFollowingType(followType);
        follow.setFollowingId(followingId);
        return followMapper.select(follow);
    }

    @Override
    public List<UserDTO> findUserFollowersByUser(UserDTO userDTO) {
        List<UserDTO> list = followMapper.selectUserFollowersByUser(userDTO.getIdUser());
        return list;
    }

    @Override
    public List<UserDTO> findUserFollowingsByUser(UserDTO userDTO) {
        List<UserDTO> list = followMapper.selectUserFollowingsByUser(userDTO.getIdUser());
        return list;
    }
}
